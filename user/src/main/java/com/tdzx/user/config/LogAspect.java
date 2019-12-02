package com.tdzx.user.config;

import com.alibaba.fastjson.JSON;
import com.tdzx.user.utils.IPAddressUtils;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


/**
 *
 *
 * @Author jt_L
 * @Date 2017-12-27
 * @Description aop日志类
 */
@Aspect
@Component
public class LogAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private final static String LOG_METHOD = "log()";

    ThreadLocal<Long> startTime = new ThreadLocal<>();
    ThreadLocal<Long> endTime = new ThreadLocal<>();

    @Pointcut("@annotation(io.swagger.annotations.ApiOperation)")
    public void log(){

    }

    @Around(LOG_METHOD)
    public Object loggingAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();//获取attribute
        HttpServletRequest req = attributes.getRequest();

        log.info("请求的URL:{}",req.getRequestURL());
        log.info("请求的IP:{}", IPAddressUtils.getIpAddress(req));
        String method = joinPoint.getSignature().getName();
        log.info("请求的方式:{}",method);
        log.info("被执行的类:{}",joinPoint.getSignature().getDeclaringTypeName());
        log.info("被执行的方法名:{}",joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (null != arg){
                Class<?> T = arg.getClass();
                Package aPackage = T.getPackage();
                if (null != arg && aPackage.getName().contains("com.szys")){
                    try {
                        log.info("\n方法的参数类型:{}\n参数值:\n{}",T.getTypeName(),JSON.toJSONString(arg));
                    } catch (Exception e) {
                    }
                }
            }
        }
        Class joinPointClass = joinPoint.getSignature().getDeclaringType();
        Method[] methods = joinPointClass.getMethods();
        for (Method m : methods){
            if (m.getName().equals(method)){
                ApiOperation apiOperation = m.getAnnotation(ApiOperation.class);
                if (null != apiOperation){
                    log.info("被执行方法的功能:{}",apiOperation.value());
                }
                break;
            }
        }
        log.info("!!!!!!方法正在开始执行中!!!!!!");
        startTime.set(System.currentTimeMillis());
        //执行方法
        Object result = joinPoint.proceed();

        endTime.set(System.currentTimeMillis());
        log.info("!!!!!!方法正常执行结束!!!!!!");
        log.info("当前执行方法所耗费的时间:{}毫秒",(endTime.get()-startTime.get()));
        /*if (result instanceof ResultVo)
             log.info("执行方法之后的返回JSON数据:{}",JSON.toJSONString(result));*/

        return result;
    }

}
