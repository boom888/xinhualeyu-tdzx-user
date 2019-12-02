package com.tdzx.user.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class BusiSchooljg implements Serializable {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;

    private String parents;

    @ApiModelProperty(value = "年级编号")
    private String parentId;

    private String sorts;

    @ApiModelProperty(value = "类型（1 年级  2班级）")
    private Integer levels;

    private String schoolId;

    @ApiModelProperty(value = "年级id(对应pub_excel_properties的id)")
    private Integer gradeId;

    private String grade;

    private String gsname;

    private String gscode;

    @ApiModelProperty(value = "学校自编码")
    private String zbm;

    @ApiModelProperty(value = "是否允许家长增加学生")
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

    @ApiModelProperty(value = "文理科")
    private String wenlike;

    @ApiModelProperty(value = "是否开启统计（0不统计，1统计）")
    private Integer openStatistics;

    @ApiModelProperty(value = "班级列表")
    private List<BusiSchooljg> classList;

    private static final long serialVersionUID = 1L;
}