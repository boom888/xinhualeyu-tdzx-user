package com.tdzx.user.controller;

import com.tdzx.user.domain.*;
import com.tdzx.user.service.MemberService;
import com.tdzx.user.service.UserService;
import com.tdzx.user.utils.CommonResult;
import com.tdzx.user.utils.Constant;
import com.tdzx.user.utils.PromptMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "member", description = "会员相关API")
@Controller
public class MemberController extends BaseController{

    @Autowired
    private MemberService memberService;

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);


    @ApiOperation(value = "获取会员卡类型")
    @RequestMapping(value = "getMemberType", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fBussType",value = "业务类型(1:电商)",required=true, paramType = "query"),
            @ApiImplicitParam(name="fMemberTypeID",value = "会员卡类型ID",required=false, paramType = "query")
    })
    @ResponseBody
    public CommonResult<List<MemberType>> getMemberType(@RequestParam(required = true) String fBussType,@RequestParam(required = false) Integer fMemberTypeID){
        CommonResult<List<MemberType>> commonResult = new CommonResult<>();
        System.err.println("fMemberTypeID = "+fMemberTypeID);
        List<MemberType> memberTypeList = memberService.getMemberType(fBussType,fMemberTypeID);
        commonResult.setCode(Constant.NUM_ONE);
        commonResult.setData(memberTypeList);
        commonResult.setMessage(PromptMessage.LOAD_SUCCESS);
        return commonResult;
    }

    @ApiOperation(value = "门店会员购买（带上token）----暂缓")
    @RequestMapping(value = "buyStoreMember", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fSiteID",value = "门店ID",required=true, paramType = "query"),
            @ApiImplicitParam(name="fMemberTypeID",value = "会员卡类型ID",required=true, paramType = "query"),
            @ApiImplicitParam(name="fPrice",value = "价格",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Boolean> buyStoreMember(@RequestParam(required = true) Integer fSiteID,@RequestParam(required = true) Integer fMemberTypeID,
                                                @RequestParam(required = true) Integer fPrice){
        CommonResult<Boolean> commonResult = new CommonResult<>();
        return commonResult;
    }

    @ApiOperation(value = "通过用户ID取储值卡")
    @RequestMapping(value = "getMemberByUserID", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fMainUserID",value = "用户ID",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<List<UserMember>> getMemberByUserID(@RequestParam(required = true) String fMainUserID){
        CommonResult<List<UserMember>> commonResult = new CommonResult<>();
        commonResult= userService.getMemberByUserID(fMainUserID);
        return commonResult;
    }


    @ApiOperation(value = "扣减储值卡的金额")
    @RequestMapping(value = "discountChiZhiCart", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fChuZhiCartNum",value = "储值卡号",required=true, paramType = "query"),
            @ApiImplicitParam(name="fAmount",value = "扣减金额",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult discountChiZhiCart(@RequestParam(required = true) String fChuZhiCartNum,@RequestParam(required = true) String fAmount){
        return userService.discountChiZhiCart(fChuZhiCartNum,fAmount);
    }


    @ApiOperation(value = "锁定 或 解锁储值卡")
    @RequestMapping(value = "lockMemberCart", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fMemCardNum",value = "会员卡号",required=true, paramType = "query"),
            @ApiImplicitParam(name="fIsLock",value = "锁定状态（1：锁定  0：未锁定）",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Boolean> lockMemberCart(@RequestParam(required = true) String fMemCardNum,@RequestParam(required = true) Integer fIsLock){
        CommonResult<Boolean> commonResult = new CommonResult<>();
        commonResult= memberService.lockMemberCart(fMemCardNum,fIsLock);
        return commonResult;
    }

    @ApiOperation(value = "用户注册会员")
    @RequestMapping(value = "userBandMember", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fBussType",value = "业务类型(1:电商)",required=false, paramType = "query"),
            @ApiImplicitParam(name="userID",value = "用户ID",required=true, paramType = "query"),
            @ApiImplicitParam(name="memberTypeID",value = "会员类型ID",required=true, paramType = "query"),
            @ApiImplicitParam(name="storeSapId",value = "门店Sap ID",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Boolean> userBandMember(@RequestParam(required = true) String fBussType,@RequestParam(required = true) Long userID,
                                                @RequestParam(required = true) Long memberTypeID,
                                                @RequestParam(required = true) String storeSapId){
        CommonResult<Boolean> commonResult = new CommonResult<>();
        commonResult= memberService.userBandMember(fBussType,userID,memberTypeID,storeSapId);
        return commonResult;
    }


    @ApiOperation(value = "用户绑定TBM会员")
    @RequestMapping(value = "userBandSapMember", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fBussType",value = "业务类型(1:电商)",required=true, paramType = "query"),
            @ApiImplicitParam(name="fMobile",value = "手机号",required=true, paramType = "query"),
            @ApiImplicitParam(name="fCode",value = "验证码",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Boolean> userBandSapMember(@RequestParam(required = true) String fBussType,
                                                   @RequestParam(required = true) String fMobile,@RequestParam(required = true) String fCode){
        CommonResult<Boolean> commonResult = new CommonResult<>();
        commonResult= memberService.userBandSapMember(fBussType,fMobile,fCode);
        return commonResult;
    }



    @ApiOperation(value = "会员管理")
    @RequestMapping(value = "memberAdmin", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fType",value = "类型(1:删除  2：设为默认)",required=true, paramType = "query"),
            @ApiImplicitParam(name="fAcctID",value = "主用户ID",required=true, paramType = "query"),
            @ApiImplicitParam(name="fUserMemberID",value = "用户会员ID",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Boolean> memberAdmin(@RequestParam(required = true) String fType,@RequestParam(required = true) Integer fAcctID,
                                             @RequestParam(required = true) Integer fUserMemberID){
        return memberService.memberAdmin(fType,fAcctID,fUserMemberID);
    }


    @ApiOperation(value = "绑定TBM储值卡")
    @RequestMapping(value = "bindSapChuZhiCart", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fAcctID",value = "主用户ID",required=true, paramType = "query"),
            @ApiImplicitParam(name="storeCode",value = "sap店号",required=false, paramType = "query"),
            @ApiImplicitParam(name="fMemberCartNum",value = "会员卡号",required=true, paramType = "query"),
            @ApiImplicitParam(name="fChuZhiCartNum",value = "储值卡号",required=true, paramType = "query"),
            @ApiImplicitParam(name="fChuZhiCartPwd",value = "储值卡密码",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<List<UserMember>> bindSapChuZhiCart(@RequestParam(required = true) Integer fAcctID,@RequestParam(required = false) String storeCode,
                                                            @RequestParam(required = true) String fMemberCartNum,
                                                            @RequestParam(required = true) String fChuZhiCartNum,@RequestParam(required = true) String fChuZhiCartPwd){
        return memberService.bindSapChuZhiCart(fAcctID,storeCode,fMemberCartNum,fChuZhiCartNum,fChuZhiCartPwd);
    }



    @ApiOperation(value = "提货卡绑定 商城/党政读物(带token)")
    @RequestMapping(value = "cardBandVip", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fBussType",value = "业务类型(1:电商 2:悦订网 3：教材教辅 4 党政读物 5 书香节 6 大中专 7 图书馆配)",required=true, paramType = "query"),
            @ApiImplicitParam(name="memberCard",value = "会员卡号",required=true, paramType = "query"),
            @ApiImplicitParam(name="activeCode",value = "激活码",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Boolean> cardBandVip(@RequestParam(required = true) String fBussType,@RequestParam(required = true) String memberCard,
                                             @RequestParam(required = true) String activeCode){
        CommonResult<Boolean> commonResult = new CommonResult<>();
        Map<String,String> map = new HashMap<>();
        String token = getToken(request);
        try {
            TdzxMainUser mainUser = userService.findMainUserByToken(token);
            if (mainUser == null) {
                commonResult.setCode(Constant.NUM_TWO);
                commonResult.setData(false);
                commonResult.setMessage(PromptMessage.TOKEN_PASS);
                return commonResult;
            }
            commonResult= memberService.cardBandVip(fBussType,mainUser.getfInnerID(),mainUser.getfMobile(),memberCard,activeCode);
        }catch (Exception e){
            e.printStackTrace();
            commonResult.setCode(Constant.NUM_TWO);
            commonResult.setData(false);
            commonResult.setMessage(PromptMessage.TOKEN_PASS);
            return commonResult;
        }
        return commonResult;
    }



    @ApiOperation(value = "大客户绑定 商城/党政读物(带token)")
    @RequestMapping(value = "userBandVip", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fBussType",value = "业务类型(1:电商 2:悦订网 3：教材教辅 4 党政读物 5 书香节 6 大中专 7 图书馆配)",required=true, paramType = "query"),
            @ApiImplicitParam(name="mobile",value = "手机号",required=true, paramType = "query"),
            @ApiImplicitParam(name="code",value = "验证码",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Boolean> userBandVip(@RequestParam(required = true) String fBussType,@RequestParam(required = true) String mobile,
                                             @RequestParam(required = true) String code){
        CommonResult<Boolean> commonResult = new CommonResult<>();
        Map<String,String> map = new HashMap<>();
        String token = getToken(request);
        try {
            TdzxMainUser mainUser = userService.findMainUserByToken(token);
            if (mainUser == null) {
                commonResult.setCode(Constant.NUM_TWO);
                commonResult.setData(false);
                commonResult.setMessage(PromptMessage.TOKEN_PASS);
                return commonResult;
            }
            commonResult= memberService.userBandVip(fBussType,mainUser.getfInnerID(),mobile,code);
        }catch (Exception e){
            e.printStackTrace();
            commonResult.setCode(Constant.NUM_TWO);
            commonResult.setData(false);
            commonResult.setMessage(PromptMessage.TOKEN_PASS);
            return commonResult;
        }
        return commonResult;
    }


    @ApiOperation(value = "通过省市区--搜索学校")
    @RequestMapping(value = "findSchool", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="province",value = "省（广东省）",required=true, paramType = "query"),
            @ApiImplicitParam(name="city",value = "市（广州市）",required=true, paramType = "query"),
            @ApiImplicitParam(name="area",value = "区（天河区）",required=true, paramType = "query"),
            @ApiImplicitParam(name="schoolName",value = "学校关键字",required=false, paramType = "query"),
    })
    @ResponseBody
    public CommonResult<List<BusiSchoolxx>> findSchool(@RequestParam(required = true) String province, @RequestParam(required = true) String city,
                                                       @RequestParam(required = true) String area,@RequestParam(required = false) String schoolName){
        CommonResult<List<BusiSchoolxx>> commonResult = new CommonResult<>();
        List<BusiSchoolxx> busiSchoolxxList = memberService.findSchool(province,city,area,schoolName);
        commonResult.setCode(1);
        commonResult.setData(busiSchoolxxList);
        return commonResult;
    }


    @ApiOperation(value = "通过学校ID--获取学校下面的年级班级")
    @RequestMapping(value = "getSchoolGradeClass", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="schoolID",value = "学校ID",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<List<BusiSchooljg>> getSchoolGradeClass(@RequestParam(required = true) String schoolID){
        CommonResult<List<BusiSchooljg>> commonResult = new CommonResult<>();
        List<BusiSchooljg> busiSchoolxxList = memberService.getSchoolGradeClass(schoolID);
        commonResult.setCode(1);
        commonResult.setData(busiSchoolxxList);
        return commonResult;
    }


    @ApiOperation(value = "注册教材教辅")
    @RequestMapping(value = "registryJCJF", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxID",value = "家长ID（添加孩子的时候才传）",required=false, paramType = "query"),
            @ApiImplicitParam(name="userID",value = "主用户ID",required=true, paramType = "query"),
            @ApiImplicitParam(name="realName",value = "姓名",required=true, paramType = "query"),
            @ApiImplicitParam(name="schoolId",value = "学校id",required=true, paramType = "query"),
            @ApiImplicitParam(name="schoolName",value = "学校名称",required=true, paramType = "query"),
            @ApiImplicitParam(name="gradeId",value = "年级id",required=true, paramType = "query"),
            @ApiImplicitParam(name="gradeName",value = "年级名称",required=true, paramType = "query"),
            @ApiImplicitParam(name="classId",value = "班级id",required=true, paramType = "query"),
            @ApiImplicitParam(name="className",value = "班级名称",required=true, paramType = "query"),
            @ApiImplicitParam(name="mobile",value = "手机号",required=true, paramType = "query"),
            @ApiImplicitParam(name="code",value = "验证码",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<List<BusiStudentinfo>> registryJCJF(@RequestParam(required = false) String wxID,
                                              @RequestParam(required = true) Integer userID,@RequestParam(required = true) String realName,
                                              @RequestParam(required = true) String schoolId,@RequestParam(required = true) String schoolName,
                                              @RequestParam(required = true) String gradeId,@RequestParam(required = true) String gradeName,
                                              @RequestParam(required = true) String classId,@RequestParam(required = true) String className,
                                              @RequestParam(required = true) String mobile,@RequestParam(required = true) String code){
        return memberService.registryJCJF(wxID,userID,realName,schoolId,schoolName,gradeId,gradeName,classId,className,mobile,code);
    }


    @ApiOperation(value = "获取孩子列表")
    @RequestMapping(value = "getStudentList", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxID",value = "家长ID",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<List<BusiStudentinfo>> getStudentList(@RequestParam(required = true) String wxID){
        CommonResult<List<BusiStudentinfo>> commonResult = new CommonResult<>();
        return memberService.getStudentList(wxID);
    }


    @ApiOperation(value = "通过省市区--搜索单位")
    @RequestMapping(value = "findCompany", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="province",value = "省（广东省）",required=true, paramType = "query"),
            @ApiImplicitParam(name="city",value = "市（广州市）",required=true, paramType = "query"),
            @ApiImplicitParam(name="area",value = "区（天河区）",required=true, paramType = "query"),
            @ApiImplicitParam(name="companyName",value = "单位关键字",required=false, paramType = "query")
    })
    @ResponseBody
    public CommonResult<List<DzBusiSchoolxx>> findCompany(@RequestParam(required = true) String province, @RequestParam(required = true) String city,
                                                       @RequestParam(required = true) String area,@RequestParam(required = false) String companyName){
        CommonResult<List<DzBusiSchoolxx>> commonResult = new CommonResult<>();
        List<DzBusiSchoolxx> busiSchoolxxList = memberService.findCompany(province,city,area,companyName);
        commonResult.setCode(1);
        commonResult.setData(busiSchoolxxList);
        return commonResult;
    }


    @ApiOperation(value = "通过单位ID--获取单位下面的职位职务")
    @RequestMapping(value = "getCompanyInfo", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="companyID",value = "单位ID",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<List<DzBusiSchooljg>> getCompanyInfo(@RequestParam(required = true) String companyID){
        CommonResult<List<DzBusiSchooljg>> commonResult = new CommonResult<>();
        List<DzBusiSchooljg> dzBusiSchooljgList = memberService.getCompanyInfo(companyID);
        commonResult.setCode(1);
        commonResult.setData(dzBusiSchooljgList);
        return commonResult;
    }


    @ApiOperation(value = "注册党政读物")
    @RequestMapping(value = "registryDZDW", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="userID",value = "主用户ID",required=true, paramType = "query"),
            @ApiImplicitParam(name="realName",value = "姓名",required=true, paramType = "query"),
            @ApiImplicitParam(name="schoolId",value = "单位id",required=true, paramType = "query"),
            @ApiImplicitParam(name="schoolName",value = "单位名称",required=true, paramType = "query"),
            @ApiImplicitParam(name="gradeId",value = "职位id",required=true, paramType = "query"),
            @ApiImplicitParam(name="gradeName",value = "职位名称",required=true, paramType = "query"),
            @ApiImplicitParam(name="classId",value = "职务id",required=true, paramType = "query"),
            @ApiImplicitParam(name="className",value = "职务名称",required=true, paramType = "query"),
            @ApiImplicitParam(name="mobile",value = "手机号",required=true, paramType = "query"),
            @ApiImplicitParam(name="code",value = "验证码",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<DzBusiStudentinfo> registryDZDW(@RequestParam(required = true) Integer userID,@RequestParam(required = true) String realName,
                                                            @RequestParam(required = true) String schoolId,@RequestParam(required = true) String schoolName,
                                                            @RequestParam(required = true) String gradeId,@RequestParam(required = true) String gradeName,
                                                            @RequestParam(required = true) String classId,@RequestParam(required = true) String className,
                                                            @RequestParam(required = true) String mobile,@RequestParam(required = true) String code){
        return memberService.registryDZDW(userID,realName,schoolId,schoolName,gradeId,gradeName,classId,className,mobile,code);
    }


    @ApiOperation(value = "获取党政读物用户信息")
    @RequestMapping(value = "getCompanyUserInfo", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fAcctID",value = "主账号ID",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<DzBusiStudentinfo> getCompanyUserInfo(@RequestParam(required = true) Integer fAcctID){
        return memberService.getCompanyUserInfo(fAcctID);
    }

    @RequestMapping(value = "getSchoolInfoByID", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fschoolID",value = "学校ID",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<BusiSchoolxx> getSchoolInfoByID(@RequestParam(required = true) String fschoolID){
        return memberService.getSchoolInfoByID(fschoolID);
    }

    @RequestMapping(value = "getCompanyInfoByID", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fcompanyID",value = "公司ID",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<DzBusiSchoolxx> getCompanyInfoByID(@RequestParam(required = true) String fcompanyID){
        return memberService.getCompanyInfoByID(fcompanyID);
    }


    @ApiOperation(value = "TBM储值卡充值")
    @RequestMapping(value = "rechargeTbmChuZhiCart", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fAcctID",value = "主用户ID",required=true, paramType = "query"),
            @ApiImplicitParam(name="fMemberCartNum",value = "会员卡号",required=true, paramType = "query"),
            @ApiImplicitParam(name="fChuZhiCartNum",value = "储值卡号",required=true, paramType = "query"),
            @ApiImplicitParam(name="totalPrice",value = "充值金额",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Boolean> rechargeTbmChuZhiCart(@RequestParam(required = true) Integer fAcctID,@RequestParam(required = true) String fMemberCartNum,
                                                       @RequestParam(required = true) String fChuZhiCartNum,@RequestParam(required = true) double totalPrice){
        return memberService.rechargeTbmChuZhiCart(fAcctID,fMemberCartNum,fChuZhiCartNum,totalPrice);
    }


    @ApiOperation(value = "TBM储值卡解绑")
    @RequestMapping(value = "unBindICCard", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fAcctID",value = "主用户ID",required=true, paramType = "query"),
            @ApiImplicitParam(name="fMemberCartNum",value = "会员卡号",required=true, paramType = "query"),
            @ApiImplicitParam(name="fChuZhiCartNum",value = "储值卡号",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Boolean> unBindICCard(@RequestParam(required = true) Integer fAcctID,@RequestParam(required = true) String fMemberCartNum,
                                              @RequestParam(required = true) String fChuZhiCartNum){
        return memberService.unBindICCard(fAcctID,fMemberCartNum,fChuZhiCartNum);
    }


    @ApiOperation(value = "会员卡解绑")
    @RequestMapping(value = "unBindMemberCard", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fAcctID",value = "主用户ID",required=true, paramType = "query"),
            @ApiImplicitParam(name="fMemberCartNum",value = "会员卡号",required=true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Boolean> unBindMemberCard(@RequestParam(required = true) Integer fAcctID,@RequestParam(required = true) String fMemberCartNum){
        return memberService.unBindMemberCard(fAcctID,fMemberCartNum);
    }
}
