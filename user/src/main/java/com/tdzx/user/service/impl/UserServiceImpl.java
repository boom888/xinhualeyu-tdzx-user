package com.tdzx.user.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tdzx.user.controller.UserController;
import com.tdzx.user.dao.BusiStudentinfoMapper;
import com.tdzx.user.dao.DzBusiStudentinfoMapper;
import com.tdzx.user.dao.MemberMapper;
import com.tdzx.user.dao.UserMapper;
import com.tdzx.user.domain.*;
import com.tdzx.user.service.UserService;
import com.tdzx.user.utils.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.KeyPair;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Value("${TEL_CODE_KEY}")
    private String tel_code_key;

    @Value("${TEL_CODE_EXPIRE}")
    private int tel_code_expire;

    @Value("${SEND_CODE_KEY}")
    private String send_code_key;

    @Value("${SEND_CODE_EXPIRE}")
    private int send_code_expire;

    @Resource
    UserMapper userMapper;
    @Resource
    MemberMapper memberMapper;
    @Resource
    BusiStudentinfoMapper busiStudentinfoMapper;
    @Resource
    DzBusiStudentinfoMapper dzBusiStudentinfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Override
    public CommonResult<Boolean> sendTelCode(String ip, String telphone, String templateCode) {
        CommonResult<Boolean> commonResult = new CommonResult<>();
        int times = 5;
        // 查询缓存中当前IP半小时内发送的次数
        int useTimes = 0;
        //String send_code_keyStr = send_code_key + ip;
        // send_code_key：同一IP发送验证码次数
        String send_code_keyStr = send_code_key + telphone;
        try {
            // s：该用户的发送次数
            String s = JedisUtils.get(send_code_keyStr);
            //判断是否为空 并赋值
            useTimes = StringUtils.isEmpty(s) ? 0 : Integer.parseInt(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        // 如果次数大于 5 次
        if (useTimes > times) {
            // -10003：次数过多
            commonResult.setCode(Constant.SEND_CODE_TIMES_ERROR_CODE);
            commonResult.setData(false);
            commonResult.setMessage(Constant.SEND_CODE_TIMES_ERROR_MSG);
            return commonResult;
        }

        //生成验证码
        Random random = new Random();
        String code = random.nextInt(1000000) + "";
        int randLength = code.length();
        if (randLength < 6) {
            for (int i = 1; i <= 6 - randLength; i++)
                code = "0" + code;
        }
        logger.info("手机号码:{},验证码为:{}", telphone, code);

        String resultStr = "";
        // 这里加入 发送短信 的功能
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>开始发送短信");
        try {
            resultStr = ALiYunDuanXinUtils.SendSms(telphone, code, templateCode);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>发送短信成功");

        try {
            if (resultStr.equalsIgnoreCase("FAILED")) {
                // -1
                commonResult.setCode(Constant.SEND_CODE_FAIL_CODE);
                // 发送失败,短信发送频繁
                commonResult.setData(false);
                // 短信发送失败
                commonResult.setMessage(Constant.SEND_CODE_FAIL_CODE_MSG);
                return commonResult;
            }
            if (resultStr.equalsIgnoreCase("MOREFAILED")) {
                // -1
                commonResult.setCode(Constant.SEND_CODE_FAIL_CODE);
                // 400, "异常"
                commonResult.setData(false);
                // 发送失败,短信发送频繁
                commonResult.setMessage(Constant.SEND_CODE_FAIL_CODEMORE_MSG);
                return commonResult;
            }
        } catch (Exception e) {
            // -1
            commonResult.setCode(Constant.SEND_CODE_FAIL_CODE);
            // 400, "异常"
            commonResult.setData(false);
            // 短信发送失败
            commonResult.setMessage(Constant.SEND_CODE_FAIL_CODE_MSG);
            return commonResult;
        }

        JedisUtils.hset(tel_code_key, telphone, code);
        //设置的是 tel_code_key(验证码的信息) 的存活时间
        JedisUtils.expire(tel_code_key, tel_code_expire);
        String hget = JedisUtils.hget(tel_code_key, telphone);
        int expireTime = send_code_expire;
        //检查给定 send_code_keyStr(请求次数) 是否存在
        Boolean exists = JedisUtils.exists(send_code_keyStr);
        if (exists)
            //获取键到期的剩余时间
            expireTime = Math.toIntExact(JedisUtils.getExpire(send_code_keyStr));
        // 设置 请求次数 的 次数
        JedisUtils.set(send_code_keyStr, String.valueOf(++useTimes));
        // 设置 send_code_keyStr(请求次数) 生存时间
        JedisUtils.expire(send_code_keyStr, expireTime);

        commonResult.setCode(Constant.SEND_CODE_SUCCESS_CODE);
        commonResult.setData(true);
        commonResult.setMessage(Constant.SEND_CODE_SUCCESS_CODE_MSG);
        return commonResult;
    }

    @Override
    public int mainUserRegistry(String fTel, String fCode, String fPwd) {
        try {
            String correctCode = getVerificationCode(fTel); //redis里面正确的验证码
            if(!correctCode.equals(fCode)){ //验证码错误
                return 3;
            }
            //判断该用户是否注册主账号
            TdzxMainUser mainUser = userMapper.findMainUserByTel(fTel);
            if (mainUser!=null){
                return 2;
            }

            TdzxMainUser mainUserParam = new TdzxMainUser();
            mainUserParam.setfMobile(fTel);
            mainUserParam.setfPassWord(AESUtil.encrypt(fPwd));
            mainUserParam.setfName("TDZX" + RandomUtil.generateNumber(10));   //平台分配默认昵称
            mainUserParam.setfCreateTime(System.currentTimeMillis()/1000+"");
            int k = userMapper.insertMainUser(mainUserParam);
            if (k>0){   //注册成功
                return 1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public String getVerificationCode(String account) {
        return JedisUtils.hget(tel_code_key, account);
    }

    @Override
    public TdzxMainUser findMainUserByTel(String tel) {
        return userMapper.findMainUserByTel(tel);
    }


    @Override
    public String CreateToken(String fInnerID) {
        String token = null;
        try {
            //生成公钥和私钥
            KeyPair keyPair = RSAUtil.getKeyPair();
            String privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
            String publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
            //公钥加密主用户ID
            token = RSAUtil.encrypt(fInnerID, RSAUtil.getPublicKey(publicKey));
            System.out.println("加密后内容:" + token);
            //将私钥和token放入缓存中
            JedisUtils.set(token,privateKey);
            JedisUtils.expire(token,30*60*1000);    //30分钟有效期
        }catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }

    @Override
    public CommonResult<Map<String,Object>> mainUserLogin(String fTel, String fCode, String fPwd) {
        CommonResult<Map<String,Object>> commonResult = new CommonResult<>();
        Map<String,Object> map = new HashMap<>();
        TdzxMainUser mainUser = new TdzxMainUser();
        try {
            if (fCode==null && fPwd!=null && !"".equals(fPwd)){
                //密码登陆
                mainUser = userMapper.findMainUserByTel(fTel);
                if (mainUser==null){
                    commonResult.setCode(Constant.NUM_ZERO);
                    commonResult.setData(null);
                    commonResult.setMessage("手机号未注册");
                    return commonResult;
                }
                if (mainUser!=null && !AESUtil.encrypt(fPwd).equals(mainUser.getfPassWord())){
                    commonResult.setCode(Constant.NUM_ZERO);
                    commonResult.setData(null);
                    commonResult.setMessage(PromptMessage.ACC_PASS_ERR);
                    return commonResult;
                }
                if (mainUser.getfName()==null || "".equals(mainUser.getfName())){
                    //默认用户名
                    mainUser.setfName("TDZX" + RandomUtil.generateNumber(10));
                    userMapper.updateMainUser(mainUser);
                }

            }else if (fPwd==null && fCode!=null && !"".equals(fCode)){
                //验证码登陆
                String correctCode = getVerificationCode(fTel); //redis里面正确的验证码
                if (!fCode.equals(correctCode)){
                    commonResult.setCode(Constant.NUM_ZERO);
                    commonResult.setData(null);
                    commonResult.setMessage("验证码错误");
                    return commonResult;
                }

                mainUser = userMapper.findMainUserByTel(fTel);
                if (mainUser==null){
                    commonResult.setCode(Constant.NUM_ZERO);
                    commonResult.setData(null);
                    commonResult.setMessage("手机号未注册");
                    return commonResult;
                }
                if (mainUser.getfName()==null || "".equals(mainUser.getfName())){
                    //默认用户名
                    mainUser.setfName("TDZX" + RandomUtil.generateNumber(10));
                    userMapper.updateMainUser(mainUser);
                }
            }

            //是否是TBM会员
            UserMember userMember = userMapper.findUserMember(mainUser.getfInnerID());
            if (userMember==null){
                userMember = userMapper.findUserMemberFirst(mainUser.getfInnerID());
            }

            if (userMember==null){
                mainUser.setfDiscount(1);
                mainUser.setfIsMember(0);
            }else {
                mainUser.setfDiscount(userMember.getfDiscount()==null?1:userMember.getfDiscount().doubleValue());
                mainUser.setfIsMember(1);
            }


            //判断是否是电商大客户
            try {
                Map<String,String> mapParam = new HashMap<>();
                mapParam.put("userId",mainUser.getfInnerID()+"");
                JSONObject jsonObject = HttpUtils.doPostMethod(URLUtils.STOREURL+"/deliveryCardRecord/findCompanyUserByID",mapParam);
                if (jsonObject!=null && jsonObject.getInt("code")==1){
                    JSONObject json = jsonObject.getJSONObject("data");
                    mainUser.setfIsVip(1);
                    if (json!=null)
                        mainUser.setfVipDiscount(json.getDouble("discount"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            //同步TBM会员积分
           /* UserStore userStore = userMapper.findUserStore("1",mainUser.getfInnerID());
            List<UserMember> userMemberList = memberMapper.findMemberList(mainUser.getfInnerID());
            if (userMemberList!=null && userMemberList.size()>0){
                Map<String,String> mapParam = new HashMap<>();
                String sapToken = getSapToken();
                mapParam.put("Token",sapToken);
                mapParam.put("YWBMBH",userMemberList.get(0).getStoreSapId());
                mapParam.put("Mobile",userStore.getfMobile());
                mapParam.put("key","GetMemberInfo");
                JSONObject json = JSONObject.fromObject(HttpUtils.http(URLUtils.SAP_URL,mapParam));
                if (json!=null && "0".equals(json.getString("ResultCode"))){
                    int jf = JSONObject.fromObject(json.get("Data")).getInt("JF");
                    for (UserMember userMemberParam:userMemberList){
                        memberMapper.updateUserMemberJf(jf,userMemberParam.getfInnerID());
                    }
                }
            }*/

            BusiStudentinfo student = busiStudentinfoMapper.findStudentByAcctID(mainUser.getfInnerID());
            if (student!=null)
                mainUser.setWxID(student.getWxId());

            DzBusiStudentinfo dzBusiStudentinfo = dzBusiStudentinfoMapper.findDzStudentByAcctID(mainUser.getfInnerID());
            if (dzBusiStudentinfo!=null)
                mainUser.setCompanyID(dzBusiStudentinfo.getSchoolid());

            map.put("mainUser",mainUser);
            map.put("token",CreateToken(mainUser.getfInnerID()+""));
            commonResult.setCode(Constant.NUM_ONE);
            commonResult.setData(map);
            commonResult.setMessage(PromptMessage.OPERATE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            commonResult.setCode(Constant.NUM_ZERO);
            commonResult.setData(null);
            commonResult.setMessage(PromptMessage.ACC_PASS_ERR);
        }
        return commonResult;
    }

    @Override
    public TdzxMainUser findMainUserByToken(String token) throws Exception{
        //根据token从redis里拿到私钥
       String privateKey = JedisUtils.get(token);
       if (privateKey!=null && !"".equals(privateKey)){
            //私钥解密获取用户信息
           String fMainUserId = RSAUtil.decrypt(token, RSAUtil.getPrivateKey(privateKey));
           TdzxMainUser tdzxMainUser = userMapper.findMainUserByID(Integer.parseInt(fMainUserId));
           if (tdzxMainUser!=null){
               UserMember userMember = userMapper.findUserMember(Integer.parseInt(fMainUserId));
               /*if (userMember==null){
                   userMember = userMapper.findUserMemberFirst(Integer.parseInt(fMainUserId));
               }*/

               if (userMember==null){
                   tdzxMainUser.setfDiscount(1);
                   tdzxMainUser.setfIsMember(0);
               }else {
                   tdzxMainUser.setfDiscount(userMember.getfDiscount()==null?1:userMember.getfDiscount().doubleValue());
                   tdzxMainUser.setfIsMember(1);
                   int memberTypeID = userMember.getfMemTypeID();
                   if (memberTypeID==3){    //悦读会员
                       tdzxMainUser.setMemberType(1);
                   }else if (memberTypeID==4){  //悦享会员
                       tdzxMainUser.setMemberType(2);
                   }else if (memberTypeID==5){  //悦乐会员
                       tdzxMainUser.setMemberType(3);
                   }
               }

               //获取悦订网用户信息
               UserStore yueDingUser = userMapper.findUserStore("2",Integer.parseInt(fMainUserId));
               if (yueDingUser!=null){
                   yueDingUser.setfPwd(null);
                   tdzxMainUser.setYueDingUser(yueDingUser);
               }

               //获取会员卡信息
                List<UserMember> userMemberList= memberMapper.findMemberList(Integer.parseInt(fMainUserId));
                if (userMemberList!=null && userMemberList.size()>0){
                    int yueXiangIntegralNum = 0;
                    MemberType memberType = memberMapper.findMemberTypeByName("悦享会员");
                    if (memberType!=null) yueXiangIntegralNum = memberType.getfRequiredIntegral()==null?0:memberType.getfRequiredIntegral();

                    for (UserMember userMemberParam:userMemberList){
                        int integralNum = userMemberParam.getfIntegralNum()==null?0:userMemberParam.getfIntegralNum();
                        userMemberParam.setfMuchNum(yueXiangIntegralNum-integralNum);
                        userMemberParam.setfMemCardNum(userMemberParam.getfMemCardNum().replace(" ",""));
                    }
                   tdzxMainUser.setUserMemberList(userMemberList);
               }

               //获取储值卡信息
               List<UserMember> chuZhiCartList= memberMapper.findChuZhiCartList(Integer.parseInt(fMainUserId));
               tdzxMainUser.setChuZhiCartList(chuZhiCartList);

               //判断是否是电商大客户
               try {
                   Map<String,String> map = new HashMap<>();
                   map.put("userId",tdzxMainUser.getfInnerID()+"");
                   JSONObject jsonObject = HttpUtils.doPostMethod(URLUtils.STOREURL+"/deliveryCardRecord/findCompanyUserByID",map);
                   if (jsonObject!=null && jsonObject.getInt("code")==1){
                       JSONObject json = jsonObject.getJSONObject("data");
                       tdzxMainUser.setfIsVip(1);
                       if (json!=null)
                           tdzxMainUser.setfVipDiscount(json.getDouble("discount"));
                   }
               }catch (Exception e){
                   e.printStackTrace();
               }


               //获取提货卡数量
               int tiHuoCartCount = getTiHuoCartCount(tdzxMainUser.getfInnerID());
               tdzxMainUser.setTihuoCartCount(tiHuoCartCount);

               BusiStudentinfo student = busiStudentinfoMapper.findStudentByAcctID(tdzxMainUser.getfInnerID());
               if (student!=null)
                   tdzxMainUser.setWxID(student.getWxId());

               DzBusiStudentinfo dzBusiStudentinfo = dzBusiStudentinfoMapper.findDzStudentByAcctID(tdzxMainUser.getfInnerID());
               if (dzBusiStudentinfo!=null)
                   tdzxMainUser.setCompanyID(dzBusiStudentinfo.getSchoolid());

               //获取教材教辅孩子列表信息
               tdzxMainUser.setBusiStudentinfoList(busiStudentinfoMapper.findStudentListByAcctID(tdzxMainUser.getfInnerID()));
               //获取党政读物用户信息
               tdzxMainUser.setDzBusiStudentinfo(dzBusiStudentinfoMapper.findDzStudentByAcctID(tdzxMainUser.getfInnerID()));
           }
           return tdzxMainUser;
       }
        return null;
    }

    @Override
    public int updateMainUser(TdzxMainUser mainUser) {
        return userMapper.updateMainUser(mainUser);
    }

    @Override
    public int updateMainUserPwd(String fTel, String fCode, String fNewPwd) {
        String correctCode = getVerificationCode(fTel); //redis里面正确的验证码
        if (!fCode.equals(correctCode)){
            return 3;   //验证码错误
        }
        deleteCode(fTel);    //清验证码
        TdzxMainUser mainUser = userMapper.findMainUserByTel(fTel);
        if (mainUser==null){
            return 2;   //账号未注册
        }
        try {
            mainUser.setfPassWord(AESUtil.encrypt(fNewPwd));
            return userMapper.updateMainUser(mainUser);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int bindStoreUser(String token,String fType, String fStoreMobile, String fCode) {
        String a="";
        switch (a){
            case "b":
                System.err.println(1);
            case "c":
                System.err.println(2);
        }


        //根据token从redis里拿到私钥
        if (token==null || "".equals(token)){
            return 0;
        }
        String privateKey = JedisUtils.get(token);
        if (privateKey==null || "".equals(privateKey)){
            return 3;   //token过期
        }
        //判断验证码
        String correctCode = getVerificationCode(fStoreMobile);
        if (!fCode.equals(correctCode)){
            return 2;   //验证码错误
        }
        //根据业务类型  写 业务代码
        if ("1".equals(fType)){
            //调用门店系统  判断该手机号 是否是门店用户
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("mobile",fStoreMobile);
            try {
                JSONObject json = HttpUtils.doGetMethod(URLUtils.MMEMBER_URL,jsonObject.toString());
                if ("1".equals(json.get("status").toString())){     //调用成功
                    if (json.get("data")!=null){
                        JSONObject jsonParam = JSONObject.fromObject(json.get("data"));
                        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

                        String fMainUserId = RSAUtil.decrypt(token, RSAUtil.getPrivateKey(privateKey));
                        TdzxMainUser tdzxMainUser = userMapper.findMainUserByID(Integer.parseInt(fMainUserId));
                        //往子表里写入数据
                        UserStore userStore = new UserStore();
                        userStore.setfAcctID(tdzxMainUser.getfInnerID());
                        userStore.setfName(jsonParam.getString("memberName"));
                        userStore.setfSex(jsonParam.getInt("memberGender"));
                        userStore.setfBirthday(jsonParam.getString("memberBirthday"));
                        userStore.setfMobile(jsonParam.getString("memberMobile"));
                        userStore.setfCreateTime(sd.parse(jsonParam.getString("registerDate")).getTime()/1000+"");
                        userStore.setfIntegralNum(jsonParam.getDouble("currentPoint"));
                        userStore.setfConsumption(jsonParam.getDouble("consumption"));
                        int k = userMapper.insertUserStore(userStore);
                        if (k>0){
                            //根据会员名称查出对应的会员类型
                            MemberType memberType = memberMapper.findMemberTypeByName(jsonParam.getString("memberClassName"));
                            if (memberType!=null){
                                //往用户会员表里写数据
                                UserMember userMember = new UserMember();
                                userMember.setfAcctID(userStore.getfAcctID());
                                userMember.setfMemCardNum(jsonParam.getString("cardid"));
                                userMember.setfCreateDate(sd.parse(jsonParam.getString("registerDate")).getTime()/1000+"");
                                userMember.setfIndate(sd.parse(jsonParam.getString("indate")).getTime()/1000+"");
                                userMember.setfMemTypeID(memberType.getfInnerID());
                                userMember.setfDiscount(memberType.getfDiscount());
                                int m = memberMapper.insertUserMember(userMember);
                                logger.info("m------------------->>>>>"+m);
                                return m;
                            }
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //业务回滚
        DataUtil.rollBack();
        return 0;
    }


    @Override
    public CommonResult<Map<String,Object>> VXRegistry(String openID, String fTel,String fPwd, String fTelCode,
                                                       String fPic,String fName) {
        CommonResult<Map<String,Object>> commonResult = new CommonResult<>();
        Map<String,Object> map = new HashMap<>();
        //判断验证码
        String correctCode = getVerificationCode(fTel);
        if (!fTelCode.equals(correctCode)){
            commonResult.setCode(Constant.NUM_ZERO);
            commonResult.setData(null);
            commonResult.setMessage(PromptMessage.ACC_SMS_ERR);
            return commonResult;   //验证码错误
        }
        try {
            TdzxMainUser tdzxMainUser = userMapper.findMainUserByTel(fTel);
            if (tdzxMainUser==null){
                //插入用户表
                tdzxMainUser = new TdzxMainUser();
                tdzxMainUser.setfName(fName);
                tdzxMainUser.setfPic(fPic);
                tdzxMainUser.setfMobile(fTel);
                tdzxMainUser.setfPassWord(AESUtil.encrypt(fPwd));
                tdzxMainUser.setfCreateTime(System.currentTimeMillis()/1000+"");
                tdzxMainUser.setOpenID(openID);
                int k = userMapper.insertMainUser(tdzxMainUser);
            }else {
                if (tdzxMainUser.getfPic()==null || "".equals(tdzxMainUser.getfPic())){
                    tdzxMainUser.setfPic(fPic);
                }
                if (tdzxMainUser.getfName()==null || "".equals(tdzxMainUser.getfName())){
                    tdzxMainUser.setfName(fName);
                }
                tdzxMainUser.setOpenID(openID);
                userMapper.updateMainUser(tdzxMainUser);
            }
            tdzxMainUser.setOpenID(openID);
            map.put("mainUser",tdzxMainUser);
            map.put("token",CreateToken(tdzxMainUser.getfInnerID()+""));
            commonResult.setCode(Constant.NUM_ONE);
            commonResult.setData(map);
            commonResult.setMessage(PromptMessage.OPERATE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            commonResult.setCode(Constant.NUM_ZERO);
            commonResult.setData(null);
            commonResult.setMessage(PromptMessage.OPERATE_FAILD);
        }
        return commonResult;
    }


    /*@Override
    public Map<String, Object> getTokenAndOpenID(String code,String fPic,String fName) {
        Map<String, Object> map = new HashMap<>();
        //发送请求
        try {
            //调用微信接口  获取 token何openid
            Map<String, String> params = new HashMap<String, String>();
            params.put("appid", URLUtils.APPID);
            params.put("secret", URLUtils.APPSECRET);
            params.put("code", code);
            params.put("grant_type", "authorization_code");

            JSONObject jsonObject = HttpUtils.doPostMethod(URLUtils.ACCESS_TOKEN_BASE_URL,params);
            String accessToken = jsonObject.getString("access_token");
            String openID = jsonObject.getString("openid");
            String refreshToken = jsonObject.getString("refresh_token");

            //将信息存入临时数据表
            UserThirtyaccount userThirtyaccount = userMapper.findUserThirtyByOpenID(openID);
            if (userThirtyaccount==null){
                userThirtyaccount.setFopenid(openID);
                userThirtyaccount.setIcon(fPic);
                userThirtyaccount.setFname(fName);
                userMapper.insertUserThirty(userThirtyaccount);
            }

            TdzxMainUser mainUser= userMapper.findMainUserByOpenID(openID);

            map.put("access_token",accessToken);
            map.put("refresh_token",refreshToken);
            map.put("openid",openID);
            map.put("mainUser",mainUser);
            if (mainUser!=null){
                map.put("token",CreateToken(mainUser.getfInnerID()+""));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }*/

    /*@Override
    public Map<String, Object> loginByTokenAndOpenID(String access_token,String refresh_token, String openID,String fPic,String fName) {
        Map<String, Object> map = new HashMap<>();
        //验证access_token和openID是否有效
        Map<String, String> params = new HashMap<String, String>();
        params.put("access_token", access_token);
        params.put("openid", openID);
        try {
            JSONObject jsonObject = HttpUtils.doPostMethod(URLUtils.CHECKOUT_ACCESS_TOKEN_OPENID_URL,params);
            if ("0".equals(jsonObject.getString("errcode"))){   //有效
                TdzxMainUser tdzxMainUser = userMapper.findMainUserByOpenID(openID);
                if (tdzxMainUser!=null){
                    map.put("access_token",access_token);
                    map.put("refresh_token",refresh_token);
                    map.put("mainUser",tdzxMainUser);
                    map.put("token",CreateToken(tdzxMainUser.getfInnerID()+""));
                }else {
                    //记录下来
                    //将信息存入临时数据表
                    UserThirtyaccount userThirtyaccount = userMapper.findUserThirtyByOpenID(openID);
                    if (userThirtyaccount==null){
                        userThirtyaccount.setFopenid(openID);
                        userThirtyaccount.setIcon(fPic);
                        userThirtyaccount.setFname(fName);
                        userMapper.insertUserThirty(userThirtyaccount);
                    }
                }
            }else { //无效的时候 刷新access_token 有效期延长30天
                if (refresh_token!=null && !"".equals(refresh_token)){  //refresh_token还在
                    TdzxMainUser tdzxMainUser = userMapper.findMainUserByOpenID(openID);
                    if (tdzxMainUser!=null){    //续时 access_token的时间
                        Map<String, String> maps = new HashMap<String, String>();
                        maps.put("appid", URLUtils.APPID);
                        maps.put("grant_type", "refresh_token");
                        maps.put("refresh_token", refresh_token);
                        JSONObject json = HttpUtils.doPostMethod(URLUtils.REFRESH_TOKEN_OPENID_URL,params);
                        if (json.getString("access_token")!=null){
                            map.put("access_token",json.getString("access_token"));
                            map.put("refresh_token",json.getString("refresh_token"));
                            map.put("mainUser",tdzxMainUser);
                            map.put("token",CreateToken(tdzxMainUser.getfInnerID()+""));
                        }
                    }else {
                        //记录下来
                        //将信息存入临时数据表
                        UserThirtyaccount userThirtyaccount = userMapper.findUserThirtyByOpenID(openID);
                        if (userThirtyaccount==null){
                            userThirtyaccount.setFopenid(openID);
                            userThirtyaccount.setIcon(fPic);
                            userThirtyaccount.setFname(fName);
                            userMapper.insertUserThirty(userThirtyaccount);
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }*/

    @Override
    public Map<String,Object> loginByVX(String unionid, String openID, String fPic, String fName) {
        Map<String,Object> map = new HashMap<>();
        TdzxMainUser tdzxMainUser = userMapper.findMainUserByOpenID(openID);
        if (tdzxMainUser!=null){
            if (tdzxMainUser.getfPic()==null || "".equals(tdzxMainUser.getfPic())){
                if (fPic!=null && !"".equals(fPic)){
                    tdzxMainUser.setfPic(fPic);
                }
            }

            if (tdzxMainUser.getfName()==null || "".equals(tdzxMainUser.getfName())){
                if (fName!=null && !"".equals(fName)){
                    tdzxMainUser.setfName(fName);
                }else {
                    //默认用户名
                    tdzxMainUser.setfName("TDZX" + RandomUtil.generateNumber(10));
                }
            }


            //是否是TBM会员
            UserMember userMember = userMapper.findUserMember(tdzxMainUser.getfInnerID());
            if (userMember==null){
                userMember = userMapper.findUserMemberFirst(tdzxMainUser.getfInnerID());
            }

            if (userMember==null){
                tdzxMainUser.setfDiscount(1);
                tdzxMainUser.setfIsMember(0);
            }else {
                tdzxMainUser.setfDiscount(userMember.getfDiscount()==null?1:userMember.getfDiscount().doubleValue());
                tdzxMainUser.setfIsMember(1);
            }


            //判断是否是电商大客户
            try {
                Map<String,String> mapParam = new HashMap<>();
                mapParam.put("userId",tdzxMainUser.getfInnerID()+"");
                JSONObject jsonObject = HttpUtils.doPostMethod(URLUtils.STOREURL+"/deliveryCardRecord/findCompanyUserByID",mapParam);
                if (jsonObject!=null && jsonObject.getInt("code")==1){
                    JSONObject json = jsonObject.getJSONObject("data");
                    tdzxMainUser.setfIsVip(1);
                    if (json!=null)
                        tdzxMainUser.setfVipDiscount(json.getDouble("discount"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            //同步TBM会员积分
            /*UserStore userStore = userMapper.findUserStore("1",tdzxMainUser.getfInnerID());
            List<UserMember> userMemberList = memberMapper.findMemberList(tdzxMainUser.getfInnerID());
            if (userMemberList!=null && userMemberList.size()>0){
                Map<String,String> mapParam = new HashMap<>();
                String sapToken = getSapToken();
                mapParam.put("Token",sapToken);
                mapParam.put("YWBMBH",userMemberList.get(0).getStoreSapId());
                mapParam.put("Mobile",userStore.getfMobile());
                mapParam.put("key","GetMemberInfo");
                JSONObject json = JSONObject.fromObject(HttpUtils.http(URLUtils.SAP_URL,mapParam));
                if (json!=null && "0".equals(json.getString("ResultCode"))){
                    int jf = JSONObject.fromObject(json.get("Data")).getInt("JF");
                    for (UserMember userMemberParam:userMemberList){
                        memberMapper.updateUserMemberJf(jf,userMemberParam.getfInnerID());
                    }
                }
            }*/

            tdzxMainUser.setOpenID(openID);
            tdzxMainUser.setUnionID(unionid);
            userMapper.updateMainUser(tdzxMainUser);

            BusiStudentinfo student = busiStudentinfoMapper.findStudentByAcctID(tdzxMainUser.getfInnerID());
            if (student!=null)
                tdzxMainUser.setWxID(student.getWxId());

            DzBusiStudentinfo dzBusiStudentinfo = dzBusiStudentinfoMapper.findDzStudentByAcctID(tdzxMainUser.getfInnerID());
            if (dzBusiStudentinfo!=null)
                tdzxMainUser.setCompanyID(dzBusiStudentinfo.getSchoolid());

            map.put("mainUser",tdzxMainUser);
            map.put("token",CreateToken(tdzxMainUser.getfInnerID()+""));
            return map;
        }

        //将信息存入临时数据表
        UserThirtyaccount userThirtyaccount = userMapper.findUserThirtyByOpenID(openID);
        if (userThirtyaccount==null){
            userThirtyaccount = new UserThirtyaccount();
            userThirtyaccount.setFopenid(openID);
            userThirtyaccount.setFunionid(unionid);
            userThirtyaccount.setIcon(fPic);
            userThirtyaccount.setFname(fName);
            userMapper.insertUserThirty(userThirtyaccount);
        }
        return map;
    }

    @Override
    public int addUserAdress(String token,Integer fAdressID,String fReceiveName, String fReceiveTel, Integer fAdressType, String fProvince,
                             String fCity, String fArea, String fDetailAdress, Integer fIsDefaultAdress) {
        int m = 0;
        String privateKey = JedisUtils.get(token);
        if (privateKey==null || "".equals(privateKey)){
            return 3;   //token过期
        }
        try {
            String fMainUserId = RSAUtil.decrypt(token, RSAUtil.getPrivateKey(privateKey));

            if (fIsDefaultAdress==1){   //把其他地址取消默认地址
                userMapper.updateIsDefaultAdress(Integer.parseInt(fMainUserId));
            }
            UserAdress userAdress = new UserAdress();
            userAdress.setfAdressType(fAdressType);
            userAdress.setfProvince(fProvince);
            userAdress.setfCity(fCity);
            userAdress.setfArea(fArea);
            userAdress.setfDetailAdress(fDetailAdress);
            userAdress.setfIsDefaultAdress(fIsDefaultAdress);
            userAdress.setfReceiveTel(fReceiveTel);
            userAdress.setfReceiveName(fReceiveName);

            if (fAdressID==null || fAdressID==0){   //新增
                userAdress.setfAcctID(Integer.parseInt(fMainUserId));
                userAdress.setfCreateTime(System.currentTimeMillis()/1000+"");
                m = userMapper.insertAdress(userAdress);
            }else { //修改
                userAdress.setfInnerID(fAdressID);
                m = userMapper.updateUserAdress(userAdress);
            }
            return m;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public CommonResult<List<UserAdress>> selectUserAdress(String token) {
        CommonResult<List<UserAdress>> commonResult = new CommonResult<>();
        String privateKey = JedisUtils.get(token);
        if (privateKey==null || "".equals(privateKey)){
            commonResult.setCode(Constant.NUM_TWO);
            commonResult.setData(null);
            commonResult.setMessage(PromptMessage.TOKEN_PASS);
            return commonResult;
        }

        try {
            String fMainUserId = RSAUtil.decrypt(token, RSAUtil.getPrivateKey(privateKey));
            List<UserAdress> userAdressList = userMapper.findUserAdress(Integer.parseInt(fMainUserId));
            commonResult.setCode(Constant.NUM_ONE);
            commonResult.setData(userAdressList);
            commonResult.setMessage(PromptMessage.LOAD_SUCCESS);
            return commonResult;
        }catch (Exception e){
            e.printStackTrace();
        }
        commonResult.setCode(Constant.NUM_ZERO);
        commonResult.setData(null);
        commonResult.setMessage(PromptMessage.LOAD_FAIL);
        return commonResult;
    }


    @Override
    public CommonResult<UserAdress> getDeafaultUserAdress(String token) {
        CommonResult<UserAdress> commonResult = new CommonResult<>();
        String privateKey = JedisUtils.get(token);
        if (privateKey==null || "".equals(privateKey)){
            commonResult.setCode(Constant.NUM_TWO);
            commonResult.setData(null);
            commonResult.setMessage(PromptMessage.TOKEN_PASS);
            return commonResult;
        }

        try {
            String fMainUserId = RSAUtil.decrypt(token, RSAUtil.getPrivateKey(privateKey));
            UserAdress adress = userMapper.getDeafaultUserAdress(Integer.parseInt(fMainUserId));
            if (adress==null){
                adress = userMapper.getFirstUserAdress(Integer.parseInt(fMainUserId));
            }
            commonResult.setCode(Constant.NUM_ONE);
            commonResult.setData(adress);
            commonResult.setMessage(PromptMessage.LOAD_SUCCESS);
            return commonResult;
        }catch (Exception e){
            e.printStackTrace();
        }
        commonResult.setCode(Constant.NUM_ZERO);
        commonResult.setData(null);
        commonResult.setMessage(PromptMessage.LOAD_FAIL);
        return commonResult;
    }

    @Override
    public CommonResult<List<UserAdress>> selectUserAdressByUserID(String fMainUserID) {
        CommonResult<List<UserAdress>> commonResult = new CommonResult<>();
        List<UserAdress> userAdressList = userMapper.findUserAdress(Integer.parseInt(fMainUserID));
        commonResult.setCode(Constant.NUM_ONE);
        commonResult.setData(userAdressList);
        commonResult.setMessage(PromptMessage.LOAD_SUCCESS);
        return commonResult;
    }

    @Override
    public int deteleUserAdress(Integer fInnerID) {
        return userMapper.deteleUserAdress(fInnerID);
    }

    @Override
    public List<TdzxMainUser> getBatchMainUserInfo(String fAcctIDArr) {
        List<TdzxMainUser> tdzxMainUserList = userMapper.findMainUserByBatchID(fAcctIDArr);
        if (tdzxMainUserList!=null && tdzxMainUserList.size()>0){
            for (TdzxMainUser mainUser:tdzxMainUserList){
                UserMember userMember = memberMapper.findDefaultMember(mainUser.getfInnerID());
                if (userMember!=null){
                    mainUser.setfIsMember(1);
                    mainUser.setDefaultMemberCart(userMember.getfMemCardNum());
                }
            }
        }
        return tdzxMainUserList;
    }

    @Override
    public CommonResult<Double> getDiscountByUserID(String fMainUserID) {
        CommonResult<Double> commonResult = new CommonResult<>();
        UserMember userMember = userMapper.findUserMember(Integer.parseInt(fMainUserID));
        if (userMember==null){
            userMember = userMapper.findUserMemberFirst(Integer.parseInt(fMainUserID));
        }

        if (userMember==null){
            commonResult.setCode(Constant.NUM_ONE);
            commonResult.setData(0.0);
            commonResult.setMessage(PromptMessage.LOAD_SUCCESS);
        }else {
            commonResult.setCode(Constant.NUM_ONE);
            commonResult.setData(userMember.getfDiscount()==null?0.0:userMember.getfDiscount().doubleValue());
            commonResult.setMessage(PromptMessage.LOAD_SUCCESS);
        }
        return commonResult;
    }

    @Override
    public CommonResult<List<UserMember>> getMemberByUserID(String fMainUserID) {
        CommonResult<List<UserMember>> commonResult = new CommonResult<>();
        List<UserMember> userMemberList= userMapper.findChuZhiMember(Integer.parseInt(fMainUserID));
        try {
            for (UserMember userMember:userMemberList){
                userMember.setStoreName("全场通用");
                userMember.setfMemCardNum(userMember.getfMemCardNum().replace(" ",""));
                String storeNo = userMember.getStoreNo();
                JSONObject jsonObject = HttpUtils.doGetMethod(URLUtils.STOREURL+"/store/storeDetails/"+storeNo,null);
                if (jsonObject!=null && "200".equals(jsonObject.getString("code"))){
                    JSONObject json = jsonObject.getJSONObject("result");
                    if (json!=null && json.size()>0)     userMember.setStoreName(json.getString("enterpriseName"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        commonResult.setCode(Constant.NUM_ONE);
        commonResult.setData(userMemberList);
        commonResult.setMessage(PromptMessage.LOAD_SUCCESS);
        return commonResult;
    }

    @Override
    public UserStore registryYueDing(UserStore userStore) {
        int k = userMapper.registryYueDing(userStore);
        return userStore;
    }

    @Override
    public CommonResult<Map<String, Object>> loginYueDing(String fBussType,Integer fAcctID,String fName, String fPwd) {
        CommonResult<Map<String, Object>> commonResult = new CommonResult<>();
        Map<String, Object> objectMap = new HashMap<>();
        if ("2".equals(fBussType)){
            try {
                //判断这个用户名是不是绑定的这个用户
                int count = userMapper.findCountByName(fBussType,null,fName,null);
                if (count>0){
                    commonResult.setCode(Constant.NUM_ZERO);
                    commonResult.setMessage("该账号已被绑定");
                    return commonResult;
                }

                Map<String,String> map = new HashMap<>();
                map.put("loginName",fName);
                map.put("password",fPwd);
                JSONObject jsonObject = HttpUtils.doPostMethod(URLUtils.YUEDING_LOGIN_URL,map);
                if (jsonObject!=null && jsonObject.getInt("resCode")==1){
                    JSONObject json = JSONObject.fromObject(jsonObject.get("rows"));
                    String yuedingToken = json.getString("token");

                    //调用悦订网获取用户信息的接口
                    JSONObject jsonObjectInfo = HttpUtils.doGetMethod(URLUtils.YUEDING_GETINFO_URL,"token="+yuedingToken);
                    if (jsonObjectInfo!=null && "1".equals(jsonObjectInfo.getString("resCode"))){
                        JSONObject jsonObjectRows = jsonObjectInfo.getJSONObject("rows");
                        //数据同步到我们的数据库
                        UserStore userStoreParam = new UserStore();
                        userStoreParam.setfBussType(fBussType);
                        userStoreParam.setfAcctID(fAcctID);
                        userStoreParam.setfName(fName);
                        userStoreParam.setfRealName(jsonObjectRows.getString("trueName"));
                        if ("男".equals(jsonObjectRows.getString("gender"))){
                            userStoreParam.setfSex(1);
                        }else if ("女".equals(jsonObjectRows.getString("gender"))){
                            userStoreParam.setfSex(2);
                        }else {
                            userStoreParam.setfSex(0);
                        }

                        userStoreParam.setfArea(jsonObjectRows.getString("province")+jsonObjectRows.getString("cityName")+jsonObjectRows.getString("countyName"));
                        userStoreParam.setfSchool(jsonObjectRows.getString("schoolName"));
                        userStoreParam.setfGrade(jsonObjectRows.getString("gradeName"));
                        userStoreParam.setfClass(jsonObjectRows.getString("className"));
                        userStoreParam.setfDetailAdress(jsonObjectRows.getString("address"));
                        userStoreParam.setfMobile(jsonObjectRows.getString("telephone"));
                        userStoreParam.setfPwd(fPwd);
                        userStoreParam.setfCreateTime(System.currentTimeMillis()/1000+"");
                        userMapper.insertUserStore(userStoreParam);
                        objectMap.put("userStore",userStoreParam);
                    }
                    objectMap.put("yuedingToken",yuedingToken);
                    objectMap.put("yuedingUserStore",filterNull(json));
                    commonResult.setCode(Constant.NUM_ONE);
                    commonResult.setData(objectMap);
                    return commonResult;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        commonResult.setCode(Constant.NUM_ZERO);
        commonResult.setData(objectMap);
        System.err.println(commonResult);
        return commonResult;
    }


    @Override
    public CommonResult<Map<String, Object>> loginByMainUser(String fBussType,Integer fAcctID) {
        CommonResult<Map<String, Object>> commonResult = new CommonResult<>();
        Map<String, Object> objectMap = new HashMap<>();
        try {
            if ("2".equals(fBussType)){
                UserStore userStore = userMapper.findUserStore(fBussType,fAcctID);
                if (userStore!=null){
                    Map<String,String> map = new HashMap<>();
                    map.put("loginName",userStore.getfName());
                    map.put("password",userStore.getfPwd());
                    JSONObject jsonObject = HttpUtils.doPostMethod(URLUtils.YUEDING_LOGIN_URL,map);
                    if (jsonObject!=null && jsonObject.getInt("resCode")==1){
                        JSONObject json = JSONObject.fromObject(jsonObject.get("rows"));
                        String yuedingToken = json.getString("token");
                        objectMap.put("yuedingToken",yuedingToken);
                        objectMap.put("userStore",userStore);
                        objectMap.put("yuedingUserStore",filterNull(json));
                        commonResult.setCode(Constant.NUM_ONE);
                        commonResult.setData(objectMap);
                        return commonResult;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        commonResult.setCode(Constant.NUM_ZERO);
        commonResult.setMessage("该用户没有绑定悦订网");
        return commonResult;
    }


    /**
     * 将json对象中包含的null和JSONNull属性修改成""
     *
     * @param jsonObj
     */
    public static JSONObject filterNull(JSONObject jsonObj) {
        Iterator<String> it = jsonObj.keys();
        Object obj = null;
        String key = null;
        while (it.hasNext()) {
            key = it.next();
            obj = jsonObj.get(key);
            if (obj instanceof JSONObject) {
                filterNull((JSONObject) obj);
            }
            if (obj instanceof JSONArray) {
                JSONArray objArr = (JSONArray) obj;
                for (int i = 0; i < objArr.size(); i++) {
                    filterNull(objArr.getJSONObject(i));
                }
            }
            if (obj == null || obj instanceof JSONNull) {
                jsonObj.put(key, "");
            }
            if (obj.equals(null)) {
                jsonObj.put(key, "");
            }
        }
        return jsonObj;
    }


    @Override
    public PageTO<UserMember> getUserMemberList(String storeSapId,String fRealName,String fUserName,Integer fMemberTypeID, Integer pageNum, Integer pageSize) {
        PageTO<UserMember> dataPage = new PageTO<UserMember>();
        Page page = new Page(pageNum,pageSize);
        List<UserMember> userMemberList = userMapper.getUserMemberList(storeSapId,fRealName,fUserName,fMemberTypeID);
        for (UserMember userMember:userMemberList){
            UserStore userStore = userMapper.findUserStore("1",userMember.getfAcctID());
            userMember.setUserStore(userStore);
        }
        dataPage.setList(userMemberList);
        dataPage.setPageNum(page.getPageNum());
        dataPage.setPages(page.getPages());
        dataPage.setPageSize(page.getPageSize());
        dataPage.setTotal(page.getTotal());
        return dataPage;
    }


    @Override
    public CommonResult discountChiZhiCart(String fChuZhiCartNum, String fAmount) {
        CommonResult commonResult = new CommonResult();
        int k = userMapper.discountChiZhiCart(fChuZhiCartNum,Double.valueOf(fAmount));
        if (k>0){
            commonResult.setCode(1);
        }else {
            commonResult.setCode(0);
        }
        return commonResult;
    }


    public static String getSapToken(){
        String sapToken = "";
        Map<String,String> map = new HashMap<>();
        map.put("BH","000002");
        map.put("Password","111111");
        map.put("key","GetToken");
        JSONObject json = JSONObject.fromObject(HttpUtils.http(URLUtils.SAP_URL,map));
        if (json.getInt("ResultCode")==0){
            JSONObject jsonObject = JSONObject.fromObject(json.get("Data"));
            if (jsonObject!=null){
                sapToken = jsonObject.getString("Token");
            }
        }
        return sapToken;
    }


    @Override
    public CommonResult<PageTO<TdzxMainUser>> getMainUserList(String fRealName, String fUserName, String fMobile, Integer pageNum, Integer pageSize) {
        CommonResult<PageTO<TdzxMainUser>> commonResult = new CommonResult<>();
        PageTO<TdzxMainUser> dataPage = new PageTO<>();
        Page page = new Page(pageNum,pageSize);

        TdzxMainUser tdzxMainUser = new TdzxMainUser();
        tdzxMainUser.setfRealName(fRealName);
        tdzxMainUser.setfName(fUserName);
        tdzxMainUser.setfMobile(fMobile);
        List<TdzxMainUser> userList = userMapper.getBusMainUserList(tdzxMainUser);

        dataPage.setList(userList);
        dataPage.setPageNum(page.getPageNum());
        dataPage.setPages(page.getPages());
        dataPage.setPageSize(page.getPageSize());
        dataPage.setTotal(page.getTotal());

        commonResult.setCode(1);
        commonResult.setData(dataPage);
        return commonResult;
    }


    @Override
    public CommonResult<Boolean> updatePwd(String fMobile, String code, String newPwd) {
        CommonResult<Boolean> commonResult = new CommonResult<>();
        String correctCode = getVerificationCode(fMobile); //redis里面正确的验证码
        if(!code.equals(correctCode)){ //验证码错误
            commonResult.setCode(3);
            commonResult.setMessage("验证码错误");
            return commonResult;
        }

        try {
            TdzxMainUser mainUser = userMapper.findMainUserByTel(fMobile);
            mainUser.setfPassWord(AESUtil.encrypt(newPwd));
            int k = userMapper.updateMainUser(mainUser);
            if (k>0){
                commonResult.setCode(1);
                commonResult.setMessage("操作成功");
            }else {
                commonResult.setCode(0);
                commonResult.setMessage("操作失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return commonResult;
    }

    public void deleteCode(String account) {
        JedisUtils.hdel(tel_code_key, account);
    }

    @Override
    public CommonResult<Boolean> updateMobile(String fOldMobile, String oldCode, String fNewMobile, String newCode) {
        CommonResult<Boolean> commonResult = new CommonResult<>();
        if (fOldMobile!=null && oldCode!=null){
            String correctCode = getVerificationCode(fOldMobile); //redis里面正确的验证码
            if(!oldCode.equals(correctCode)){ //验证码错误
                commonResult.setCode(3);
                commonResult.setMessage("验证码错误");
                return commonResult;
            }else {
                deleteCode(fOldMobile);    //清验证码
                commonResult.setCode(1);
                commonResult.setMessage("操作成功");
                return commonResult;
            }
        }

        if (fNewMobile!=null && newCode!=null){
            String correctCode = getVerificationCode(fOldMobile); //redis里面正确的验证码
            if(!newCode.equals(correctCode)){ //验证码错误
                commonResult.setCode(3);
                commonResult.setMessage("验证码错误");
                return commonResult;
            }else {
                deleteCode(fOldMobile);    //清验证码
                //修改手机号
                TdzxMainUser mainUser = userMapper.findMainUserByTel(fOldMobile);
                mainUser.setfMobile(fNewMobile);
                int m = userMapper.updateMainUser(mainUser);
                if (m>0){
                    commonResult.setCode(1);
                    commonResult.setMessage("操作成功");
                    return commonResult;
                }
            }
        }
        commonResult.setCode(0);
        commonResult.setMessage("操作失败");
        return commonResult;
    }



    @Override
    public CommonResult<Map<String, Object>> loginXCX(String xcxCode) {
        CommonResult<Map<String, Object>> commonResult = new CommonResult<>();
        Map<String, Object> map = new HashMap<>();
        try {
            JSONObject jsonObject= WeixinCommonUtil.getAuthByCode(URLUtils.XCX_APPID,URLUtils.XCX_APPSECRET,xcxCode);
            System.err.println("jsonObject--------------->>>>>"+jsonObject);
            if (jsonObject!=null){
                String unionid = "";
                String xcxOpenid = jsonObject.getString("openid");

                String session_key = jsonObject.getString("session_key");
                JedisUtils.set("wxlogin_" + xcxOpenid, session_key);
                System.out.println(">>>>>>>wxlogin_>>>>>>>>"+ xcxOpenid + JedisUtils.get("wxlogin_" + xcxOpenid));

                //用openid找我们平台是否存在该用户
                TdzxMainUser tdzxMainUser = userMapper.findMainUserByOpenid(xcxOpenid);
                if (tdzxMainUser!=null){
                    if (tdzxMainUser.getXcxOpenID()==null){
                        tdzxMainUser.setXcxOpenID(xcxOpenid);
                        userMapper.updateMainUser(tdzxMainUser);
                    }

                    //是否是TBM会员
                    UserMember userMember = userMapper.findUserMember(tdzxMainUser.getfInnerID());
                    if (userMember==null){
                        userMember = userMapper.findUserMemberFirst(tdzxMainUser.getfInnerID());
                    }

                    if (userMember==null){
                        tdzxMainUser.setfDiscount(1);
                        tdzxMainUser.setfIsMember(0);
                    }else {
                        tdzxMainUser.setfDiscount(userMember.getfDiscount()==null?1:userMember.getfDiscount().doubleValue());
                        tdzxMainUser.setfIsMember(1);
                    }


                    //判断是否是电商大客户
                    try {
                        Map<String,String> mapParam = new HashMap<>();
                        mapParam.put("userId",tdzxMainUser.getfInnerID()+"");
                        JSONObject jsonParam = HttpUtils.doPostMethod(URLUtils.STOREURL+"/deliveryCardRecord/findCompanyUserByID",mapParam);
                        if (jsonParam!=null && jsonParam.getInt("code")==1){
                            JSONObject json = jsonParam.getJSONObject("data");
                            tdzxMainUser.setfIsVip(1);
                            if (json!=null)
                                tdzxMainUser.setfVipDiscount(json.getDouble("discount"));
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    map.put("openid",xcxOpenid);
                    map.put("mainUser",tdzxMainUser);
                    map.put("token",CreateToken(tdzxMainUser.getfInnerID()+""));
                    commonResult.setCode(1);
                    commonResult.setData(map);
                    return commonResult;
                }else {
                    map.put("openid",xcxOpenid);
                    commonResult.setCode(7);
                    commonResult.setMessage("请去注册");
                    commonResult.setData(map);
                    return commonResult;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        commonResult.setCode(0);
        commonResult.setMessage("操作失败");
        return commonResult;
    }



    /*@Override
    public CommonResult<Map<String, Object>> loginXCX(String xcxCode) {
        CommonResult<Map<String, Object>> commonResult = new CommonResult<>();
        Map<String, Object> map = new HashMap<>();
        try {
            JSONObject jsonObject= WeixinCommonUtil.getAuthByCode(URLUtils.XCX_APPID,URLUtils.XCX_APPSECRET,xcxCode);
            System.err.println("jsonObject--------------->>>>>"+jsonObject);
            if (jsonObject!=null){
                String unionid = "";
                String xcxOpenid = jsonObject.getString("openid");
                if (jsonObject.containsKey("jsonObject")){
                    unionid = jsonObject.getString("unionid");
                }
                //用unionid找我们平台是否存在该用户
                TdzxMainUser tdzxMainUser = userMapper.findMainUserByUnionid(unionid);
                if (tdzxMainUser!=null){
                    if (tdzxMainUser.getXcxOpenID()==null){
                        tdzxMainUser.setXcxOpenID(xcxOpenid);
                        userMapper.updateMainUser(tdzxMainUser);
                    }
                    map.put("mainUser",tdzxMainUser);
                    map.put("token",CreateToken(tdzxMainUser.getfInnerID()+""));
                    commonResult.setCode(1);
                    commonResult.setData(map);
                    return commonResult;
                }else {
                    TdzxMainUser mainUser = new TdzxMainUser();
                    if (encryptedData==null){
                        map.put("openid",xcxOpenid);
                        commonResult.setCode(7);
                        commonResult.setMessage("请去注册");
                        commonResult.setData(map);
                        return commonResult;
                    }

                    String session_key = JedisUtils.get("wxlogin_" + fOpenID);
                    System.out.println(">>>>>>>获取wxlogin_>>>>>>>>"+ fOpenID + JedisUtils.get("wxlogin_" + fOpenID));
                    //解密敏感信息
                    String phoneInfo = WXBizDataCrypt.decrypt(encryptedData, iv, session_key);
                    if (null != phoneInfo && !"".equals(phoneInfo)){
                        JSONObject js = JSONObject.fromObject(phoneInfo);
                        System.err.println("js---------->>>>"+js);
                        String phoneNumber = jsonObject.getString("phoneNumber");
                        TdzxMainUser user = userMapper.findMainUserByTel(phoneNumber);
                        if (user==null){//注册
                            String session_key = jsonObject.getString("session_key");
                            JedisUtils.set("wxlogin_" + xcxOpenid, session_key);
                            System.out.println(">>>>>>>wxlogin_>>>>>>>>"+ xcxOpenid + JedisUtils.get("wxlogin_" + xcxOpenid));

                            mainUser.setXcxOpenID(xcxOpenid);
                            mainUser.setUnionID(unionid);
                            mainUser.setfMobile(fMobile);
                            mainUser.setfPic(fPic);
                            mainUser.setfName(fName);
                            int k = userMapper.insertMainUser(mainUser);
                        }else {
                            mainUser.setXcxOpenID(xcxOpenid);
                            mainUser.setUnionID(unionid);
                            userMapper.updateMainUser(mainUser);
                        }
                    }
                    map.put("mainUser",mainUser);
                    map.put("token",CreateToken(mainUser.getfInnerID()+""));
                    commonResult.setCode(1);
                    commonResult.setData(map);
                    return commonResult;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        commonResult.setCode(0);
        commonResult.setMessage("操作失败");
        return commonResult;
    }*/

    @Override
    public CommonResult<Map<String, Object>> bandXCX(String encryptedData, String iv, String fOpenID,String fPic,String fName) {
        CommonResult<Map<String, Object>> commonResult = new CommonResult<>();
        Map<String, Object> map = new HashMap<>();
        try {
            String session_key = JedisUtils.get("wxlogin_" + fOpenID);
            System.out.println(">>>>>>>获取wxlogin_>>>>>>>>"+ fOpenID + JedisUtils.get("wxlogin_" + fOpenID));
            //解密敏感信息
            String phoneInfo = WXBizDataCrypt.decrypt(encryptedData, iv, session_key);
            if (null != phoneInfo && !"".equals(phoneInfo)){
                JSONObject js = JSONObject.fromObject(phoneInfo);
                System.err.println("js---------->>>>"+js);
                String phoneNumber = js.getString("phoneNumber");
                TdzxMainUser user = userMapper.findMainUserByTel(phoneNumber);
                if (user==null){
                    user = new TdzxMainUser();
                    user.setfMobile(phoneNumber);
                    //"TDZX" + RandomUtil.generateNumber(10)
                    user.setfName(fName);
                    user.setXcxOpenID(fOpenID);
                    user.setfPic(fPic);
                    user.setfStatue(1);
                    user.setfCreateTime(System.currentTimeMillis()/1000+"");
                    int k = userMapper.insertMainUser(user);
                    if (k>0){
                        map.put("mainUser",user);
                        map.put("token",CreateToken(user.getfInnerID()+""));
                        commonResult.setCode(1);
                        commonResult.setData(map);
                        return commonResult;
                    }
                }else {
                    user.setXcxOpenID(fOpenID);
                    userMapper.updateMainUser(user);

                    //是否是TBM会员
                    UserMember userMember = userMapper.findUserMember(user.getfInnerID());
                    if (userMember==null){
                        userMember = userMapper.findUserMemberFirst(user.getfInnerID());
                    }

                    if (userMember==null){
                        user.setfDiscount(1);
                        user.setfIsMember(0);
                    }else {
                        user.setfDiscount(userMember.getfDiscount()==null?1:userMember.getfDiscount().doubleValue());
                        user.setfIsMember(1);
                    }


                    //判断是否是电商大客户
                    try {
                        Map<String,String> mapParam = new HashMap<>();
                        mapParam.put("userId",user.getfInnerID()+"");
                        JSONObject jsonParam = HttpUtils.doPostMethod(URLUtils.STOREURL+"/deliveryCardRecord/findCompanyUserByID",mapParam);
                        if (jsonParam!=null && jsonParam.getInt("code")==1){
                            JSONObject json = jsonParam.getJSONObject("data");
                            user.setfIsVip(1);
                            if (json!=null)
                                user.setfVipDiscount(json.getDouble("discount"));
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    map.put("mainUser",user);
                    map.put("token",CreateToken(user.getfInnerID()+""));
                    commonResult.setCode(1);
                    commonResult.setData(map);
                    return commonResult;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        commonResult.setCode(0);
        commonResult.setMessage("操作失败");
        return commonResult;
    }

    @Override
    public CommonResult<PageTO<UserStore>> getBussTypeUserList(String fName,String fRealName,String fBussType,Integer pageNum,Integer pageSize) {
        CommonResult<PageTO<UserStore>> commonResult = new CommonResult<>();
        PageTO<UserStore>  dataPage = new PageTO<UserStore>();
        Page page = PageHelper.startPage(pageNum,pageSize);

        List<UserStore> userStoreList = userMapper.findUserStoreByBusstype(fName,fRealName,fBussType,null);
        dataPage.setList(userStoreList);
        dataPage.setPageNum(page.getPageNum());
        dataPage.setPages(page.getPages());
        dataPage.setPageSize(page.getPageSize());
        dataPage.setTotal(page.getTotal());

        commonResult.setCode(200);
        commonResult.setData(dataPage);
        return commonResult;
    }

    @Override
    public CommonResult<PageTO<BusiStudentinfo>> getBussTypeStudentList(String studentname,Integer pageNum, Integer pageSize) {
        CommonResult<PageTO<BusiStudentinfo>> commonResult = new CommonResult<>();
        PageTO<BusiStudentinfo>  dataPage = new PageTO<BusiStudentinfo>();
        Page page = PageHelper.startPage(pageNum,pageSize);

        List<BusiStudentinfo> busiStudentinfoList = busiStudentinfoMapper.findStudentByBussType(studentname);

        dataPage.setList(busiStudentinfoList);
        dataPage.setPageNum(page.getPageNum());
        dataPage.setPages(page.getPages());
        dataPage.setPageSize(page.getPageSize());
        dataPage.setTotal(page.getTotal());

        commonResult.setCode(200);
        commonResult.setData(dataPage);
        return commonResult;
    }

    @Override
    public CommonResult<PageTO<DzBusiStudentinfo>> getBussTypeCompanyList(String studentname,Integer pageNum, Integer pageSize) {
        CommonResult<PageTO<DzBusiStudentinfo>> commonResult = new CommonResult<>();
        PageTO<DzBusiStudentinfo>  dataPage = new PageTO<DzBusiStudentinfo>();
        Page page = PageHelper.startPage(pageNum,pageSize);

        List<DzBusiStudentinfo> dzBusiStudentinfoList = dzBusiStudentinfoMapper.getBussTypeCompanyList(studentname);
        dataPage.setList(dzBusiStudentinfoList);
        dataPage.setPageNum(page.getPageNum());
        dataPage.setPages(page.getPages());
        dataPage.setPageSize(page.getPageSize());
        dataPage.setTotal(page.getTotal());

        commonResult.setCode(200);
        commonResult.setData(dataPage);
        return commonResult;
    }


    @Override
    public CommonResult<Boolean> updateUserList(UserStore userStore) {
        CommonResult<Boolean> commonResult = new CommonResult<>();
        int k = userMapper.updateUserStore(userStore);
        if (k>0){
            commonResult.setCode(200);
            commonResult.setData(true);
            commonResult.setMessage("操作成功");
        }else {
            commonResult.setCode(0);
            commonResult.setData(false);
            commonResult.setMessage("操作失败");
        }
        return commonResult;
    }


    @Override
    public CommonResult<Boolean> updateStudentList(BusiStudentinfo busiStudentinfo) {
        CommonResult<Boolean> commonResult = new CommonResult<>();
        int k = busiStudentinfoMapper.updateByPrimaryKey(busiStudentinfo);
        if (k>0){
            commonResult.setCode(200);
            commonResult.setData(true);
            commonResult.setMessage("操作成功");
        }else {
            commonResult.setCode(0);
            commonResult.setData(false);
            commonResult.setMessage("操作失败");
        }
        return commonResult;
    }

    @Override
    public CommonResult<Boolean> updateCompanyList(DzBusiStudentinfo dzBusiStudentinfo) {
        CommonResult<Boolean> commonResult = new CommonResult<>();
        int k = dzBusiStudentinfoMapper.updateByPrimaryKey(dzBusiStudentinfo);
        if (k>0){
            commonResult.setCode(200);
            commonResult.setData(true);
            commonResult.setMessage("操作成功");
        }else {
            commonResult.setCode(0);
            commonResult.setData(false);
            commonResult.setMessage("操作失败");
        }
        return commonResult;
    }

    @Override
    public CommonResult<PageTO<TdzxMainUser>> getBusMainUserList(String fName, String fRealName, Integer pageNum, Integer pageSize) {
        CommonResult<PageTO<TdzxMainUser>> commonResult = new CommonResult<>();
        PageTO<TdzxMainUser>  dataPage = new PageTO<TdzxMainUser>();
        Page page = PageHelper.startPage(pageNum,pageSize);

        TdzxMainUser mainUser = new TdzxMainUser();
        mainUser.setfName(fName);
        mainUser.setfRealName(fRealName);

        dataPage.setList(userMapper.getBusMainUserList(mainUser));
        dataPage.setPageNum(page.getPageNum());
        dataPage.setPages(page.getPages());
        dataPage.setPageSize(page.getPageSize());
        dataPage.setTotal(page.getTotal());

        commonResult.setCode(200);
        commonResult.setData(dataPage);
        return commonResult;
    }

    @Override
    public CommonResult<Boolean> updateTdzxMainUser(TdzxMainUser tdzxMainUser) {
        CommonResult<Boolean> commonResult = new CommonResult<>();
        int k = userMapper.updateMainUser(tdzxMainUser);
        if (k>0){
            commonResult.setCode(200);
            commonResult.setData(true);
            commonResult.setMessage("操作成功");
        }else {
            commonResult.setCode(0);
            commonResult.setData(false);
            commonResult.setMessage("操作失败");
        }
        return commonResult;
    }


    @Override
    public CommonResult<Map<String, Integer>> getInfo() {
        CommonResult<Map<String, Integer>> commonResult = new CommonResult<>();
        Map<String, Integer> map = new HashMap<>();
        //今日新增用户
        map.put("todayAddUser",userMapper.getTodayAddUser());
        //昨日新增用户
        map.put("yesAddUser",userMapper.getYesTodayAddUser());
        //本月新增用户
        map.put("monthAddUser",userMapper.getMonthAddUser());
        //会员总数
        map.put("memberUserNum",userMapper.getTotalMemberNum());
        commonResult.setCode(1);
        commonResult.setData(map);
        return commonResult;
    }


    //获取提货卡数量
    public static int getTiHuoCartCount(Integer fAcctID){
        int count=0;
        Map<String,String> map = new HashMap<>();
        try {
            map.put("fAcctID",fAcctID+"");
            JSONObject jsonObject = HttpUtils.doPostMethod(URLUtils.STOREURL+"/deliveryCardRecord/getUserDeliveryCard",map);
            if (jsonObject!=null && jsonObject.getInt("code")==1){
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                if (jsonArray!=null)
                    count = jsonArray.size();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }
}
