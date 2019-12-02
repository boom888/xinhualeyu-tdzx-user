package com.tdzx.user.dao;

import com.tdzx.user.domain.IntegralRule;
import com.tdzx.user.domain.UserIntegral;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IntegralMapper {
    IntegralRule findIntegralRuleByCode(String fDictCode);

    int insertUserIntegral(UserIntegral userIntegral);

    List<UserIntegral> findUserIntegralByAcctID(Integer fAcctID);
}
