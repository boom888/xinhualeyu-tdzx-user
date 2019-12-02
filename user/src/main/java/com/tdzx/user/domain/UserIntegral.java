package com.tdzx.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("用户积分明细")
public class UserIntegral implements Serializable {
    private int fInnerID;
    @ApiModelProperty("主账号ID")
    private int FAcctID;
    @ApiModelProperty("扣减之后的积分")
    private int fCurrIntegral;
    @ApiModelProperty("扣减之前的积分")
    private int fSurplusIntegral;
    @ApiModelProperty("字典码（积分来源）")
    private String fDictCode;
    @ApiModelProperty("创建时间")
    private String fCreateTime;

    public int getfInnerID() {
        return fInnerID;
    }

    public void setfInnerID(int fInnerID) {
        this.fInnerID = fInnerID;
    }

    public int getFAcctID() {
        return FAcctID;
    }

    public void setFAcctID(int FAcctID) {
        this.FAcctID = FAcctID;
    }

    public int getfCurrIntegral() {
        return fCurrIntegral;
    }

    public void setfCurrIntegral(int fCurrIntegral) {
        this.fCurrIntegral = fCurrIntegral;
    }

    public int getfSurplusIntegral() {
        return fSurplusIntegral;
    }

    public void setfSurplusIntegral(int fSurplusIntegral) {
        this.fSurplusIntegral = fSurplusIntegral;
    }

    public String getfDictCode() {
        return fDictCode;
    }

    public void setfDictCode(String fDictCode) {
        this.fDictCode = fDictCode;
    }

    public String getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(String fCreateTime) {
        this.fCreateTime = fCreateTime;
    }
}
