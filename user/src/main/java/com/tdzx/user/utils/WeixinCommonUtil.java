package com.tdzx.user.utils;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

@Slf4j
public class WeixinCommonUtil {
	/**
	 * 小程序获取openid等相关参数
	 * @param appId
	 * @param appSecret
	 * @param code
	 * @return
	 */
	public static JSONObject getAuthByCode(String appId, String appSecret, String code)throws Exception {
		log.info("appId = "+ appId + "appSecret = " + appSecret + "code = " + code);
		String url = "https://api.weixin.qq.com/sns/jscode2session";
		/*Map<String,String> map = new HashMap<>();
		map.put("appid",appId);
		map.put("secret", appSecret);
		map.put("js_code", code);
		map.put("grant_type", "authorization_code");*/
		JSONObject body = HttpUtils.doGetMethod(url, "appid="+appId+"&secret="+appSecret+"&js_code="+code+"&grant_type=authorization_code");
		log.info("return data  body = " + body);
		return body;
	}
	
}
