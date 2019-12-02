package com.tdzx.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("积分规则")
public class IntegralRule implements Serializable {

    private int fInnerID;
    @ApiModelProperty("字典码")
    private String fDictCode;
    @ApiModelProperty("分值")
    private int fIntegralValue;
    @ApiModelProperty("启用状态(1:启用 0：禁用)")
    private int fStatus;
    @ApiModelProperty("1:固定值  | 2:百分比")
    private int fAddType;

    public int getfInnerID() {
        return fInnerID;
    }

    public void setfInnerID(int fInnerID) {
        this.fInnerID = fInnerID;
    }

    public String getfDictCode() {
        return fDictCode;
    }

    public void setfDictCode(String fDictCode) {
        this.fDictCode = fDictCode;
    }

    public int getfIntegralValue() {
        return fIntegralValue;
    }

    public void setfIntegralValue(int fIntegralValue) {
        this.fIntegralValue = fIntegralValue;
    }

    public int getfStatus() {
        return fStatus;
    }

    public void setfStatus(int fStatus) {
        this.fStatus = fStatus;
    }

    public int getfAddType() {
        return fAddType;
    }

    public void setfAddType(int fAddType) {
        this.fAddType = fAddType;
    }
}
