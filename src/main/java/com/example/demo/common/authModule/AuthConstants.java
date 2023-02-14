package com.example.demo.common.authModule;

public class AuthConstants {
    public static final String SIGNING_KEY = "secretKey";
    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 1000*60000;
    public static final String  ERR_DESC_AR=" الجلسة انتهت يرجى معاودة الدخول مرة اخرى و التاكد من استخدام اخر نسخة من التطبيق ";
    public static final String ERR_DESC_LA ="Session Time Out ... please login again and make sure you are using Last App Version  ";
    public static final String ERR_DESC_NOT_AUTH ="-401";
    public static final long  ERR_DESC_NOT_AUTH_NUM =-401;
}
