package com.tdzx.user.domain;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

@ApiModel("微信用户信息")
public class UserThirtyaccount implements Serializable {
    private int fInnerID;

    private String fopenid;

    private String funionid;

    private String icon;

    private String fname;

    public String getFunionid() {
        return funionid;
    }

    public void setFunionid(String funionid) {
        this.funionid = funionid;
    }

    public int getfInnerID() {
        return fInnerID;
    }

    public void setfInnerID(int fInnerID) {
        this.fInnerID = fInnerID;
    }

    public String getFopenid() {
        return fopenid;
    }

    public void setFopenid(String fopenid) {
        this.fopenid = fopenid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
