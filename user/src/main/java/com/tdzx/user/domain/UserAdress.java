package com.tdzx.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("用户收货地址")
public class UserAdress implements Serializable {
    private int fInnerID;
    @ApiModelProperty("主账号ID")
    private int fAcctID;
    @ApiModelProperty("地址类型（1：家庭  2：公司  3：其他）")
    private int fAdressType;
    @ApiModelProperty("省")
    private String fProvince;
    @ApiModelProperty("市")
    private String fCity;
    @ApiModelProperty("区")
    private String fArea;
    @ApiModelProperty("详细地址")
    private String fDetailAdress;
    @ApiModelProperty("收货人姓名")
    private String fReceiveName;
    @ApiModelProperty("收货人手机号")
    private String fReceiveTel;
    @ApiModelProperty("状态(1：启用  0：禁用)")
    private int fStatue;
    @ApiModelProperty("创建时间")
    private String fCreateTime;
    @ApiModelProperty("是否设为默认地址(1:是  0：不是)")
    private int fIsDefaultAdress;

    public int getfIsDefaultAdress() {
        return fIsDefaultAdress;
    }

    public void setfIsDefaultAdress(int fIsDefaultAdress) {
        this.fIsDefaultAdress = fIsDefaultAdress;
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

    public int getfAdressType() {
        return fAdressType;
    }

    public void setfAdressType(int fAdressType) {
        this.fAdressType = fAdressType;
    }

    public String getfProvince() {
        return fProvince;
    }

    public void setfProvince(String fProvince) {
        this.fProvince = fProvince;
    }

    public String getfCity() {
        return fCity;
    }

    public void setfCity(String fCity) {
        this.fCity = fCity;
    }

    public String getfArea() {
        return fArea;
    }

    public void setfArea(String fArea) {
        this.fArea = fArea;
    }

    public String getfDetailAdress() {
        return fDetailAdress;
    }

    public void setfDetailAdress(String fDetailAdress) {
        this.fDetailAdress = fDetailAdress;
    }

    public String getfReceiveName() {
        return fReceiveName;
    }

    public void setfReceiveName(String fReceiveName) {
        this.fReceiveName = fReceiveName;
    }

    public String getfReceiveTel() {
        return fReceiveTel;
    }

    public void setfReceiveTel(String fReceiveTel) {
        this.fReceiveTel = fReceiveTel;
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
