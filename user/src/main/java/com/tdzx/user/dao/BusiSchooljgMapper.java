package com.tdzx.user.dao;

import com.tdzx.user.domain.BusiSchooljg;
import com.tdzx.user.domain.BusiSchooljgExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BusiSchooljgMapper {
    long countByExample(BusiSchooljgExample example);

    int deleteByExample(BusiSchooljgExample example);

    int deleteByPrimaryKey(String id);

    int insert(BusiSchooljg record);

    int insertSelective(BusiSchooljg record);

    List<BusiSchooljg> selectByExample(BusiSchooljgExample example);

    BusiSchooljg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BusiSchooljg record, @Param("example") BusiSchooljgExample example);

    int updateByExample(@Param("record") BusiSchooljg record, @Param("example") BusiSchooljgExample example);

    int updateByPrimaryKeySelective(BusiSchooljg record);

    int updateByPrimaryKey(BusiSchooljg record);

    List<BusiSchooljg> selectBySchoolID(@Param("schoolId") String schoolId,@Param("gradeId") Integer gradeId,@Param("levels") Integer levels);
}