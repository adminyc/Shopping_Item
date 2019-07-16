package com.wykl.util;

import java.util.HashMap;
import java.util.Map;

public class SendMsgUtil {
    /**
     * 发送短信消息
     */
    /*@SuppressWarnings("deprecation")
    public static String sendMsg(String phones,String content){
    //短信接口URL提交地址utf-8
        String url = "http://utf8.sms.webchinese.cn";

        Map<String, String> params = new HashMap<String, String>();
        //用户名，例：abc123456
        params.put("Uid", "yu3961520");
        //短信接口密钥 ,不是密码，例：79c3053154d313a34567
        params.put("Key", "d41d8cd98f00b204e980");

        //手机号码，多个号码使用英文逗号进行分割

        params.put("smsMob", phones);
        //将短信内容进行URLEncoder编码
        params.put("smsText", URLEncoder.encode(content));

        return HttpRequestUtil.getRequest(url, params);
    }

    *//**
     * 随机生成6位随机验证码
     *//*
    public static String createRandomVcode(){
        //验证码
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }

    *//**
     * 测试
     *//*
    public static void main(String[] args) {
    //多个手机号请用半角,隔开
        //例：System.out.println(sendMsg("18912345678,17812345678", "尊敬的用户，您的验证码为" + SendMsgUtil.createRandomVcode() + "，有效期为60秒，如有疑虑请详询400-3023-4493（客服电话）【中国联通】"));
        System.out.println(sendMsg("电话号码", "*****，你的验证码为" + SendMsgUtil.createRandomVcode() + "，有效期为60秒，如有疑虑请详询（******）【签名，这是验证格式的必须填】"));
    }*/
}
