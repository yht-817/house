package com.ruoyi.project.tool.sms;


import cn.hutool.setting.dialect.Props;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.ruoyi.project.tool.redis.RedisTool;

/**
 * 阿里云短信发送接口
 */
public class AliSmsTool {

    static final String domain = "dysmsapi.aliyuncs.com";
    static final String product = "Dysmsapi";

    /**
     * 发送
     */
    public static String sendMsg(String phoneNo, String phoneCode) throws Exception {
        Props pro = new Props("ali-sms.properties");
        String id = pro.getProperty("access.key.id");
        String sign = pro.getProperty("access.key.sign");
        String secret = pro.getProperty("access.key.secret");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", id, secret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(sign);
        //必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
        // 判断是中国号码还是外国号码
        if (phoneCode.equals("86")) {
            System.out.println("----------中国----------");
            // 中国
            request.setTemplateCode("SMS_136387226");
            //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
            request.setPhoneNumbers(phoneNo);

        } else {
            System.out.println("----------国外----------");
            request.setTemplateCode("SMS_136387226");
            request.setPhoneNumbers(phoneCode + phoneNo);
        }
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        String code = String.valueOf((int) ((Math.random() * 9 + 1) * 1000));
        JSON json = new JSONObject();
        ((JSONObject) json).put("code", code);
        request.setTemplateParam(json.toString());
        //请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            // 然后把验证码放入redis
            RedisTool.setCode(phoneNo, code);
            //请求成功
            System.out.println("发送成功");
            return code;
        } else {
            System.out.println("发送失败");
            return null;
        }
    }
}
