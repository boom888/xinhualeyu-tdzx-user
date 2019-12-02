package com.tdzx.user.controller;

import com.tdzx.user.utils.IPAddressUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;

    protected int getPage(){
        String p = request.getParameter("page");
        return p==null ? 1 : Integer.parseInt(p);
    }
    protected int getLimit(){
        String l = request.getParameter("limit");
        return l==null ? 10 : Integer.parseInt(l);
    }
    
    protected HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttrs = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        HttpServletRequest request = requestAttrs.getRequest();
        return request;
    }
    
    protected String getIp() {
        return IPAddressUtils.getIpAddress(getRequest());
    }

    public String getToken(HttpServletRequest request){
        String token = request.getHeader("token");
        return token;
    }

}
