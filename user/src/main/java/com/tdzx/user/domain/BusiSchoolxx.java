package com.tdzx.user.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class BusiSchoolxx implements Serializable {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "学校名称")
    private String schoolmc;

    @ApiModelProperty(value = "联系电话")
    private String mobile;

    @ApiModelProperty(value = "联系人")
    private String lxr;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "学校代码")
    private String xxdm;

    @ApiModelProperty(value = "折扣信息")
    private Double zkxx;

    @ApiModelProperty(value = "付款方式")
    private String fkfs;

    @ApiModelProperty(value = "付款方式id")
    private String fkfsid;

    @ApiModelProperty(value = "省")
    private String sheng;

    @ApiModelProperty(value = "省id")
    private String shengid;

    @ApiModelProperty(value = "市")
    private String shi;

    @ApiModelProperty(value = "市id")
    private String shid;

    @ApiModelProperty(value = "区")
    private String qu;

    @ApiModelProperty(value = "区id")
    private String quid;

    @ApiModelProperty(value = "学校自编码")
    private String zbm;

    @ApiModelProperty(value = "店号")
    private String dh;

    @ApiModelProperty(value = "子公司名称")
    private String gsname;

    @ApiModelProperty(value = "子公司id")
    private String gscode;

    @ApiModelProperty(value = "登录账号")
    private String dlzh;

    @ApiModelProperty(value = "登录密码")
    private String dlmm;

    @ApiModelProperty(value = "sap号码")
    private String sap;

    private Integer mobileadd;

    @ApiModelProperty(value = "创建人id")
    private Integer creuserid;

    @ApiModelProperty(value = "创建人name")
    private String creusername;

    @ApiModelProperty(value = "创建时间")
    private Date cretime;

    @ApiModelProperty(value = "创建人部门id")
    private Integer creuserdepid;

    @ApiModelProperty(value = "创建人部门名称")
    private String creuserdepname;

    @ApiModelProperty(value = "最后修改人id")
    private Integer modifyuserid;

    @ApiModelProperty(value = "最后修改人Name")
    private String modifyusername;

    @ApiModelProperty(value = "最后修改时间")
    private Date modifytime;

    @ApiModelProperty(value = "修改人部门Id")
    private Integer modifyuserdepid;

    @ApiModelProperty(value = "最后修改人部门名称")
    private String modifyuserdepname;

    @ApiModelProperty(value = "是否可用（0不可以，1可用）")
    private Integer enabled;

    @ApiModelProperty(value = "学校介绍")
    private String xxjs;

    @ApiModelProperty(value = "年级列表")
    private List<BusiSchooljg> gradeList;

    private static final long serialVersionUID = 1L;
}