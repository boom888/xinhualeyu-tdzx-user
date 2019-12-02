package com.tdzx.user.dao;

import com.tdzx.user.domain.BusiSchooljg;
import com.tdzx.user.domain.DzBusiSchooljg;
import com.tdzx.user.domain.DzBusiSchooljgExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DzBusiSchooljgMapper {
    long countByExample(DzBusiSchooljgExample example);

    int deleteByExample(DzBusiSchooljgExample example);

    int deleteByPrimaryKey(String id);

    int insert(DzBusiSchooljg record);

    int insertSelective(DzBusiSchooljg record);

    List<DzBusiSchooljg> selectByExample(DzBusiSchooljgExample example);

    DzBusiSchooljg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DzBusiSchooljg record, @Param("example") DzBusiSchooljgExample example);

    int updateByExample(@Param("record") DzBusiSchooljg record, @Param("example") DzBusiSchooljgExample example);

    int updateByPrimaryKeySelective(DzBusiSchooljg record);

    int updateByPrimaryKey(DzBusiSchooljg record);

    List<DzBusiSchooljg> selectByCompanyID(@Param("schoolId") String schoolId, @Param("gradeId") Integer gradeId, @Param("levels") Integer levels);

}