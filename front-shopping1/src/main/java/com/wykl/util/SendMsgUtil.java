package com.wykl.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.util.HashMap;
import java.util.Map;

public class SendMsgUtil {



    public static void main(String[] args) {
        for (int i = 0;i<20;i++){
            String code= ((Math.random()*9+1)*100000)+"";
            System.out.println(code);
        }
        /*DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI7U05Um6L2czx", "rQUa78stZYtRd2wW52HbQglOJ4hE6K");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "13142117090");
        request.putQueryParameter("SignName", "往忆考拉");
        request.putQueryParameter("TemplateCode", "SMS_171119074");
        request.putQueryParameter("TemplateParam", "{\"code\":"+code+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }*/


    }
}
