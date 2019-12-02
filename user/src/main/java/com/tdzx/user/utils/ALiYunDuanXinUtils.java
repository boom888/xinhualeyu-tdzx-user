package com.tdzx.user.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/*import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;*/
import javax.xml.ws.http.HTTPException;
import java.io.IOException;

public class ALiYunDuanXinUtils {

    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    static final String accessKeyId = "LTAI3ZvJNVGNczz7";
    public static final String TEMPLATE_CODE_APP = "SMS_166776372";
    public static final String TEMPLATE_CODE_MATERIAL = "SMS_168820204";
    static final String accessKeySecret = "B0pWT3VVCf1YOqANc3wxpxFOWrBMRy";


    public static String SendSms(String phoneNumber, String verificationCode, String templateCode) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phoneNumber);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("新华乐育");
        //必填:短信模板-可在短信控制台中找到
//        request.setTemplateCode("SMS_156471875");
//        request.setTemplateCode("SMS_166740058");
        request.setTemplateCode(templateCode);
        request.setTemplateParam("{\"code\":\""+verificationCode+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        return sendSmsResponse.getCode();

    }


    public static String SendMonitorSms(String phoneNumber, String verificationCode, String templateCode) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phoneNumber);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("新华乐育");
        //必填:短信模板-可在短信控制台中找到
//        request.setTemplateCode("SMS_156471875");
//        request.setTemplateCode("SMS_166740058");
        request.setTemplateCode(templateCode);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //request.setTemplateParam("{\"code\":\" 123\"}");
        request.setTemplateParam("{\"serviceName\":\""+verificationCode+"\"}");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        System.out.println("Code=" + sendSmsResponse.getCode());
/*        //发短信
        SendSmsResponse response = sendSms();
        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + response.getCode());
        System.out.println("Message=" + response.getMessage());
        System.out.println("RequestId=" + response.getRequestId());
        System.out.println("BizId=" + response.getBizId());*/
        return sendSmsResponse.getCode();

    }


    /*public static void TXSms(){
        try {
            String[] params = {"5678"};
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
                    templateId, params, smsSign, "", "");
            System.out.println(result);
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
        }
    }*/


    public static void main(String[] args) throws Exception{
    }
}
