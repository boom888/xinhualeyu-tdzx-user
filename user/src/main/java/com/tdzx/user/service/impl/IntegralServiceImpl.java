package com.tdzx.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tdzx.user.dao.IntegralMapper;
import com.tdzx.user.dao.UserMapper;
import com.tdzx.user.domain.IntegralRule;
import com.tdzx.user.domain.TdzxMainUser;
import com.tdzx.user.domain.UserIntegral;
import com.tdzx.user.service.IntegralService;
import com.tdzx.user.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("integralService")
public class IntegralServiceImpl implements IntegralService {

    @Resource
    IntegralMapper integralMapper;

    @Resource
    UserMapper userMapper;

    @Override
    public int rabateOrAddIntegral(Integer fAcctID, String fDictCode,String fPrice) {
        int k = 0;
        TdzxMainUser mainUser = userMapper.findMainUserByID(fAcctID);
        if (mainUser!=null){
            IntegralRule integralRule = integralMapper.findIntegralRuleByCode(fDictCode);
            if (integralRule!=null){
                int surplusIntegral = mainUser.getfSurplusIntegral();   //扣减之前的积分
                int addType = integralRule.getfAddType();
                int integralValue = integralRule.getfIntegralValue();
                if (addType==1){    //固定积分
                    //更新主用户表
                    mainUser.setfSurplusIntegral(surplusIntegral+integralValue);
                    int m = userMapper.updateMainUser(mainUser);
                    System.err.println(m);
                    //生成积分流水
                    UserIntegral userIntegral = new UserIntegral();
                    userIntegral.setFAcctID(mainUser.getfInnerID());
                    userIntegral.setfCreateTime(System.currentTimeMillis()/1000+"");
                    userIntegral.setfDictCode(fDictCode);
                    userIntegral.setfCurrIntegral(surplusIntegral+integralValue);
                    userIntegral.setfSurplusIntegral(surplusIntegral);
                    k = integralMapper.insertUserIntegral(userIntegral);
                }

                if (addType==2){    //百分比
                    //更新主用户表
                    int award=Integer.parseInt(fPrice)*integralValue;
                    mainUser.setfSurplusIntegral(surplusIntegral+award);
                    userMapper.updateMainUser(mainUser);
                    //生成积分流水
                    UserIntegral userIntegral = new UserIntegral();
                    userIntegral.setFAcctID(mainUser.getfInnerID());
                    userIntegral.setfCreateTime(System.currentTimeMillis()/1000+"");
                    userIntegral.setfDictCode(fDictCode);
                    userIntegral.setfCurrIntegral(surplusIntegral+award);
                    userIntegral.setfSurplusIntegral(surplusIntegral);
                    k = integralMapper.insertUserIntegral(userIntegral);
                }
            }
        }
        return k;
    }

    @Override
    public CommonResult<PageTO<UserIntegral>> getIntegralDetail(String token,Integer pageNum,Integer pageSize) {
        CommonResult<PageTO<UserIntegral>> commonResult = new CommonResult<>();
        String privateKey = JedisUtils.get(token);
        if (privateKey==null || "".equals(privateKey)){
            commonResult.setCode(Constant.NUM_TWO);
            commonResult.setData(null);
            commonResult.setMessage(PromptMessage.TOKEN_PASS);
            return commonResult;
        }

        PageTO<UserIntegral> datapage = new PageTO<UserIntegral>(pageNum);
        Page page = PageHelper.startPage(pageNum, pageSize);
        List<UserIntegral> userIntegralList = new ArrayList<>();

        try {
            String fMainUserId = RSAUtil.decrypt(token, RSAUtil.getPrivateKey(privateKey));
            userIntegralList = integralMapper.findUserIntegralByAcctID(Integer.parseInt(fMainUserId));
            datapage.setList(userIntegralList);
            datapage.setPageNum(page.getPageNum());
            datapage.setPages(page.getPages());
            datapage.setPageSize(page.getPageSize());
            datapage.setTotal(page.getTotal());

            commonResult.setCode(Constant.NUM_ONE);
            commonResult.setData(datapage);
            commonResult.setMessage(PromptMessage.LOAD_SUCCESS);
            return commonResult;
        }catch (Exception e){
            e.printStackTrace();
        }
        commonResult.setCode(Constant.NUM_ZERO);
        commonResult.setData(null);
        commonResult.setMessage(PromptMessage.LOAD_FAIL);
        return commonResult;
    }
}
