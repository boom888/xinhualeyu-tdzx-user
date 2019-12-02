package com.tdzx.user.dao;

import com.tdzx.user.domain.BusiSchoolxx;
import com.tdzx.user.domain.BusiSchoolxxExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BusiSchoolxxMapper {
    long countByExample(BusiSchoolxxExample example);

    int deleteByExample(BusiSchoolxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(BusiSchoolxx record);

    int insertSelective(BusiSchoolxx record);

    List<BusiSchoolxx> selectByExampleWithBLOBs(BusiSchoolxxExample example);

    List<BusiSchoolxx> selectByExample(BusiSchoolxxExample example);

    BusiSchoolxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BusiSchoolxx record, @Param("example") BusiSchoolxxExample example);

    int updateByExampleWithBLOBs(@Param("record") BusiSchoolxx record, @Param("example") BusiSchoolxxExample example);

    int updateByExample(@Param("record") BusiSchoolxx record, @Param("example") BusiSchoolxxExample example);

    int updateByPrimaryKeySelective(BusiSchoolxx record);

    int updateByPrimaryKeyWithBLOBs(BusiSchoolxx record);

    int updateByPrimaryKey(BusiSchoolxx record);

    List<BusiSchoolxx> selectByShengShiQu(@Param("province") String province, @Param("city") String city, @Param("area") String area,
                                          @Param("schoolName") String schoolName);
}