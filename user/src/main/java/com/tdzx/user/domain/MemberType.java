package com.tdzx.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel("会员卡类型")
public class MemberType implements Serializable {
    private int fInnerID;
    @ApiModelProperty("系统类型(1:门店)")
    private String fBussType;
    @ApiModelProperty("跟O2O同步的唯一标识")
    private String fMemberNum;
    @ApiModelProperty("会员等级")
    private int fMemberLevel;
    @ApiModelProperty("会员名称")
    private String fMemberName;
    @ApiModelProperty("售价")
    private BigDecimal fSalesPrice;
    @ApiModelProperty("卡面额")
    private double fDenomination;
    @ApiModelProperty("会员折扣")
    private BigDecimal fDiscount;
    @ApiModelProperty("会员描述")
    private String fDecrip;
    @ApiModelProperty("创建时间")
    private String fCreateTime;
    @ApiModelProperty("有效期限（几个月）")
    private Integer fItem;
    @ApiModelProperty("会员图片")
    private String fPic;
    @ApiModelProperty("升级所需要的积分")
    private Integer fRequiredIntegral;

    public Integer getfRequiredIntegral() {
        return fRequiredIntegral;
    }

    public void setfRequiredIntegral(Integer fRequiredIntegral) {
        this.fRequiredIntegral = fRequiredIntegral;
    }

    public String getfMemberNum() {
        return fMemberNum;
    }

    public void setfMemberNum(String fMemberNum) {
        this.fMemberNum = fMemberNum;
    }

    public String getfPic() {
        return fPic;
    }

    public void setfPic(String fPic) {
        this.fPic = fPic;
    }

    public Integer getfItem() {
        return fItem;
    }

    public void setfItem(Integer fItem) {
        this.fItem = fItem;
    }

    public int getfInnerID() {
        return fInnerID;
    }

    public void setfInnerID(int fInnerID) {
        this.fInnerID = fInnerID;
    }

    public String getfBussType() {
        return fBussType;
    }

    public void setfBussType(String fBussType) {
        this.fBussType = fBussType;
    }

    public String getfMemberName() {
        return fMemberName;
    }

    public void setfMemberName(String fMemberName) {
        this.fMemberName = fMemberName;
    }

    public int getfMemberLevel() {
        return fMemberLevel;
    }

    public void setfMemberLevel(int fMemberLevel) {
        this.fMemberLevel = fMemberLevel;
    }

    public BigDecimal getfSalesPrice() {
        return fSalesPrice;
    }

    public void setfSalesPrice(BigDecimal fSalesPrice) {
        this.fSalesPrice = fSalesPrice;
    }

    public double getfDenomination() {
        return fDenomination;
    }

    public void setfDenomination(double fDenomination) {
        this.fDenomination = fDenomination;
    }

    public BigDecimal getfDiscount() {
        return fDiscount;
    }

    public void setfDiscount(BigDecimal fDiscount) {
        this.fDiscount = fDiscount;
    }

    public String getfDecrip() {
        return fDecrip;
    }

    public void setfDecrip(String fDecrip) {
        this.fDecrip = fDecrip;
    }

    public String getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(String fCreateTime) {
        this.fCreateTime = fCreateTime;
    }
}
