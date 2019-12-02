package com.tdzx.user.controller;

import com.tdzx.user.domain.UserIntegral;
import com.tdzx.user.service.IntegralService;
import com.tdzx.user.utils.CommonResult;
import com.tdzx.user.utils.Constant;
import com.tdzx.user.utils.PageTO;
import com.tdzx.user.utils.PromptMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Api(value = "integral", description = "积分模块API")
@Controller
public class IntegralController extends BaseController {

    @Autowired
    private IntegralService integralService;


    @ApiOperation(value = "扣减用户积分")
    @RequestMapping(value = "rabateOrAddIntegral", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name="fAcctID",value = "主账号ID",required=true, paramType = "query"),
            @ApiImplicitParam(name="fDictCode",value = "字典码（扣减原因）",required=true, paramType = "query"),
            @ApiImplicitParam(name="fPrice",value = "下单价格",required=false, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Boolean> rabateOrAddIntegral(@RequestParam(required = true) Integer fAcctID, @RequestParam(required = true) String fDictCode,
                                                     @RequestParam(required = false) String fPrice){
        CommonResult<Boolean> commonResult = new CommonResult<>();
        int k = integralService.rabateOrAddIntegral(fAcctID,fDictCode,fPrice);
        if (k>0){
            commonResult.setCode(Constant.NUM_ONE);
            commonResult.setData(true);
            commonResult.setMessage(PromptMessage.OPERATE_SUCCESS);
        }else {
            commonResult.setCode(Constant.NUM_ZERO);
            commonResult.setData(false);
            commonResult.setMessage(PromptMessage.OPERATE_FAILD);
        }
        return commonResult;
    }


    @ApiOperation(value = "积分明细(带上token)")
    @RequestMapping(value = "getIntegralDetail", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "(分页)第几页", required = true, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "一页多少条", required = true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<PageTO<UserIntegral>> getIntegralDetail(@RequestParam(required = true)Integer pageNum,@RequestParam(required = true)Integer pageSize){
        CommonResult<PageTO<UserIntegral>> commonResult = new CommonResult<>();
        String token = getToken(request);
        commonResult = integralService.getIntegralDetail(token,pageNum,pageSize);
        return commonResult;
    }

}
