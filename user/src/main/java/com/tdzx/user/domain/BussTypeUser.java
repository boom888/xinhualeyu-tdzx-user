package com.tdzx.user.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BussTypeUser implements Serializable {
    @ApiModelProperty("电商用户")
    private List<UserStore> dianShangUserList;
    @ApiModelProperty("悦订网用户")
    private List<UserStore> yueDingUserList;
    @ApiModelProperty("教材教辅用户")
    private List<BusiStudentinfo> jfUserList;
    @ApiModelProperty("党政读物用户")
    private List<DzBusiStudentinfo> dzUserList;
}
