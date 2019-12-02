package com.tdzx.user.service;

import com.tdzx.user.domain.UserIntegral;
import com.tdzx.user.utils.CommonResult;
import com.tdzx.user.utils.PageTO;

public interface IntegralService {

    int rabateOrAddIntegral(Integer fAcctID,String fDictCode,String fPrice);

    CommonResult<PageTO<UserIntegral>> getIntegralDetail(String token,Integer pageNum,Integer pageSize);
}
