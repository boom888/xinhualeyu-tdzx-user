package com.tdzx.user.dao;

import com.tdzx.user.domain.BusiStudentinfo;
import com.tdzx.user.domain.DzBusiStudentinfo;
import com.tdzx.user.domain.DzBusiStudentinfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DzBusiStudentinfoMapper {
    long countByExample(DzBusiStudentinfoExample example);

    int deleteByExample(DzBusiStudentinfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(DzBusiStudentinfo record);

    int insertSelective(DzBusiStudentinfo record);

    List<DzBusiStudentinfo> selectByExample(DzBusiStudentinfoExample example);

    DzBusiStudentinfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DzBusiStudentinfo record, @Param("example") DzBusiStudentinfoExample example);

    int updateByExample(@Param("record") DzBusiStudentinfo record, @Param("example") DzBusiStudentinfoExample example);

    int updateByPrimaryKeySelective(DzBusiStudentinfo record);

    int updateByPrimaryKey(DzBusiStudentinfo record);

    DzBusiStudentinfo findDzStudentByAcctID(@Param("fAcctID") Integer fAcctID);

    List<DzBusiStudentinfo> getBussTypeCompanyList(@Param("studentname") String studentname);
}