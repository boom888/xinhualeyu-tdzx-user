package com.tdzx.user.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DzBusiStudentinfo implements Serializable {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "组织架构id")
    private String orgId;

    @ApiModelProperty(value = "所属单位树结构路径名")
    private String orgFullId;

    @ApiModelProperty(value = "学生姓名")
    private String studentname;

    @ApiModelProperty(value = "性别（1男   2女）")
    private String sex;

    @ApiModelProperty(value = "学号")
    private String xh;

    @ApiModelProperty(value = "是否贫困生")
    private String sfpks;

    @ApiModelProperty(value = "家长姓名")
    private String jzxm;

    @ApiModelProperty(value = "家长电话")
    private String jzmobile;

    @ApiModelProperty(value = "学校id")
    private String schoolid;

    @ApiModelProperty(value = "学校名称")
    private String schoolname;

    @ApiModelProperty(value = "年级id")
    private String gradeid;

    @ApiModelProperty(value = "年级")
    private String grade;

    @ApiModelProperty(value = "班级id")
    private String classid;

    @ApiModelProperty(value = "班级")
    private String classname;

    private String gsname;

    private String gscode;

    @ApiModelProperty(value = "是否手机创建")
    private Integer mobilecreate;

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

    @ApiModelProperty(value = "主账号ID")
    private Integer fAcctID;

    @ApiModelProperty(value = "wxId")
    private String wxId;

    @ApiModelProperty("主账号手机号")
    private String fMainMobile;

    private static final long serialVersionUID = 1L;
}