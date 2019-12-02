package com.tdzx.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel("门店")
public class AppStore   implements Serializable {
    @ApiModelProperty("店铺id")
    private int id;
    @ApiModelProperty("店铺名称")
    private String storeName ;
    @ApiModelProperty("会员卡类型")
    private List<MemberType> memberTypeList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<MemberType> getMemberTypeList() {
        return memberTypeList;
    }

    public void setMemberTypeList(List<MemberType> memberTypeList) {
        this.memberTypeList = memberTypeList;
    }
}
