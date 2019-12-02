package com.tdzx.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel("用户会员表")
public class UserMember implements Serializable {
    private int fInnerID;
    @ApiModelProperty("主账号ID")
    private int fAcctID;
    @ApiModelProperty("子账号ID")
    private int fSubUserID;
    @ApiModelProperty("子账号对象")
    private UserStore userStore;
    @ApiModelProperty("会员卡类型ID")
    private int fMemTypeID;
    @ApiModelProperty("会员卡号")
    private String fMemCardNum;
    @ApiModelProperty("会员卡名称")
    private String fMemCardName;
    @ApiModelProperty("会员卡余额")
    private double fBalance;
    @ApiModelProperty("面值")
    private double fDenomination;
    @ApiModelProperty("会员卡折扣")
    private BigDecimal fDiscount;
    @ApiModelProperty("创建时间")
    private String fCreateDate;
    @ApiModelProperty("最后更新时间")
    private String fUpdateDate;
    @ApiModelProperty("会员有效期--结束时间")
    private String fIndate;
    @ApiModelProperty("1：启用 0：未启用")
    private int fStatue;
    @ApiModelProperty("是否锁定（1：锁定   0：未锁定）")
    private int fIsLock;
    @ApiModelProperty("门店号")
    private String storeNo;
    @ApiModelProperty("门店名称")
    private String storeName;
    @ApiModelProperty("门店SAP id")
    private String storeSapId;
    @ApiModelProperty("该卡拥有的积分")
    private Integer fIntegralNum;
    @ApiModelProperty("是否默认（1：是   0：不是）")
    private Integer fIsDefault;
    @ApiModelProperty("还差多少积分升为悦享会员")
    private Integer fMuchNum;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public double getfDenomination() {
        return fDenomination;
    }

    public void setfDenomination(double fDenomination) {
        this.fDenomination = fDenomination;
    }

    public String getfMemCardName() {
        return fMemCardName;
    }

    public void setfMemCardName(String fMemCardName) {
        this.fMemCardName = fMemCardName;
    }

    public UserStore getUserStore() {
        return userStore;
    }

    public void setUserStore(UserStore userStore) {
        this.userStore = userStore;
    }

    public Integer getfMuchNum() {
        return fMuchNum;
    }

    public void setfMuchNum(Integer fMuchNum) {
        this.fMuchNum = fMuchNum;
    }

    public Integer getfIsDefault() {
        return fIsDefault;
    }

    public void setfIsDefault(Integer fIsDefault) {
        this.fIsDefault = fIsDefault;
    }

    public Integer getfIntegralNum() {
        return fIntegralNum;
    }

    public void setfIntegralNum(Integer fIntegralNum) {
        this.fIntegralNum = fIntegralNum;
    }

    public String getStoreSapId() {
        return storeSapId;
    }

    public void setStoreSapId(String storeSapId) {
        this.storeSapId = storeSapId;
    }

    public int getfIsLock() {
        return fIsLock;
    }

    public void setfIsLock(int fIsLock) {
        this.fIsLock = fIsLock;
    }

    public int getfStatue() {
        return fStatue;
    }

    public void setfStatue(int fStatue) {
        this.fStatue = fStatue;
    }

    public String getfIndate() {
        return fIndate;
    }

    public void setfIndate(String fIndate) {
        this.fIndate = fIndate;
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

    public int getfSubUserID() {
        return fSubUserID;
    }

    public void setfSubUserID(int fSubUserID) {
        this.fSubUserID = fSubUserID;
    }

    public int getfMemTypeID() {
        return fMemTypeID;
    }

    public void setfMemTypeID(int fMemTypeID) {
        this.fMemTypeID = fMemTypeID;
    }

    public String getfMemCardNum() {
        return fMemCardNum;
    }

    public void setfMemCardNum(String fMemCardNum) {
        this.fMemCardNum = fMemCardNum;
    }

    public double getfBalance() {
        return fBalance;
    }

    public void setfBalance(double fBalance) {
        this.fBalance = fBalance;
    }

    public BigDecimal getfDiscount() {
        return fDiscount;
    }

    public void setfDiscount(BigDecimal fDiscount) {
        this.fDiscount = fDiscount;
    }

    public String getfCreateDate() {
        return fCreateDate;
    }

    public void setfCreateDate(String fCreateDate) {
        this.fCreateDate = fCreateDate;
    }

    public String getfUpdateDate() {
        return fUpdateDate;
    }

    public void setfUpdateDate(String fUpdateDate) {
        this.fUpdateDate = fUpdateDate;
    }
}
