package com.tdzx.user.utils;

public class URLUtils {
    //微信APPID
    public static final String APPID ="wx7eda9d628865af4c";
    //微信APPSECRET
    public static final String APPSECRET = "d337c72ffbec9b70fb8e94c82410ba25";
    //微信小程序APPID
    public static final String XCX_APPID ="wx74d9851805156eee";
    //微信小程序APPSECRET
    public static final String XCX_APPSECRET = "ae78d78eea18aa0230994d54dec93b6f";
    //线上
    //public static final String STOREURL = "http://127.0.0.1:8085";
    //本地
    public static final String STOREURL = "http://127.0.0.1:8002";
    //门店会员相关的URL
    public static final String MMEMBER_URL = "http://ip:port/servicename/interfacename";
    //微信获取access_token的URL
    public static final String ACCESS_TOKEN_BASE_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
    //微信校验access_token是否有效的URL
    public static final String CHECKOUT_ACCESS_TOKEN_OPENID_URL = "https://api.weixin.qq.com/sns/auth";
    //微信通过refresh_token续时access_token的URL
    public static final String REFRESH_TOKEN_OPENID_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
    //Sap
    public static final String SAP_URL = "http://10.100.30.32/hyservice/handler.ashx";
    //悦订网--登陆
    public static final String YUEDING_LOGIN_URL = "https://xcx.gdreading.com/login/login";
    //悦订网--获取用户信息
    public static final String YUEDING_GETINFO_URL = "https://xcx.gdreading.com/user/get_user_info";
}
