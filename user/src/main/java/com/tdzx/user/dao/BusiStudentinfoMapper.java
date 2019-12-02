package com.tdzx.user.dao;

import com.tdzx.user.domain.BusiStudentinfo;
import com.tdzx.user.domain.BusiStudentinfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BusiStudentinfoMapper {
    long countByExample(BusiStudentinfoExample example);

    int deleteByExample(BusiStudentinfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(BusiStudentinfo record);

    int insertSelective(BusiStudentinfo record);

    List<BusiStudentinfo> selectByExample(BusiStudentinfoExample example);

    BusiStudentinfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BusiStudentinfo record, @Param("example") BusiStudentinfoExample example);

    int updateByExample(@Param("record") BusiStudentinfo record, @Param("example") BusiStudentinfoExample example);

    int updateByPrimaryKeySelective(BusiStudentinfo record);

    int updateByPrimaryKey(BusiStudentinfo record);

    List<BusiStudentinfo> findStudentByVXID(String vxId);

    BusiStudentinfo findStudentByAcctID(Integer fAcctID);

    List<BusiStudentinfo> findStudentListByAcctID(Integer fAcctID);

    List<BusiStudentinfo> findStudentByBussType(@Param("studentname")String studentname);
}