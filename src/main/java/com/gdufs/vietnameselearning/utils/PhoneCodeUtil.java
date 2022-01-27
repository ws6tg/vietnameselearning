package com.gdufs.vietnameselearning.utils;

import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.beans.factory.annotation.Value;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PhoneCodeUtil {

    static String apiUrl="https://sms_developer.zhenzikj.com";
    static String apiId="110781";
    static String appSecret="ZDc3MjVjMmMtYzBjNC00YzczLTg2OWItNDhhYzc4MjJiMmNk";
    static String templateId="8022";

    public static String genCode() {
        Random random=new Random();
        int num = random.nextInt(899999);
        int code = num + 100000;
        return String.valueOf(code);
    }

    public static String sendCode(String phonenumber,String code) throws Exception {
        ZhenziSmsClient client = new ZhenziSmsClient(apiUrl,apiId ,appSecret);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("number", phonenumber);
        params.put("templateId", templateId);
        String[] templateParams = new String[2];
        templateParams[0] = code;
        templateParams[1] = "5";
        params.put("templateParams", templateParams);
        return client.send(params);
    }

}