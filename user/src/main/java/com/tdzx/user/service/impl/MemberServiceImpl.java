package com.tdzx.user.service.impl;

import com.tdzx.user.dao.*;
import com.tdzx.user.domain.*;
import com.tdzx.user.service.MemberService;
import com.tdzx.user.service.UserService;
import com.tdzx.user.utils.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Transactional
@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Value("${TEL_CODE_KEY}")
    private String tel_code_key;
    @Resource
    MemberMapper memberMapper;
    @Autowired
    UserService userService;
    @Resource
    UserMapper userMapper;
    @Resource
    BusiSchoolxxMapper busiSchoolxxMapper;
    @Resource
    BusiSchooljgMapper busiSchooljgMapper;
    @Resource
    BusiStudentinfoMapper busiStudentinfoMapper;
    @Resource
    DzBusiSchoolxxMapper dzBusiSchoolxxMapper;
    @Resource
    DzBusiSchooljgMapper dzBusiSchooljgMapper;
    @Resource
    DzBusiStudentinfoMapper dzBusiStudentinfoMapper;

    @Override
    public List<MemberType> getMemberType(String fBussType,Integer fMemberTypeID) {
        List<MemberType> memberTypeList = new ArrayList<>();
        try {
            memberTypeList = memberMapper.findMemberTypeList(fBussType);
        }catch (Exception e){
            e.printStackTrace();
        }
        return memberTypeList;
    }


    @Override
    public CommonResult<Boolean> lockMemberCart(String fMemCardNum,Integer fIsLock) {
        CommonResult<Boolean> commonResult = new CommonResult<>();
        int k = memberMapper.updateUserMemberLock(fMemCardNum,fIsLock);
        if (k>0){
            commonResult.setCode(Constant.NUM_ONE);
            commonResult.setData(true);
        }else {
            commonResult.setCode(Constant.NUM_ZERO);
            commonResult.setData(false);
        }
        return commonResult;
    }

    @Override
    public CommonResult<Boolean> userBandMember(String fBussType,Long userID, Long memberTypeID,String storeSapId) {
        CommonResult<Boolean> commonResult = new CommonResult<>();
        TdzxMainUser mainUser = userMapper.findMainUserByID(Integer.parseInt(userID+""));
        UserStore userStore = userMapper.findUserStore(fBussType,Integer.parseInt(userID+""));
        if (userStore==null){
            //往子表里写入数据
            userStore = new UserStore();
            userStore.setfBussType(fBussType);
            userStore.setfAcctID(Integer.parseInt(userID+""));
            userStore.setfName(mainUser.getfRealName());
            userStore.setfSex(mainUser.getfSex());
            userStore.setfBirthday(mainUser.getfBirthday());
            userStore.setfMobile(mainUser.getfMobile());
            userStore.setfCreateTime(System.currentTimeMillis()/1000+"");
            userStore.setfIntegralNum(0);
            userStore.setfConsumption(0);
            int k = userMapper.insertUserStore(userStore);
        }

        UserMember userMember = memberMapper.findUserMember(userStore.getfInnerID(),Integer.parseInt(memberTypeID+""));
        if (userMember==null && "1".equals(fBussType)){
            userMember = new UserMember();
            //同步到Sap
            //先拿到token
            String sapToken = getSapToken();
            if (sapToken!=null && !"".equals(sapToken)){
                SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
                String BD="";
                if (userStore.getfBirthday()==null || "".equals(userStore.getfBirthday())){
                    BD=sd.format(new Date());
                }else {
                    BD=userStore.getfBirthday();
                }
                String code = sapRegistry(sapToken,storeSapId+"",userStore.getfMobile(),userStore.getfName(),BD,
                        mainUser.getfIDCard(),userStore.getfSex()+"","02");
                System.err.println("code----------->"+code);
                //已经注册的情况如何处理
                if (code==null || "".equals(code)){
                    commonResult.setCode(-1);
                    commonResult.setData(false);
                    return commonResult;
                }
                userMember.setfMemCardNum(code);
            }
            //插入
            List<MemberType> memberTypeList = memberMapper.findMemberType(null,Integer.parseInt(memberTypeID+""));
            if (memberTypeList!=null && memberTypeList.size()>0){
                Date nowDate = new Date();
                MemberType memberType = memberTypeList.get(0);
                userMember.setfDiscount(memberType.getfDiscount());
                userMember.setfMemTypeID(Integer.parseInt(memberTypeID+""));
                userMember.setfCreateDate(nowDate.getTime()/1000+"");
                userMember.setfAcctID(Integer.parseInt(userID+""));
                userMember.setfSubUserID(userStore.getfInnerID());
                userMember.setfBalance(memberType.getfDenomination());
                if (memberType.getfItem()==0 || memberType.getfItem()==null){
                    userMember.setfIndate(null);
                }else {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(nowDate);
                    cal.add(Calendar.MONTH, memberType.getfItem());
                    userMember.setfIndate(cal.getTimeInMillis()/1000+"");
                }
                int m = memberMapper.insertUserMember(userMember);
                if (m>0){
                    commonResult.setCode(Constant.NUM_ONE);
                    commonResult.setData(true);
                    return commonResult;
                }
            }
        }
        commonResult.setCode(Constant.NUM_ZERO);
        commonResult.setData(false);
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

    public static String sapRegistry(String token,String YWBMBH,String Mobile,String Name,String BD,String IDcard,String SEX,String LBBH){
        String code = "";
        Map<String,String> map = new HashMap<>();
        map.put("Token",token);
        map.put("YWBMBH",YWBMBH);
        map.put("Mobile",Mobile);
        map.put("Name",Name);
        map.put("BD",BD);
        map.put("IDcard",IDcard);
        map.put("SEX",SEX);
        map.put("LBBH",LBBH);
        map.put("key","RegistMember");
        JSONObject json = JSONObject.fromObject(HttpUtils.http(URLUtils.SAP_URL,map));
        System.err.println("同步sap会员注册："+json);
        if (json.getInt("ResultCode")==0){
            JSONObject jsonObject = JSONObject.fromObject(json.get("Data"));
            if (jsonObject!=null){
                code = jsonObject.getString("Code");
            }
        }
        return code;
    }

    public String getVerificationCode(String account) {
        return JedisUtils.hget(tel_code_key, account);
    }

    public void deleteCode(String account) {
        JedisUtils.hdel(tel_code_key, account);
    }


    @Override
    public CommonResult<Boolean> userBandSapMember(String fBussType, String fMobile, String fCode) {
        CommonResult<Boolean> commonResult = new CommonResult<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String correctCode = getVerificationCode(fMobile); //redis里面正确的验证码
        if (!fCode.equals(correctCode)){
            commonResult.setCode(Constant.NUM_ZERO);
            commonResult.setData(false);
            commonResult.setMessage("验证码错误");
            return commonResult;
        }

        deleteCode(fMobile);    //清验证码

        Map<String,String> map = new HashMap<>();
        if ("1".equals(fBussType)){ //电商
            String sapToken = getSapToken();
            map.put("Token",sapToken);
            map.put("YWBMBH"," ");
            map.put("Mobile",fMobile);
            map.put("key","GetMemberInfo");
            try {
                TdzxMainUser mainUser = userMapper.findMainUserByTel(fMobile);
                if (mainUser!=null){
                    JSONObject json = JSONObject.fromObject(HttpUtils.http(URLUtils.SAP_URL,map));
                    if (json!=null && "0".equals(json.getString("ResultCode"))){
                        //从sap获取信息成功 插入 或 更新 会员表，用户会员表
                        //判断在我们平台是否已经存在该会员
                        String memberCartNum = JSONObject.fromObject(json.get("Data")).getString("Code");
                        UserMember userMember = memberMapper.findIsExitUserMember(mainUser.getfInnerID(),memberCartNum,null);
                        if (userMember==null){
                            //我们平台没有该用户信息，同步拉取
                            UserStore userStore = new UserStore();
                            userStore.setfBussType(fBussType);
                            userStore.setfAcctID(mainUser.getfInnerID());
                            userStore.setfMobile(fMobile);
                            userStore.setfRealName(JSONObject.fromObject(json.get("Data")).getString("memberName"));
                            userStore.setfBirthday(JSONObject.fromObject(json.get("Data")).getString("memberBirthday"));
                            if ("0".equals(JSONObject.fromObject(json.get("Data")).getString("memberGender"))){
                                userStore.setfSex(1);
                            }else if ("1".equals(JSONObject.fromObject(json.get("Data")).getString("memberGender"))){
                                userStore.setfSex(2);
                            }else {
                                userStore.setfSex(0);
                            }

                            if (JSONObject.fromObject(json.get("Data")).getString("registerDate")!=null && !"".equals(JSONObject.fromObject(json.get("Data")).getString("registerDate"))){
                                Date createTime = dateFormat.parse(JSONObject.fromObject(json.get("Data")).getString("registerDate"));
                                userStore.setfCreateTime(createTime.getTime()/1000+"");
                            }else {
                                userStore.setfCreateTime(System.currentTimeMillis()/1000+"");
                            }

                            userStore.setfIntegralNum(JSONObject.fromObject(json.get("Data")).getDouble("currentPoint"));
                            userStore.setfConsumption(JSONObject.fromObject(json.get("Data")).getDouble("consumMoney"));
                            int k = userMapper.insertUserStore(userStore);

                            //同时往 会员用户表里写数据
                            String memberTypeNum = JSONObject.fromObject(json.get("Data")).getString("memberClass");
                            MemberType memberType = memberMapper.findMemberTypeByNum(memberTypeNum);
                            if (memberType!=null){
                                userMember = new UserMember();
                                userMember.setfAcctID(userStore.getfAcctID());
                                userMember.setfSubUserID(userStore.getfInnerID());
                                userMember.setfMemTypeID(memberType.getfInnerID());
                                userMember.setfMemCardNum(memberCartNum);
                                userMember.setfDiscount(memberType.getfDiscount());
                                //userMember.setStoreSapId(storeCode);
                                userMember.setfCreateDate(userStore.getfCreateTime());
                                userMember.setfIsDefault(1);
                                memberMapper.insertUserMember(userMember);

                                JSONArray jsonArray = JSONObject.fromObject(json.get("Data")).getJSONArray("Cards");
                                if (jsonArray!=null && jsonArray.size()>0){
                                    for (Object obj:jsonArray){
                                        UserMember userMemberParam = new UserMember();
                                        JSONObject js = JSONObject.fromObject(obj);

                                        MemberType memberTypeParam = memberMapper.findMemberTypeByName("储值卡");

                                        userMemberParam.setfAcctID(userStore.getfAcctID());
                                        userMemberParam.setfSubUserID(userStore.getfInnerID());
                                        userMemberParam.setfMemTypeID(memberTypeParam.getfInnerID());
                                        userMemberParam.setfMemCardNum(js.getString("Code"));
                                        userMemberParam.setfBalance(js.getDouble("YE"));
                                        if (js.getString("JZRQ")!=null){
                                            userMemberParam.setfIndate(dateFormat.parse(js.getString("JZRQ")).getTime()/1000+"");
                                        }
                                        userMemberParam.setfDiscount(memberTypeParam.getfDiscount());
                                        userMemberParam.setStoreSapId(js.getString("YWBMBH"));
                                        userMemberParam.setfCreateDate(userStore.getfCreateTime());
                                        memberMapper.insertUserMember(userMemberParam);
                                    }
                                }
                            }
                        }else {
                            //我们平台有该用户信息，同步更新
                            UserStore userStore = new UserStore();
                            userStore.setfStatue(1);
                            userStore.setfBussType(fBussType);
                            userStore.setfAcctID(mainUser.getfInnerID());
                            userStore.setfMobile(fMobile);
                            userStore.setfRealName(JSONObject.fromObject(json.get("Data")).getString("memberName"));
                            userStore.setfBirthday(JSONObject.fromObject(json.get("Data")).getString("memberBirthday"));
                            if ("0".equals(JSONObject.fromObject(json.get("Data")).getString("memberGender"))){
                                userStore.setfSex(1);
                            }else if ("1".equals(JSONObject.fromObject(json.get("Data")).getString("memberGender"))){
                                userStore.setfSex(2);
                            }else {
                                userStore.setfSex(0);
                            }

                            if (JSONObject.fromObject(json.get("Data")).getString("registerDate")!=null && !"".equals(JSONObject.fromObject(json.get("Data")).getString("registerDate"))){
                                Date createTime = dateFormat.parse(JSONObject.fromObject(json.get("Data")).getString("registerDate"));
                                userStore.setfCreateTime(createTime.getTime()/1000+"");
                            }else {
                                userStore.setfCreateTime(System.currentTimeMillis()/1000+"");
                            }

                            userStore.setfIntegralNum(JSONObject.fromObject(json.get("Data")).getDouble("currentPoint"));
                            userStore.setfConsumption(JSONObject.fromObject(json.get("Data")).getDouble("consumMoney"));
                            int k = userMapper.updateUserStoreByAcctID(userStore);

                            //同时往 会员用户表里更新数据
                            String memberTypeNum = JSONObject.fromObject(json.get("Data")).getString("memberClass");
                            MemberType memberType = memberMapper.findMemberTypeByNum(memberTypeNum);
                            if (memberType!=null){
                                userMember = new UserMember();
                                userMember.setfAcctID(userStore.getfAcctID());
                                userMember.setfSubUserID(userStore.getfInnerID());
                                userMember.setfMemTypeID(memberType.getfInnerID());
                                userMember.setfMemCardNum(memberCartNum);
                                userMember.setfDiscount(memberType.getfDiscount());
                                userMember.setfCreateDate(userStore.getfCreateTime());
                                userMember.setfIsDefault(1);
                                userMember.setfStatue(1);
                                memberMapper.updateMember(userMember);
                            }
                        }
                    }else {
                        commonResult.setCode(Constant.NUM_ZERO);
                        commonResult.setData(false);
                        commonResult.setMessage("不存在该用户的会员信息");
                        return commonResult;
                    }
                }else {
                    commonResult.setCode(Constant.NUM_ZERO);
                    commonResult.setData(false);
                    commonResult.setMessage("不存在该用户");
                    return commonResult;
                }
            }catch (Exception e){
                e.printStackTrace();
                commonResult.setCode(Constant.NUM_ZERO);
                commonResult.setData(false);
                return commonResult;
            }
        }
        commonResult.setCode(Constant.NUM_ONE);
        commonResult.setData(true);
        commonResult.setMessage("操作成功");
        return commonResult;
    }


    @Override
    public CommonResult<Boolean> memberAdmin(String fType,Integer fAcctID, Integer fUserMemberID) {
        CommonResult<Boolean> commonResult = new CommonResult<>();
        if ("1".equals(fType)){ //删除
            memberMapper.deleteUserMember(fUserMemberID);
        }
        if ("2".equals(fType)){     //设为默认
            memberMapper.updateNoDefaultUserMember(fAcctID);
            memberMapper.updateDefaultUserMember(fUserMemberID);
        }
        commonResult.setCode(1);
        commonResult.setData(true);
        return commonResult;
    }


    @Override
    public CommonResult<List<UserMember>> bindSapChuZhiCart(Integer fAcctID,String storeCode,String fMemberCartNum,
                                                            String fChuZhiCartNum, String fChuZhiCartPwd) {
        CommonResult<List<UserMember>> commonResult = new CommonResult<>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Map<String,String> map = new HashMap<>();
        JSONObject jsonObject = new JSONObject();
        try {
            String sapToken = getSapToken();
            map.put("Token",sapToken);
            map.put("YWBMBH",storeCode);
            map.put("ICCode",fChuZhiCartNum);   //储值卡号
            map.put("HYCode",fMemberCartNum);   //会员卡号
            map.put("MARK",fChuZhiCartPwd);   //会员卡号
            map.put("key","BindICCard");
            jsonObject = JSONObject.fromObject(HttpUtils.http(URLUtils.SAP_URL,map));
            if (jsonObject!=null && jsonObject.getInt("ResultCode")==0){
                UserStore userStore = userMapper.findUserStore("1",fAcctID);

                JSONObject json = jsonObject.getJSONObject("Data");
                Date endTime = df.parse(json.getString("JZRQ"));
                UserMember userMember = new UserMember();
                userMember.setfAcctID(fAcctID);
                userMember.setfSubUserID(userStore.getfInnerID());
                userMember.setfMemTypeID(1);
                userMember.setfMemCardNum(fChuZhiCartNum);
                userMember.setfBalance(json.getDouble("YE"));
                userMember.setfIndate(endTime.getTime()/1000+"");
                userMember.setStoreSapId("");
                userMember.setStoreNo("");
                userMember.setfDiscount(new BigDecimal(1));
                userMember.setfIsLock(0);
                userMember.setfIsDefault(0);
                int k = memberMapper.insertUserMember(userMember);
                if (k>0){
                    commonResult.setCode(1);
                    commonResult.setMessage("操作成功");
                    return commonResult;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        commonResult.setCode(0);
        commonResult.setMessage(jsonObject.getString("ResultMsg"));
        return commonResult;
    }


    @Override
    public CommonResult<Boolean> cardBandVip(String fBussType,Integer fInnerID,String fName, String memberCard, String activeCode) {
        CommonResult<Boolean> commonResult = new CommonResult<>();
        try {
            if ("1".equals(fBussType)){ //商城的提货卡
                Map<String,String> map = new HashMap<>();
                map.put("userId",fInnerID+"");
                map.put("userName",fName);
                map.put("cardNumber",memberCard);
                map.put("cardPass",activeCode);
                JSONObject jsonObject = HttpUtils.doPostMethod(URLUtils.STOREURL+"/deliveryCardRecord/findVipDeliveryCardRecord",map);
                if (jsonObject!=null && jsonObject.getInt("code")==1){
                    commonResult.setCode(1);
                    commonResult.setData(true);
                }else {
                    commonResult.setCode(0);
                    commonResult.setData(false);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return commonResult;
    }


    @Override
    public CommonResult<Boolean> userBandVip(String fBussType, Integer fInnerID, String mobile, String code) {
        CommonResult<Boolean> commonResult = new CommonResult<>();
        String correctCode = getVerificationCode(mobile); //redis里面正确的验证码
        if (!code.equals(correctCode)){
            commonResult.setCode(0);
            commonResult.setMessage("验证码错误");
            return commonResult;
        }

        try {
            if ("1".equals(fBussType)){ //电商
                Map<String,String> map = new HashMap<>();
                map.put("userId",fInnerID+"");
                map.put("mobile",mobile);
                JSONObject jsonObject = HttpUtils.doPostMethod(URLUtils.STOREURL+"/deliveryCardRecord/findCompanyUser",map);
                if (jsonObject!=null && jsonObject.getInt("code")==1){
                    commonResult.setCode(1);
                    commonResult.setMessage("绑定成功");
                }else {
                    commonResult.setCode(0);
                    commonResult.setMessage(jsonObject.getString("message"));
                }
                return commonResult;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        commonResult.setCode(0);
        commonResult.setMessage("操作失败");
        return commonResult;
    }


    @Override
    public List<BusiSchoolxx> findSchool(String province, String city, String area, String schoolName) {
        List<BusiSchoolxx> busiSchoolxxList = busiSchoolxxMapper.selectByShengShiQu(province,city,area,schoolName);
        return busiSchoolxxList;
    }

    @Override
    public List<BusiSchooljg> getSchoolGradeClass(String schoolID) {
        //找年级
        List<BusiSchooljg> gradeList = busiSchooljgMapper.selectBySchoolID(schoolID,null,1);
        if (gradeList!=null && gradeList.size()>0){
            for (BusiSchooljg grade:gradeList){
                //找班级
                List<BusiSchooljg> classList = busiSchooljgMapper.selectBySchoolID(schoolID,grade.getGradeId(),2);
                grade.setClassList(classList);
            }
        }
        return gradeList;
    }


    @Override
    public CommonResult<List<BusiStudentinfo>> registryJCJF(String wxID,Integer userID, String realName, String schoolId, String schoolName,
                                                            String gradeId, String gradeName, String classId, String className,
                                                            String mobile, String code) {
        String vx_id = "";
        String num = "";
        if (wxID==null || "".equals(wxID)){
            Random random = new Random();
            num = random.nextInt(1000000) + "";
            int randLength = num.length();
            if (randLength < 6) {
                for (int i = 1; i <= 6 - randLength; i++)
                    num = "0" + num;
            }
            vx_id = System.currentTimeMillis()+num;
        }else {
            vx_id = wxID;
        }
        CommonResult<List<BusiStudentinfo>> commonResult = new CommonResult<>();
        List<BusiStudentinfo> studentinfoList = new ArrayList<>();

        String correctCode = getVerificationCode(mobile); //redis里面正确的验证码
        if (!code.equals(correctCode)){
            commonResult.setCode(3);
            commonResult.setMessage("验证码错误");
            return commonResult;
        }

        deleteCode(mobile);    //清验证码
        //调 对方的接口生成vx_id(暂缓)

        //然后在我们这边插入到学生表中
        BusiStudentinfo busiStudentinfo = new BusiStudentinfo();
        busiStudentinfo.setId(System.currentTimeMillis()+num);
        busiStudentinfo.setStudentname(realName);
        busiStudentinfo.setSchoolid(schoolId+"");
        busiStudentinfo.setSchoolname(schoolName);
        busiStudentinfo.setGradeid(gradeId);
        busiStudentinfo.setGrade(gradeName);
        busiStudentinfo.setClassid(classId);
        busiStudentinfo.setClassname(className);
        busiStudentinfo.setCretime(new Date());
        busiStudentinfo.setMobilecreate(1); //是否是手机创建
        busiStudentinfo.setEnabled(1);  //是否可用
        busiStudentinfo.setFacctid(userID);
        busiStudentinfo.setWxId(vx_id);
        int k = busiStudentinfoMapper.insert(busiStudentinfo);
        if (k>0){
            studentinfoList = busiStudentinfoMapper.findStudentByVXID(vx_id);
            commonResult.setCode(1);
            commonResult.setData(studentinfoList);
            commonResult.setMessage("操作成功");
        }else {
            commonResult.setCode(0);
            commonResult.setMessage("操作失败");
        }
        return commonResult;
    }


    @Override
    public CommonResult<List<BusiStudentinfo>> getStudentList(String wxID) {
        CommonResult<List<BusiStudentinfo>> commonResult = new CommonResult<>();
        List<BusiStudentinfo> studentinfoList = busiStudentinfoMapper.findStudentByVXID(wxID);
        commonResult.setCode(1);
        commonResult.setData(studentinfoList);
        return commonResult;
    }

    @Override
    public List<DzBusiSchoolxx> findCompany(String province, String city, String area, String companyName) {
        List<DzBusiSchoolxx> dzBusiSchoolxxList = dzBusiSchoolxxMapper.selectByShengShiQu(province,city,area,companyName);
        return dzBusiSchoolxxList;
    }

    @Override
    public List<DzBusiSchooljg> getCompanyInfo(String companyID) {
        //找职位
        List<DzBusiSchooljg> zhiweiList = dzBusiSchooljgMapper.selectByCompanyID(companyID,null,1);
        if (zhiweiList!=null && zhiweiList.size()>0){
            for (DzBusiSchooljg grade:zhiweiList){
                //找职务
                List<DzBusiSchooljg> zhiwuList = dzBusiSchooljgMapper.selectByCompanyID(companyID,grade.getGradeId(),2);
                grade.setZhiwuList(zhiwuList);
            }
        }
        return zhiweiList;
    }


    @Override
    public CommonResult<DzBusiStudentinfo> registryDZDW(Integer userID, String realName, String schoolId, String schoolName,
                                                        String gradeId, String gradeName, String classId, String className,
                                                        String mobile, String code) {
        CommonResult<DzBusiStudentinfo> commonResult = new CommonResult<>();
        DzBusiStudentinfo dzBusiStudentinfo = new DzBusiStudentinfo();

        String vx_id = "";
        String num = "";
        Random random = new Random();
        num = random.nextInt(1000000) + "";
        int randLength = num.length();
        if (randLength < 6) {
            for (int i = 1; i <= 6 - randLength; i++)
                num = "0" + num;
        }
        vx_id = System.currentTimeMillis()+num;

        String correctCode = getVerificationCode(mobile); //redis里面正确的验证码
        if (!code.equals(correctCode)){
            commonResult.setCode(3);
            commonResult.setMessage("验证码错误");
            return commonResult;
        }

        deleteCode(mobile);    //清验证码
        //调 对方的接口生成vx_id(暂缓)
        //然后在我们这边插入到dz_busi_studentinfo表
        dzBusiStudentinfo.setId(System.currentTimeMillis()+num);
        dzBusiStudentinfo.setStudentname(realName);
        dzBusiStudentinfo.setSchoolid(schoolId+"");
        dzBusiStudentinfo.setSchoolname(schoolName);
        dzBusiStudentinfo.setGradeid(gradeId);
        dzBusiStudentinfo.setGrade(gradeName);
        dzBusiStudentinfo.setClassid(classId);
        dzBusiStudentinfo.setClassname(className);
        dzBusiStudentinfo.setCretime(new Date());
        dzBusiStudentinfo.setMobilecreate(1); //是否是手机创建
        dzBusiStudentinfo.setEnabled(1);  //是否可用
        dzBusiStudentinfo.setFAcctID(userID);
        dzBusiStudentinfo.setWxId(vx_id);
        int k = dzBusiStudentinfoMapper.insert(dzBusiStudentinfo);
        if (k>0){
            commonResult.setCode(1);
            commonResult.setData(dzBusiStudentinfo);
            commonResult.setMessage("注册成功！");
        }else {
            commonResult.setCode(0);
            commonResult.setMessage("注册失败！");
        }
        return commonResult;
    }


    @Override
    public CommonResult<DzBusiStudentinfo> getCompanyUserInfo(Integer fAcctID) {
        CommonResult<DzBusiStudentinfo> commonResult = new CommonResult<>();
        commonResult.setCode(1);
        commonResult.setData(dzBusiStudentinfoMapper.findDzStudentByAcctID(fAcctID));
        commonResult.setMessage("操作成功！");
        return commonResult;
    }


    @Override
    public CommonResult<BusiSchoolxx> getSchoolInfoByID(String fschoolID) {
        CommonResult<BusiSchoolxx> commonResult = new CommonResult<>();
        BusiSchoolxx busiSchoolxx = busiSchoolxxMapper.selectByPrimaryKey(fschoolID);
        if (busiSchoolxx!=null){
            commonResult.setCode(1);
            commonResult.setData(busiSchoolxx);
        }else {
            commonResult.setCode(0);
        }
        return commonResult;
    }

    @Override
    public CommonResult<DzBusiSchoolxx> getCompanyInfoByID(String fcompanyID) {
        CommonResult<DzBusiSchoolxx> commonResult = new CommonResult<>();
        DzBusiSchoolxx dzBusiSchoolxx = dzBusiSchoolxxMapper.selectByPrimaryKey(fcompanyID);
        if (dzBusiSchoolxx!=null){
            commonResult.setCode(1);
            commonResult.setData(dzBusiSchoolxx);
        }else {
            commonResult.setCode(0);
        }
        return commonResult;
    }


    @Override
    public CommonResult<Boolean> rechargeTbmChuZhiCart(Integer fAcctID, String fMemberCartNum, String fChuZhiCartNum, double totalPrice) {
        CommonResult<Boolean> commonResult = new CommonResult<>();
        try {
            String sapToken = getSapToken();
            /*Map<String>
            map.put("Token",sapToken);
            //map.put("YWBMBH",storeCode);
            map.put("Mobile",fMobile);
            map.put("key","GetMemberInfo");
            try {
                TdzxMainUser mainUser = userMapper.findMainUserByTel(fMobile);
                if (mainUser!=null){
                    JSONObject json = JSONObject.fromObject(HttpUtils.http(URLUtils.SAP_URL,map));*/
        }catch (Exception e){
            e.printStackTrace();
        }
        return commonResult;
    }


    @Override
    public CommonResult<Boolean> unBindICCard(Integer fAcctID, String fMemberCartNum, String fChuZhiCartNum) {
        CommonResult<Boolean> commonResult = new CommonResult<>();
        JSONObject jsonObject = new JSONObject();
        Map<String,String> map = new HashMap<>();
        //调用TBM的接口解绑
        try {
            String token = getSapToken();
            map.put("Token",token);
            map.put("key","UnBindICCard");
            map.put("YWBMBH"," ");
            map.put("HYCode",fMemberCartNum);
            map.put("ICCode",fChuZhiCartNum);
            jsonObject = HttpUtils.doPostMethod(URLUtils.SAP_URL,map);
            if (jsonObject!=null && jsonObject.getInt("ResultCode")==0){
                //解绑成功,更改我们这边的会员状态
                int k = memberMapper.unBindICCard(fMemberCartNum);
                if (k>0){
                    commonResult.setCode(1);
                    commonResult.setData(true);
                    return commonResult;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        commonResult.setCode(0);
        commonResult.setData(false);
        commonResult.setMessage(jsonObject.getString("ResultMsg"));
        return commonResult;
    }

    @Override
    public CommonResult<Boolean> unBindMemberCard(Integer fAcctID, String fMemberCartNum) {
        CommonResult<Boolean> commonResult = new CommonResult<>();
        int k = memberMapper.unBindICCard(fMemberCartNum);
        if (k>0){
            commonResult.setCode(1);
            commonResult.setData(true);
            return commonResult;
        }
        commonResult.setCode(0);
        commonResult.setData(false);
        commonResult.setMessage("操作失败");
        return commonResult;
    }
}
