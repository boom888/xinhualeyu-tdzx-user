package com.tdzx.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("子账号表 ")
public class UserStore implements Serializable {
    private int fInnerID;
    @ApiModelProperty("系统类型(1:电商 2:悦订网 3：教材教辅 4 党政读物 5 书香节 6 大中专 7 图书馆配)")
    private String fBussType;
    @ApiModelProperty("主账号ID")
    private int fAcctID;
    @ApiModelProperty("主账号手机号")
    private String fMainMobile;
    @ApiModelProperty("子账号手机号")
    private String fMobile;
    @ApiModelProperty("子账号密码")
    private String fPwd;
    @ApiModelProperty("子账号真实姓名")
    private String fRealName;
    @ApiModelProperty("子账号昵称")
    private String fName;
    @ApiModelProperty("出生日期")
    private String fBirthday;
    @ApiModelProperty("子账号头像")
    private String fPic;
    @ApiModelProperty("1:男；2:女；0:未知")
    private int fSex;
    @ApiModelProperty("拥有积分数")
    private double fIntegralNum;
    @ApiModelProperty("消费金额")
    private double fConsumption;
    @ApiModelProperty("创建时间")
    private String fCreateTime;
    @ApiModelProperty("最后修改时间")
    private String fLastUpdateTime;
    @ApiModelProperty("账号状态(1：启用  0：禁用)")
    private int fStatue;
    @ApiModelProperty("身份")
    private String fJob;
    @ApiModelProperty("地区")
    private String fArea;
    @ApiModelProperty("学校")
    private String fSchool;
    @ApiModelProperty("年级")
    private String fGrade;
    @ApiModelProperty("班级")
    private String fClass;
    @ApiModelProperty("详细地址")
    private String fDetailAdress;
    @ApiModelProperty("邮箱")
    private String fEmail;

    public String getfMainMobile() {
        return fMainMobile;
    }

    public void setfMainMobile(String fMainMobile) {
        this.fMainMobile = fMainMobile;
    }

    public String getfRealName() {
        return fRealName;
    }

    public void setfRealName(String fRealName) {
        this.fRealName = fRealName;
    }

    public String getfJob() {
        return fJob;
    }

    public void setfJob(String fJob) {
        this.fJob = fJob;
    }

    public String getfArea() {
        return fArea;
    }

    public void setfArea(String fArea) {
        this.fArea = fArea;
    }

    public String getfSchool() {
        return fSchool;
    }

    public void setfSchool(String fSchool) {
        this.fSchool = fSchool;
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

    public String getfDetailAdress() {
        return fDetailAdress;
    }

    public void setfDetailAdress(String fDetailAdress) {
        this.fDetailAdress = fDetailAdress;
    }

    public String getfEmail() {
        return fEmail;
    }

    public void setfEmail(String fEmail) {
        this.fEmail = fEmail;
    }

    public String getfBussType() {
        return fBussType;
    }

    public void setfBussType(String fBussType) {
        this.fBussType = fBussType;
    }

    public double getfConsumption() {
        return fConsumption;
    }

    public void setfConsumption(double fConsumption) {
        this.fConsumption = fConsumption;
    }

    public String getfBirthday() {
        return fBirthday;
    }

    public void setfBirthday(String fBirthday) {
        this.fBirthday = fBirthday;
    }

    public int getfInnerID() {
        return fInnerID;
    }

    public void setfInnerID(int fInnerID) {
        this.fInnerID = fInnerID;
    }

    public int getfAcctID() {
        return fAcctID;
    }

    public void setfAcctID(int fAcctID) {
        this.fAcctID = fAcctID;
    }

    public String getfMobile() {
        return fMobile;
    }

    public void setfMobile(String fMobile) {
        this.fMobile = fMobile;
    }

    public String getfPwd() {
        return fPwd;
    }

    public void setfPwd(String fPwd) {
        this.fPwd = fPwd;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfPic() {
        return fPic;
    }

    public void setfPic(String fPic) {
        this.fPic = fPic;
    }

    public int getfSex() {
        return fSex;
    }

    public void setfSex(int fSex) {
        this.fSex = fSex;
    }


    public double getfIntegralNum() {
        return fIntegralNum;
    }

    public void setfIntegralNum(double fIntegralNum) {
        this.fIntegralNum = fIntegralNum;
    }

    public String getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(String fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public String getfLastUpdateTime() {
        return fLastUpdateTime;
    }

    public void setfLastUpdateTime(String fLastUpdateTime) {
        this.fLastUpdateTime = fLastUpdateTime;
    }

    public int getfStatue() {
        return fStatue;
    }

    public void setfStatue(int fStatue) {
        this.fStatue = fStatue;
    }
}
