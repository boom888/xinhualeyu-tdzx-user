package com.tdzx.user.controller;

import com.tdzx.user.domain.*;
import com.tdzx.user.service.UserService;
import com.tdzx.user.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api(value = "user", description = "用户相关API")
@Controller
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "sendTelCode", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "发送手机验证码", notes = "===返回值说明===<br/>" +
            "传参:<br/>" +
            "手机号码<br/>" +
            "type: 2000:绑定微信 2001:注册  2002：忘记密码  2003：修改密码 2004:登陆"+
            "状态:<br/>" +
            "1成功-1普通错误信息提示-20000服务器异常-10001手机号码不合法-10003次数过多")
    @ApiImplicitParams({
            @ApiImplicitParam(name="telphone",value = "手机号",required=true, paramType = "query"),
            @ApiImplicitParam(name="type",value = "类型",required=false, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Boolean> sendTelCode(@RequestParam(required = true) String telphone,@RequestParam(required = false) String type) throws Exception {
        CommonResult<Boolean> commonResult = new CommonResult<>();
        commonResult = userService.sendTelCode(getIp(), telphone, ALiYunDuanXinUtils.TEMPLATE_CODE_APP);
        if ("2000".equals(type)){
            //判断手机号是否是新用户
            TdzxMainUser tdzxMainUser = userService.findMainUserByTel(telphone);
            if (tdzxMainUser==null){
                commonResult.setCode(Constant.NUM_FOUR);
            }
        }
        /*if ("2001".equals(type)){
            //判断手机号是否是注册
            TdzxMainUser tdzxMainUser = userService.findMainUserByTel(telphone);
            if (tdzxMainUser!=null){
                commonResult.setCode(Constant.NUM_ZERO);
                commonResult.setMessage("该账号已注册");
            }
        }
        if ("2002".equals(type) || "2003".equals(type) || "2004".equals(type)){
            //判断手机号是否是注册
            TdzxMainUser tdzxMainUser = userService.findMainUserByTel(telphone);
            if (tdzxMainUser==null){
                commonResult.setCode(Constant.NUM_ZERO);
                commonResult.setMessage("该账号未注册");
            }
        }*/
        return commonResult;
    }


    @ApiOperation(value = "主账号--注册")
    @RequestMapping(value = "mainUserRegistry", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fTel",value = "手机号",required=true, paramType = "query"),
            @ApiImplicitParam(name="fCode",value = "验证码",required=true, paramType = "query"),
            @ApiImplicitParam(name="fPwd",value = "密码",required=true, paramType = "query"),
            @ApiImplicitParam(name="openID",value = "openID",required=false, paramType = "query"),
    })
    @ResponseBody
    public CommonResult<Map<String,Object>> mainUserRegistry(@RequestParam(required = true) String fTel, @RequestParam(required = true) String fCode,
                                                       @RequestParam(required = true)  String fPwd,@RequestParam(required = false)  String openID){
        CommonResult<Map<String,Object>> commonResult = new CommonResult<>();
        if (openID!=null && !"".equals(openID)){
            commonResult = userService.VXRegistry(openID,fTel,fPwd,fCode,null,null);
            return commonResult;
        }

        int k = userService.mainUserRegistry(fTel,fCode,fPwd);
        if (k==0){
            commonResult.setCode(Constant.NUM_ZERO);
            commonResult.setData(null);
            commonResult.setMessage(PromptMessage.RGE_FAIL);
        }
        if (k==1){
            TdzxMainUser mainUser = userService.findMainUserByTel(fTel);
            Map<String,Object> map = new HashMap<>();
            map.put("mainUser",mainUser);
            map.put("token",userService.CreateToken(mainUser.getfInnerID()+""));
            commonResult.setCode(Constant.NUM_ONE);
            commonResult.setData(map);
            commonResult.setMessage(PromptMessage.REG_SUCCESS);
        }
        if (k==2){
            commonResult.setCode(Constant.NUM_ZERO);
            commonResult.setData(null);
            commonResult.setMessage(PromptMessage.ROLE_EXIT);
        }
        if (k==3){
            commonResult.setCode(Constant.NUM_ZERO);
            commonResult.setData(null);
            commonResult.setMessage(PromptMessage.ACC_SMS_ERR);
        }
        return commonResult;
    }


    @ApiOperation(value = "主账号--登陆")
    @RequestMapping(value = "mainUserLogin", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fTel",value = "手机号",required=false, paramType = "query"),
            @ApiImplicitParam(name="fCode",value = "验证码",required=false, paramType = "query"),
            @ApiImplicitParam(name="fPwd",value = "密码",required=false, paramType = "query"),
            @ApiImplicitParam(name="openID",value = "openID",required=false, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Map<String,Object>> mainUserLogin(@RequestParam(required = false) String fTel, @RequestParam(required = false) String fCode,
                                                        @RequestParam(required = false)  String fPwd,@RequestParam(required = false)  String openID){
        CommonResult<Map<String,Object>> commonResult = new CommonResult<>();
        Map<String,Object> map = new HashMap<>();
        if (openID!=null && !"".equals(openID)){
            Map<String,Object> mapParam = userService.loginByVX(null,openID,null,null);
            if (map==null || map.size()==0){
                commonResult.setCode(Constant.NUM_THREE);
                commonResult.setData(null);
                commonResult.setMessage(PromptMessage.OPERATE_SUCCESS);
                return commonResult;
            }
            commonResult.setCode(Constant.NUM_ONE);
            commonResult.setData(mapParam);
            commonResult.setMessage(PromptMessage.OPERATE_SUCCESS);
            return commonResult;
        }
        return userService.mainUserLogin(fTel,fCode,fPwd);
    }

    @ApiOperation(value = "获取用户信息 (token放入请求头中)")
    @RequestMapping(value = "getMainUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<TdzxMainUser> getMainUserInfo(){
        CommonResult<TdzxMainUser> commonResult = new CommonResult<>();
        String token = getToken(request);
        try {
            TdzxMainUser mainUser = userService.findMainUserByToken(token);
            if (mainUser!=null){
                commonResult.setCode(Constant.NUM_ONE);
                commonResult.setData(mainUser);
                commonResult.setMessage(PromptMessage.LOAD_SUCCESS);
            }else {
                commonResult.setCode(Constant.NUM_TWO);
                commonResult.setData(mainUser);
                commonResult.setMessage(PromptMessage.TOKEN_PASS);
            }
        }catch (Exception e){
            e.printStackTrace();
            commonResult.setCode(Constant.NUM_ZERO);
            commonResult.setData(null);
            commonResult.setMessage(PromptMessage.LOAD_FAIL);
        }
        return commonResult;
    }


    @ApiOperation(value = "批量获取用户信息")
    @RequestMapping(value = "getBatchMainUserInfo", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fAcctIDArr",value = "主账号ID（逗号隔开）",required=false, paramType = "query")
    })
    @ResponseBody
    public CommonResult<List<TdzxMainUser>> getBatchMainUserInfo(@RequestParam(required = true) String fAcctIDArr){
        CommonResult<List<TdzxMainUser>> commonResult = new CommonResult<>();
        List<TdzxMainUser> mainUserList = userService.getBatchMainUserInfo(fAcctIDArr);
        commonResult.setCode(Constant.NUM_ONE);
        commonResult.setData(mainUserList);
        commonResult.setMessage(PromptMessage.LOAD_SUCCESS);
        return commonResult;
    }


    @ApiOperation(value = "主账号--修改信息")
    @RequestMapping(value = "updateMainUser", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fPic",value = "头像",required=false, paramType = "query"),
            @ApiImplicitParam(name="fRealName",value = "姓名",required=false, paramType = "query"),
            @ApiImplicitParam(name="fSex",value = "性别(1：男 ，0：女)",required=false, paramType = "query"),
            @ApiImplicitParam(name="fBirthday",value = "出生年月",required=false, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Boolean> updateMainUser(@RequestParam(required = false) String fPic, @RequestParam(required = false) String fRealName,
                                                @RequestParam(required = false) Integer fSex,
                                               @RequestParam(required = false)  String fBirthday){
        CommonResult<Boolean> commonResult = new CommonResult<>();
        System.err.println("fPic--------------->"+fPic);
        String token = getToken(request);
        try {
            TdzxMainUser mainUser = userService.findMainUserByToken(token);
            if (mainUser==null){
                commonResult.setCode(Constant.NUM_TWO);
                commonResult.setData(false);
                commonResult.setMessage(PromptMessage.TOKEN_PASS);
                return commonResult;
            }
            mainUser.setfPic(fPic);
            mainUser.setfRealName(fRealName);
            mainUser.setfSex(fSex==null?0:fSex);
            mainUser.setfBirthday(fBirthday);
            int k = userService.updateMainUser(mainUser);
            if (k>0){
                commonResult.setCode(Constant.NUM_ONE);
                commonResult.setData(true);
                commonResult.setMessage(PromptMessage.OPERATE_SUCCESS);
                return commonResult;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        commonResult.setCode(Constant.NUM_ZERO);
        commonResult.setData(false);
        commonResult.setMessage(PromptMessage.OPERATE_FAILD);
        return commonResult;
    }


    @ApiOperation(value = "主账号--修改密码")
    @RequestMapping(value = "updateMainUserPwd", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fTel",value = "手机号",required=true, paramType = "query"),
            @ApiImplicitParam(name="fCode",value = "验证码",required=true, paramType = "query"),
            @ApiImplicitParam(name="fNewPwd",value = "新密码",required=true, paramType = "query"),
    })
    @ResponseBody
    public CommonResult<Boolean> updateMainUserPwd(@RequestParam(required = true) String fTel, @RequestParam(required = true) String fCode,
                                                @RequestParam(required = true)  String fNewPwd){
        CommonResult<Boolean> commonResult = new CommonResult<>();
        int k = userService.updateMainUserPwd(fTel,fCode,fNewPwd);
        if (k==0){
            commonResult.setCode(Constant.NUM_ZERO);
            commonResult.setData(false);
            commonResult.setMessage(PromptMessage.OPERATE_FAILD);
        }
        if (k==1){
            commonResult.setCode(Constant.NUM_ONE);
            commonResult.setData(true);
            commonResult.setMessage(PromptMessage.OPERATE_SUCCESS);
        }
        if (k==2){
            commonResult.setCode(Constant.NUM_ZERO);
            commonResult.setData(false);
            commonResult.setMessage(PromptMessage.ACC_IS_NULL);
        }
        if (k==3){
            commonResult.setCode(Constant.NUM_ZERO);
            commonResult.setData(false);
            commonResult.setMessage(PromptMessage.ACC_SMS_ERR);
        }
        return commonResult;
    }


    @ApiOperation(value = "门店用户绑定（带上token）")
    @RequestMapping(value = "bindStoreUser", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fType",value = "业务类型(1:门店)",required=true, paramType = "query"),
            @ApiImplicitParam(name="fStoreMobile",value = "门店会员手机号",required=true, paramType = "query"),
            @ApiImplicitParam(name="fCode",value = "验证码",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Boolean> bindStoreUser(@RequestParam(required = true) String fType,
                                               @RequestParam(required = true) String fStoreMobile,@RequestParam(required = true) String fCode){
        CommonResult<Boolean> commonResult = new CommonResult<>();
        String token = getToken(request);
        int k = userService.bindStoreUser("UsFP+GsgKbXEYPxlw1vteqdwEWGAtHq0IyEqCuRem4PBbQ/de0utANeSzAocp3Gn8M+mDlotS1yXEFLBjBIzDRHfZ7ScnNX2fcoqtwW9DbUcxjc8s/fsQjD38P2c2MQi5O5WSI7DHMuQaMaTlf+xAwzOa5s0eDLYMRmrrzSp+VI=",fType,fStoreMobile,fCode);
        if (k==0){
            commonResult.setCode(Constant.NUM_ZERO);
            commonResult.setData(false);
            commonResult.setMessage(PromptMessage.OPERATE_FAILD);
        }
        if (k==1){
            commonResult.setCode(Constant.NUM_ONE);
            commonResult.setData(true);
            commonResult.setMessage(PromptMessage.OPERATE_SUCCESS);
        }
        if (k==2){
            commonResult.setCode(Constant.NUM_ZERO);
            commonResult.setData(false);
            commonResult.setMessage(PromptMessage.ACC_SMS_ERR);
        }
        if (k==3){
            commonResult.setCode(Constant.NUM_TWO);
            commonResult.setData(false);
            commonResult.setMessage(PromptMessage.TOKEN_PASS);
        }
        return commonResult;
    }

    /*@ApiOperation(value = "微信授权成功后---获取access_token和openID")
    @RequestMapping(value = "getTokenAndOpenID", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="code",value = "授权之后的code码",required=true, paramType = "query"),
            @ApiImplicitParam(name="fPic",value = "微信头像",required=true, paramType = "query"),
            @ApiImplicitParam(name="fName",value = "微信昵称",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Map<String,Object>> getTokenAndOpenID(@RequestParam(required = true) String code,@RequestParam(required = true) String fPic,
                                                              @RequestParam(required = true) String fName){
        CommonResult<Map<String,Object>> commonResult = new CommonResult<>();
        Map<String,Object> map = userService.getTokenAndOpenID(code,fPic,fName);
        commonResult.setCode(Constant.NUM_ONE);
        commonResult.setData(map);
        commonResult.setMessage(PromptMessage.OPERATE_SUCCESS);
        return commonResult;
    }*/


    /*@ApiOperation(value = "授权成功之后去登陆")
    @RequestMapping(value = "loginByTokenAndOpenID", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="access_token",value = "access_token",required=true, paramType = "query"),
            @ApiImplicitParam(name="refresh_token",value = "refresh_token",required=true, paramType = "query"),
            @ApiImplicitParam(name="openID",value = "openID",required=true, paramType = "query"),
            @ApiImplicitParam(name="fPic",value = "微信头像",required=false, paramType = "query"),
            @ApiImplicitParam(name="fName",value = "微信昵称",required=false, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Map<String,Object>> loginByTokenAndOpenID(@RequestParam(required = true) String access_token,
                                                                  @RequestParam(required = true) String refresh_token,
                                                                  @RequestParam(required = true) String openID,
                                                                  @RequestParam(required = true) String fPic,
                                                                  @RequestParam(required = true) String fName){
        CommonResult<Map<String,Object>> commonResult = new CommonResult<>();
        Map<String,Object> map = userService.loginByTokenAndOpenID(access_token,refresh_token,openID,fPic,fName);
        commonResult.setCode(Constant.NUM_ONE);
        commonResult.setData(map);
        commonResult.setMessage(PromptMessage.OPERATE_SUCCESS);
        return commonResult;
    }*/


    @ApiOperation(value = "微信登陆")
    @RequestMapping(value = "loginByVX", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="unionID",value = "unionID",required=true, paramType = "query"),
            @ApiImplicitParam(name="openID",value = "openID",required=true, paramType = "query"),
            @ApiImplicitParam(name="fPic",value = "微信头像",required=false, paramType = "query"),
            @ApiImplicitParam(name="fName",value = "微信昵称",required=false, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Map<String,Object>> loginByVX(@RequestParam(required = true) String unionID,
                                                                  @RequestParam(required = true) String openID,
                                                                  @RequestParam(required = false) String fPic,
                                                                  @RequestParam(required = false) String fName){
        CommonResult<Map<String,Object>> commonResult = new CommonResult<>();
        System.err.println("fName----------------"+fName);
        System.err.println("unionID----------------"+unionID);
        System.err.println("openID----------------"+openID);
        Map<String,Object> map = userService.loginByVX(unionID,openID,fPic,EmojiFilter.filterEmoji(fName));
        if (map==null || map.size()==0){
            commonResult.setCode(Constant.NUM_THREE);
            commonResult.setData(null);
            commonResult.setMessage(PromptMessage.OPERATE_SUCCESS);
            return commonResult;
        }
        commonResult.setCode(Constant.NUM_ONE);
        commonResult.setData(map);
        commonResult.setMessage(PromptMessage.OPERATE_SUCCESS);
        return commonResult;
    }


    @ApiOperation(value = "微信授权成功之后注册--》绑定")
    @RequestMapping(value = "VXRegistry", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="openID",value = "openID",required=true, paramType = "query"),
            @ApiImplicitParam(name="fTel",value = "手机号",required=true, paramType = "query"),
            @ApiImplicitParam(name="fTelCode",value = "验证码",required=true, paramType = "query"),
            @ApiImplicitParam(name="fPwd",value = "密码",required=false, paramType = "query"),
            @ApiImplicitParam(name="fPic",value = "微信头像",required=false, paramType = "query"),
            @ApiImplicitParam(name="fName",value = "微信昵称",required=false, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Map<String,Object>> VXRegistry(@RequestParam(required = true) String openID,
                                                       @RequestParam(required = true) String fTel,@RequestParam(required = true) String fTelCode,
                                                       @RequestParam(required = false) String fPwd,@RequestParam(required = false) String fPic,
                                                       @RequestParam(required = false) String fName){
        CommonResult<Map<String,Object>> commonResult = new CommonResult<>();
        commonResult = userService.VXRegistry(openID,fTel,fPwd,fTelCode,fPic,fName);
        return commonResult;
    }


    @ApiOperation(value = "新增，编辑收货地址(带token)")
    @RequestMapping(value = "addUserAdress", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fAdressID",value = "收货地址ID（编辑的时候传，新增的时候不用传）",required=false, paramType = "query"),
            @ApiImplicitParam(name="fReceiveName",value = "收货人",required=true, paramType = "query"),
            @ApiImplicitParam(name="fReceiveTel",value = "收货人手机号",required=true, paramType = "query"),
            @ApiImplicitParam(name="fAdressType",value = "地址类型（1：家庭  2：公司  3：其他）",required=true, paramType = "query"),
            @ApiImplicitParam(name="fProvince",value = "省",required=true, paramType = "query"),
            @ApiImplicitParam(name="fCity",value = "市",required=true, paramType = "query"),
            @ApiImplicitParam(name="fArea",value = "区",required=true, paramType = "query"),
            @ApiImplicitParam(name="fDetailAdress",value = "详细地址",required=true, paramType = "query"),
            @ApiImplicitParam(name="fIsDefaultAdress",value = "是否设为默认地址(1:是  0：不是)",required=true, paramType = "query"),
    })
    @ResponseBody
    public CommonResult<Boolean> addUserAdress(@RequestParam(required = false) Integer fAdressID,
                                                @RequestParam(required = true) String fReceiveName,@RequestParam(required = true) String fReceiveTel,
                                               @RequestParam(required = true) Integer fAdressType,@RequestParam(required = true) String fProvince,
                                               @RequestParam(required = true) String fCity,@RequestParam(required = true) String fArea,
                                               @RequestParam(required = true) String fDetailAdress,@RequestParam(required = true) Integer fIsDefaultAdress){
        CommonResult<Boolean> commonResult = new CommonResult<>();
        String token = getToken(request);
        int k = userService.addUserAdress(token,fAdressID,fReceiveName,fReceiveTel,fAdressType,fProvince,fCity,fArea,fDetailAdress,fIsDefaultAdress);
        if (k==1){
            commonResult.setCode(Constant.NUM_ONE);
            commonResult.setData(true);
            commonResult.setMessage(PromptMessage.OPERATE_SUCCESS);
        }
        if (k==0){
            commonResult.setCode(Constant.NUM_ZERO);
            commonResult.setData(false);
            commonResult.setMessage(PromptMessage.OPERATE_FAILD);
        }
        if (k==3){
            commonResult.setCode(Constant.NUM_TWO);
            commonResult.setData(false);
            commonResult.setMessage(PromptMessage.TOKEN_PASS);
        }
        return commonResult;
    }


    @ApiOperation(value = "查看所有收货地址(带token)")
    @RequestMapping(value = "selectUserAdress", method = RequestMethod.POST)
    @ApiImplicitParams({
    })
    @ResponseBody
    public CommonResult<List<UserAdress>> selectUserAdress(){
        CommonResult<List<UserAdress>> commonResult = new CommonResult<>();
        String token = getToken(request);
        commonResult= userService.selectUserAdress(token);
        return commonResult;
    }

    @ApiOperation(value = "查看默认收货地址(带token)")
    @RequestMapping(value = "getDeafaultUserAdress", method = RequestMethod.POST)
    @ApiImplicitParams({
    })
    @ResponseBody
    public CommonResult<UserAdress> getDeafaultUserAdress(){
        CommonResult<UserAdress> commonResult = new CommonResult<>();
        String token = getToken(request);
        commonResult= userService.getDeafaultUserAdress(token);
        return commonResult;
    }


    @ApiOperation(value = "通过用户ID查看所有收货地址")
    @RequestMapping(value = "selectUserAdressByUserID", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fMainUserID",value = "用户ID",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<List<UserAdress>> selectUserAdressByUserID(@RequestParam(required = true) String fMainUserID){
        CommonResult<List<UserAdress>> commonResult = new CommonResult<>();
        commonResult= userService.selectUserAdressByUserID(fMainUserID);
        return commonResult;
    }


    @ApiOperation(value = "删除收货地址")
    @RequestMapping(value = "deteleUserAdress", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fAdressID",value = "收货地址ID",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Boolean> deteleUserAdress(@RequestParam(required = true) Integer fAdressID){
        CommonResult<Boolean> commonResult = new CommonResult<>();
        int k = userService.deteleUserAdress(fAdressID);
        if (k>0){
            commonResult.setCode(Constant.NUM_ONE);
            commonResult.setData(true);
            commonResult.setMessage(PromptMessage.OPERATE_SUCCESS);
        }else {
            commonResult.setCode(Constant.NUM_ZERO);
            commonResult.setData(false);
            commonResult.setMessage(PromptMessage.OPERATE_FAILD);
        }
        return commonResult;
    }


    @ApiOperation(value = "根据token获取用户信息")
    @RequestMapping(value = "getUserInfoByToken", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="token",value = "token",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<TdzxMainUser> getUserInfoByToken(@RequestParam(required = true) String token){
        CommonResult<TdzxMainUser> commonResult = new CommonResult<>();
        try {
            TdzxMainUser mainUser = userService.findMainUserByToken(token);
            if (mainUser!=null){
                commonResult.setCode(Constant.NUM_ONE);
                commonResult.setData(mainUser);
                commonResult.setMessage(PromptMessage.LOAD_SUCCESS);
            }else {
                commonResult.setCode(Constant.NUM_TWO);
                commonResult.setData(mainUser);
                commonResult.setMessage(PromptMessage.TOKEN_PASS);
            }
        }catch (Exception e){
            e.printStackTrace();
            commonResult.setCode(Constant.NUM_ZERO);
            commonResult.setData(null);
            commonResult.setMessage(PromptMessage.LOAD_FAIL);
        }
        return commonResult;
    }


    @ApiOperation(value = "通过用户ID取会员折扣")
    @RequestMapping(value = "getDiscountByUserID", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fMainUserID",value = "用户ID",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Double> getDiscountByUserID(@RequestParam(required = true) String fMainUserID){
        CommonResult<Double> commonResult = new CommonResult<>();
        commonResult= userService.getDiscountByUserID(fMainUserID);
        return commonResult;
    }


    @ApiOperation(value = "悦订网注册")
    @RequestMapping(value = "registryYueDing", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fType",value = "1000:悦订网 ",required=true, paramType = "query"),
            @ApiImplicitParam(name="fMainUserID",value = "主用户ID",required=true, paramType = "query"),
            @ApiImplicitParam(name="fName",value = "悦订网注册-用户名",required=true, paramType = "query"),
            @ApiImplicitParam(name="fRealName",value = "悦订网注册-姓名",required=true, paramType = "query"),
            @ApiImplicitParam(name="fSex",value = "悦订网注册-性别（1:男；2:女；0:未知）",required=false, paramType = "query"),
            @ApiImplicitParam(name="fJob",value = "悦订网注册-身份",required=false, paramType = "query"),
            @ApiImplicitParam(name="fArea",value = "悦订网注册-地区",required=false, paramType = "query"),
            @ApiImplicitParam(name="fSchool",value = "悦订网注册-学校",required=true, paramType = "query"),
            @ApiImplicitParam(name="fGrade",value = "悦订网注册-年级",required=true, paramType = "query"),
            @ApiImplicitParam(name="fClass",value = "悦订网注册-班级",required=true, paramType = "query"),
            @ApiImplicitParam(name="fDetailAdress",value = "悦订网注册-详细地址",required=true, paramType = "query"),
            @ApiImplicitParam(name="fMobile",value = "悦订网注册-手机号",required=true, paramType = "query"),
            @ApiImplicitParam(name="fEmail",value = "悦订网注册-邮箱",required=false, paramType = "query"),
            @ApiImplicitParam(name="fPwd",value = "悦订网注册-密码",required=true, paramType = "query"),
    })
    @ResponseBody
    public CommonResult<UserStore> registryYueDing(@RequestParam(required = true) String fType,
                                                    @RequestParam(required = true) Integer fMainUserID,@RequestParam(required = true) String fName,
                                                   @RequestParam(required = true) String fRealName,@RequestParam(required = false) String fSex,
                                                   @RequestParam(required = false) String fJob,@RequestParam(required = false) String fArea,
                                                   @RequestParam(required = true) String fSchool,@RequestParam(required = true) String fGrade,
                                                   @RequestParam(required = true) String fClass,@RequestParam(required = true) String fDetailAdress,
                                                   @RequestParam(required = true) String fMobile,@RequestParam(required = false) String fEmail,
                                                   @RequestParam(required = true) String fPwd){
        CommonResult<UserStore> commonResult = new CommonResult<>();
        UserStore userStoreParam = new UserStore();
        UserStore userStore= new UserStore();
        if ("1000".equals(fType)){
            userStoreParam.setfBussType("2");   //悦订网
            userStoreParam.setfAcctID(fMainUserID);
            userStoreParam.setfName(fName);
            userStoreParam.setfRealName(fRealName);
            userStoreParam.setfSex(fSex==null?0:Integer.parseInt(fSex));
            userStoreParam.setfJob(fJob);
            userStoreParam.setfArea(fArea);
            userStoreParam.setfSchool(fSchool);
            userStoreParam.setfGrade(fGrade);
            userStoreParam.setfClass(fClass);
            userStoreParam.setfDetailAdress(fDetailAdress);
            userStoreParam.setfMobile(fMobile);
            userStoreParam.setfEmail(fEmail);
            userStoreParam.setfPwd(fPwd);
            userStoreParam.setfCreateTime(System.currentTimeMillis()/1000+"");
            userStore= userService.registryYueDing(userStoreParam);
        }
        commonResult.setCode(1);
        commonResult.setData(userStore);
        return commonResult;
    }


    @ApiOperation(value = "悦订网登陆(带token)")
    @RequestMapping(value = "loginYueDing", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fBussType",value = "业务类型(1:电商 2:悦订网 3：教材教辅 4 党政读物 5 书香节 6 大中专 7 图书馆配)",required=true, paramType = "query"),
            @ApiImplicitParam(name="fName",value = "悦订网注册-用户名",required=false, paramType = "query"),
            @ApiImplicitParam(name="fPwd",value = "悦订网注册-密码",required=false, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Map<String,Object>> loginYueDing(@RequestParam(required = true) String fBussType,@RequestParam(required = false) String fName,
                                                         @RequestParam(required = false) String fPwd) {
        System.err.println("fBussType:"+fBussType+"  fName:"+fName+"  fPwd:"+fPwd);
        CommonResult<Map<String, Object>> commonResult = new CommonResult<>();
        TdzxMainUser mainUser = new TdzxMainUser();
        String token = getToken(request);
        try {
            if (token==null){
                commonResult.setCode(Constant.NUM_TWO);
                commonResult.setData(null);
                commonResult.setMessage(PromptMessage.TOKEN_PASS);
                return commonResult;
            }

            mainUser = userService.findMainUserByToken(token);
            if (mainUser == null) {
                commonResult.setCode(Constant.NUM_TWO);
                commonResult.setData(null);
                commonResult.setMessage(PromptMessage.TOKEN_PASS);
                return commonResult;
            }

            if (fName == null && fPwd == null) {
                return userService.loginByMainUser(fBussType,mainUser.getfInnerID());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return userService.loginYueDing(fBussType,mainUser.getfInnerID(),fName, fPwd);
    }


    @RequestMapping(value = "getGuanLianList", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fMainUserID",value = "用户ID",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Double> getGuanLianList(@RequestParam(required = true) String fMainUserID){
        CommonResult<Double> commonResult = new CommonResult<>();
        commonResult= userService.getDiscountByUserID(fMainUserID);
        return commonResult;
    }


    @ApiOperation(value = "获取会员用户列表")
    @RequestMapping(value = "getUserMemberList", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name="storeSapId",value = "门店sap ID",required=false, paramType = "query"),
            @ApiImplicitParam(name="fRealName",value = "真实姓名",required=false, paramType = "query"),
            @ApiImplicitParam(name="fUserName",value = "昵称",required=false, paramType = "query"),
            @ApiImplicitParam(name="fMemberTypeID",value = "会员类型ID",required=false, paramType = "query"),
            @ApiImplicitParam(name="pageNum",value = "第几页",required=true, paramType = "query"),
            @ApiImplicitParam(name="pageSize",value = "一页多少条",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<PageTO<UserMember>> getUserMemberList(@RequestParam(required = false) String storeSapId,@RequestParam(required = false) String fRealName,
                                                              @RequestParam(required = false) String fUserName,@RequestParam(required = false) Integer fMemberTypeID,
                                                              @RequestParam(required = true) Integer pageNum,@RequestParam(required = true) Integer pageSize){
        CommonResult<PageTO<UserMember>> commonResult = new CommonResult<>();
        PageTO<UserMember> pageTO = userService.getUserMemberList(storeSapId,fRealName,fUserName,fMemberTypeID,pageNum,pageSize);
        commonResult.setCode(1);
        commonResult.setData(pageTO);
        return commonResult;
    }



    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value = "getMainUserList", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fRealName",value = "真实姓名",required=false, paramType = "query"),
            @ApiImplicitParam(name="fUserName",value = "昵称",required=false, paramType = "query"),
            @ApiImplicitParam(name="fMobile",value = "手机号",required=false, paramType = "query"),
            @ApiImplicitParam(name="pageNum",value = "第几页",required=true, paramType = "query"),
            @ApiImplicitParam(name="pageSize",value = "一页多少条",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<PageTO<TdzxMainUser>> getMainUserList(@RequestParam(required = false) String fRealName,@RequestParam(required = false) String fUserName,
                                                              @RequestParam(required = false) String fMobile,
                                                              @RequestParam(required = true) Integer pageNum,@RequestParam(required = true) Integer pageSize){
        return userService.getMainUserList(fRealName,fUserName,fMobile,pageNum,pageSize);
    }


    /*@ApiOperation(value = "修改密码")
    @RequestMapping(value = "updatePwd", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fMobile",value = "手机号",required=true, paramType = "query"),
            @ApiImplicitParam(name="code",value = "验证码",required=true, paramType = "query"),
            @ApiImplicitParam(name="newPwd",value = "新密码",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Boolean> updatePwd(@RequestParam(required = true) String fMobile,@RequestParam(required = true) String code,
                                                              @RequestParam(required = true) String newPwd){
        return userService.updatePwd(fMobile,code,newPwd);
    }*/


    @ApiOperation(value = "修改手机号")
    @RequestMapping(value = "updateMobile", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fOldMobile",value = "旧手机号",required=false, paramType = "query"),
            @ApiImplicitParam(name="oldCode",value = "旧验证码",required=false, paramType = "query"),
            @ApiImplicitParam(name="fNewMobile",value = "新手机号",required=false, paramType = "query"),
            @ApiImplicitParam(name="newCode",value = "新验证码",required=false, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Boolean> updateMobile(@RequestParam(required = false) String fOldMobile,@RequestParam(required = false) String oldCode,
                                           @RequestParam(required = false) String fNewMobile,@RequestParam(required = false) String newCode){
        return userService.updateMobile(fOldMobile,oldCode,fNewMobile,newCode);
    }


    @ApiOperation(value = "小程序授权登陆")
    @RequestMapping(value = "loginXCX", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="xcxCode",value = "小程序登录时获取的 code",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Map<String,Object>> loginXCX(@RequestParam(required = true) String xcxCode){
        return userService.loginXCX(xcxCode);
    }


    @ApiOperation(value = "小程序绑定用户")
    @RequestMapping(value = "bandXCX", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="encryptedData",value = "包括敏感数据在内的完整用户信息的加密数据",required = true,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="iv",value = "加密算法的初始向量",required = true,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="fOpenID",value = "微信用户ID",required = true,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="fPic",value = "微信头像",required=false, paramType = "query"),
            @ApiImplicitParam(name="fName",value = "微信昵称",required=false, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Map<String,Object>> bandXCX(@RequestParam(required = true) String encryptedData,@RequestParam(required = true) String iv,
                                                    @RequestParam(required = true) String fOpenID,@RequestParam(required = false) String fPic,
                                                    @RequestParam(required = false) String fName){
        return userService.bandXCX(encryptedData,iv,fOpenID,fPic,fName);
    }


    @ApiOperation(value = "(电商，悦订网)----获取用户列表")
    @RequestMapping(value = "getBussTypeUserList", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fName",value = "昵称",required=false, paramType = "query"),
            @ApiImplicitParam(name="fRealName",value = "真实姓名",required=false, paramType = "query"),
            @ApiImplicitParam(name="fBussType",value = "1:电商 2:悦订网",required=true, paramType = "query"),
            @ApiImplicitParam(name="pageNum",value = "第几页",required=true, paramType = "query"),
            @ApiImplicitParam(name="pageSize",value = "一页多少条",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<PageTO<UserStore>> getBussTypeUserList(@RequestParam(required = false) String fName,@RequestParam(required = false) String fRealName,
                                                               @RequestParam(required = true) String fBussType,@RequestParam(required = true) Integer pageNum,
                                                               @RequestParam(required = true) Integer pageSize){
        return userService.getBussTypeUserList(fName,fRealName,fBussType,pageNum,pageSize);
    }

    @ApiOperation(value = "(电商，悦订网)----编辑用户信息")
    @RequestMapping(value = "updateUserList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Boolean> updateUserList(@RequestBody UserStore userStore){
        return userService.updateUserList(userStore);
    }

    @ApiOperation(value = "教材教辅----获取用户列表")
    @RequestMapping(value = "getBussTypeStudentList", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="studentname",value = "名称",required=false, paramType = "query"),
            @ApiImplicitParam(name="pageNum",value = "第几页",required=true, paramType = "query"),
            @ApiImplicitParam(name="pageSize",value = "一页多少条",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<PageTO<BusiStudentinfo>> getBussTypeStudentList(@RequestParam(required = false) String studentname,
                                                                        @RequestParam(required = true) Integer pageNum,
                                                                        @RequestParam(required = true) Integer pageSize){
        return userService.getBussTypeStudentList(studentname,pageNum,pageSize);
    }


    @ApiOperation(value = "教材教辅----编辑用户信息")
    @RequestMapping(value = "updateStudentList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Boolean> updateStudentList(@RequestBody BusiStudentinfo busiStudentinfo){
        return userService.updateStudentList(busiStudentinfo);
    }


    @ApiOperation(value = "党政读物----获取用户列表")
    @RequestMapping(value = "getBussTypeCompanyList", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="studentname",value = "名称",required=false, paramType = "query"),
            @ApiImplicitParam(name="pageNum",value = "第几页",required=true, paramType = "query"),
            @ApiImplicitParam(name="pageSize",value = "一页多少条",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<PageTO<DzBusiStudentinfo>> getBussTypeCompanyList(@RequestParam(required = false) String studentname,
                                                                          @RequestParam(required = true) Integer pageNum,
                                                                        @RequestParam(required = true) Integer pageSize){
        return userService.getBussTypeCompanyList(studentname,pageNum,pageSize);
    }

    @ApiOperation(value = "党政读物----编辑用户信息")
    @RequestMapping(value = "updateCompanyList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Boolean> updateCompanyList(@RequestBody DzBusiStudentinfo dzBusiStudentinfo){
        return userService.updateCompanyList(dzBusiStudentinfo);
    }


    @ApiOperation(value = "获取主用户列表")
    @RequestMapping(value = "getBusMainUserList", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fName",value = "昵称",required=false, paramType = "query"),
            @ApiImplicitParam(name="fRealName",value = "真实姓名",required=false, paramType = "query"),
            @ApiImplicitParam(name="pageNum",value = "第几页",required=true, paramType = "query"),
            @ApiImplicitParam(name="pageSize",value = "一页多少条",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<PageTO<TdzxMainUser>> getBusMainUserList(@RequestParam(required = false) String fName,@RequestParam(required = false) String fRealName,
                                                             @RequestParam(required = true) Integer pageNum,@RequestParam(required = true) Integer pageSize){
        return userService.getBusMainUserList(fName,fRealName,pageNum,pageSize);
    }


    @ApiOperation(value = "编辑主用户信息")
    @RequestMapping(value = "updateTdzxMainUser", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Boolean> updateTdzxMainUser(@RequestBody TdzxMainUser tdzxMainUser){
        return userService.updateTdzxMainUser(tdzxMainUser);
    }


    @RequestMapping(value = "getInfo", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Map<String,Integer>> getInfo(){
        return userService.getInfo();
    }

}
