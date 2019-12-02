package com.tdzx.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel("主账号")
public class TdzxMainUser implements Serializable {
    private int fInnerID;
    @ApiModelProperty("手机号")
    private String fMobile;
    @ApiModelProperty("密码")
    private String fPassWord;
    @ApiModelProperty("真实姓名")
    private String fRealName;
    @ApiModelProperty("1：男 ，0：女")
    private int fSex;
    @ApiModelProperty("用户头像")
    private String fPic;
    @ApiModelProperty("昵称")
    private String fName;
    @ApiModelProperty("生日")
    private String fBirthday;
    @ApiModelProperty("邮箱")
    private String fEmail;
    @ApiModelProperty("身份证号")
    private String fIDCard;
    @ApiModelProperty("职业")
    private String fJob;
    @ApiModelProperty("省ID")
    private int fProvinceID;
    @ApiModelProperty("市ID")
    private int fCityID;
    @ApiModelProperty("区ID")
    private int fAreaID;
    @ApiModelProperty("详细地址")
    private String fDetailAdress;
    @ApiModelProperty("学校ID")
    private String fSchoolID;
    @ApiModelProperty("年级")
    private String fGrade;
    @ApiModelProperty("班级")
    private String fClass;
    @ApiModelProperty("积分数量")
    private int fSurplusIntegral;
    @ApiModelProperty("账号状态(1：启用  0：禁用)")
    private int fStatue;
    @ApiModelProperty("创建时间")
    private String fCreateTime;
    @ApiModelProperty("微信的openID")
    private String openID;
    @ApiModelProperty("小程序的openID")
    private String xcxOpenID;
    @ApiModelProperty("unionID")
    private String unionID;
    @ApiModelProperty("会员折扣")
    private double fDiscount;
    @ApiModelProperty("是否是会员 1：是 , 0：不是")
    private int  fIsMember;
    @ApiModelProperty("默认的会员卡号")
    private String  defaultMemberCart;
    @ApiModelProperty("商城会员卡信息")
    private List<UserMember> userMemberList;
    @ApiModelProperty("商城储值卡信息")
    private List<UserMember> chuZhiCartList;

    @ApiModelProperty("大客户折扣")
    private double fVipDiscount;
    @ApiModelProperty("是否是大客户 1：是 , 0：不是")
    private int  fIsVip=0;
    @ApiModelProperty("家长ID(为空的话 表示没有注册教材教辅)")
    private String  wxID;
    @ApiModelProperty("公司ID")
    private String  companyID;
    @ApiModelProperty("会员类型(0:普通用户，1：悦读会员,2:悦享会员,3:悦乐会员)")
    private Integer  memberType=0;
    @ApiModelProperty("提货卡数量")
    private Integer  tihuoCartCount=0;

    @ApiModelProperty("悦订网账号信息")
    private UserStore  yueDingUser;
    @ApiModelProperty("教材教辅孩子列表信息")
    private List<BusiStudentinfo>  busiStudentinfoList;
    @ApiModelProperty("党政读物列表信息")
    private DzBusiStudentinfo  dzBusiStudentinfo;


    public Integer getTihuoCartCount() {
        return tihuoCartCount;
    }

    public void setTihuoCartCount(Integer tihuoCartCount) {
        this.tihuoCartCount = tihuoCartCount;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public String getDefaultMemberCart() {
        return defaultMemberCart;
    }

    public void setDefaultMemberCart(String defaultMemberCart) {
        this.defaultMemberCart = defaultMemberCart;
    }

    public String getXcxOpenID() {
        return xcxOpenID;
    }

    public void setXcxOpenID(String xcxOpenID) {
        this.xcxOpenID = xcxOpenID;
    }

    public String getUnionID() {
        return unionID;
    }

    public void setUnionID(String unionID) {
        this.unionID = unionID;
    }

    public DzBusiStudentinfo getDzBusiStudentinfo() {
        return dzBusiStudentinfo;
    }

    public void setDzBusiStudentinfo(DzBusiStudentinfo dzBusiStudentinfo) {
        this.dzBusiStudentinfo = dzBusiStudentinfo;
    }

    public List<BusiStudentinfo> getBusiStudentinfoList() {
        return busiStudentinfoList;
    }

    public void setBusiStudentinfoList(List<BusiStudentinfo> busiStudentinfoList) {
        this.busiStudentinfoList = busiStudentinfoList;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getWxID() {
        return wxID;
    }

    public void setWxID(String wxID) {
        this.wxID = wxID;
    }

    public double getfVipDiscount() {
        return fVipDiscount;
    }

    public void setfVipDiscount(double fVipDiscount) {
        this.fVipDiscount = fVipDiscount;
    }

    public int getfIsVip() {
        return fIsVip;
    }

    public void setfIsVip(int fIsVip) {
        this.fIsVip = fIsVip;
    }

    public List<UserMember> getUserMemberList() {
        return userMemberList;
    }

    public void setUserMemberList(List<UserMember> userMemberList) {
        this.userMemberList = userMemberList;
    }

    public List<UserMember> getChuZhiCartList() {
        return chuZhiCartList;
    }

    public void setChuZhiCartList(List<UserMember> chuZhiCartList) {
        this.chuZhiCartList = chuZhiCartList;
    }

    public UserStore getYueDingUser() {
        return yueDingUser;
    }

    public void setYueDingUser(UserStore yueDingUser) {
        this.yueDingUser = yueDingUser;
    }

    public int getfIsMember() {
        return fIsMember;
    }

    public void setfIsMember(int fIsMember) {
        this.fIsMember = fIsMember;
    }

    public double getfDiscount() {
        return fDiscount;
    }

    public void setfDiscount(double fDiscount) {
        this.fDiscount = fDiscount;
    }

    public String getOpenID() {
        return openID;
    }

    public void setOpenID(String openID) {
        this.openID = openID;
    }

    public int getfSex() {
        return fSex;
    }

    public void setfSex(int fSex) {
        this.fSex = fSex;
    }

    public int getfInnerID() {
        return fInnerID;
    }

    public void setfInnerID(int fInnerID) {
        this.fInnerID = fInnerID;
    }

    public String getfMobile() {
        return fMobile;
    }

    public void setfMobile(String fMobile) {
        this.fMobile = fMobile;
    }

    public String getfPassWord() {
        return fPassWord;
    }

    public void setfPassWord(String fPassWord) {
        this.fPassWord = fPassWord;
    }

    public String getfRealName() {
        return fRealName;
    }

    public void setfRealName(String fRealName) {
        this.fRealName = fRealName;
    }

    public String getfPic() {
        return fPic;
    }

    public void setfPic(String fPic) {
        this.fPic = fPic;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfBirthday() {
        return fBirthday;
    }

    public void setfBirthday(String fBirthday) {
        this.fBirthday = fBirthday;
    }

    public String getfEmail() {
        return fEmail;
    }

    public void setfEmail(String fEmail) {
        this.fEmail = fEmail;
    }

    public String getfIDCard() {
        return fIDCard;
    }

    public void setfIDCard(String fIDCard) {
        this.fIDCard = fIDCard;
    }

    public String getfJob() {
        return fJob;
    }

    public void setfJob(String fJob) {
        this.fJob = fJob;
    }

    public int getfProvinceID() {
        return fProvinceID;
    }

    public void setfProvinceID(int fProvinceID) {
        this.fProvinceID = fProvinceID;
    }

    public int getfCityID() {
        return fCityID;
    }

    public void setfCityID(int fCityID) {
        this.fCityID = fCityID;
    }

    public int getfAreaID() {
        return fAreaID;
    }

    public void setfAreaID(int fAreaID) {
        this.fAreaID = fAreaID;
    }

    public String getfDetailAdress() {
        return fDetailAdress;
    }

    public void setfDetailAdress(String fDetailAdress) {
        this.fDetailAdress = fDetailAdress;
    }

    public String getfSchoolID() {
        return fSchoolID;
    }

    public void setfSchoolID(String fSchoolID) {
        this.fSchoolID = fSchoolID;
    }

    public String getfGrade() {
        return fGrade;
    }

    public void setfGrade(String fGrade) {
        this.fGrade = fGrade;
    }

    public String getfClass() {
        return fClass;
    }

    public void setfClass(String fClass) {
        this.fClass = fClass;
    }

    public int getfSurplusIntegral() {
        return fSurplusIntegral;
    }

    public void setfSurplusIntegral(int fSurplusIntegral) {
        this.fSurplusIntegral = fSurplusIntegral;
    }

    public int getfStatue() {
        return fStatue;
    }

    public void setfStatue(int fStatue) {
        this.fStatue = fStatue;
    }

    public String getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(String fCreateTime) {
        this.fCreateTime = fCreateTime;
    }
}
