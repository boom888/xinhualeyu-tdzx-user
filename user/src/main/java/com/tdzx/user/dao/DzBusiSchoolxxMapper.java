package com.tdzx.user.dao;

import com.tdzx.user.domain.DzBusiSchoolxx;
import com.tdzx.user.domain.DzBusiSchoolxxExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DzBusiSchoolxxMapper {
    long countByExample(DzBusiSchoolxxExample example);

    int deleteByExample(DzBusiSchoolxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(DzBusiSchoolxx record);

    int insertSelective(DzBusiSchoolxx record);

    List<DzBusiSchoolxx> selectByExampleWithBLOBs(DzBusiSchoolxxExample example);

    List<DzBusiSchoolxx> selectByExample(DzBusiSchoolxxExample example);

    DzBusiSchoolxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DzBusiSchoolxx record, @Param("example") DzBusiSchoolxxExample example);

    int updateByExampleWithBLOBs(@Param("record") DzBusiSchoolxx record, @Param("example") DzBusiSchoolxxExample example);

    int updateByExample(@Param("record") DzBusiSchoolxx record, @Param("example") DzBusiSchoolxxExample example);

    int updateByPrimaryKeySelective(DzBusiSchoolxx record);

    int updateByPrimaryKeyWithBLOBs(DzBusiSchoolxx record);

    int updateByPrimaryKey(DzBusiSchoolxx record);

    List<DzBusiSchoolxx> selectByShengShiQu(@Param("province") String province, @Param("city") String city, @Param("area") String area,
                                            @Param("companyName") String companyName);
}