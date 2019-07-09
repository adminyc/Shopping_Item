package com.wykl.pojo;

import java.util.Date;

public class Users {
    //用户id
    private int userid;
    //用户名
    private String username;
    //登录名
    private String loginname;
    //密码
    private String password;
    //证件类型
    private String documenttype;
    //证件号码
    private String idnumber;
    //手机号
    private String mobilephoneno;
    //邮箱
    private String email;
    //性别
    private String gender;
    //邮编
    private int zipcode;
    //省
    private int province;
    //市/区
    private int thecity;
    //地址
    private String address;
    //积分
    private int integeral;
    //注册时间  (数据库中默认为当前时间)
    private Date registrationtime;
    //生日
    private Date birthday;
    //用户状态
    private int userstate;
    //会员级别
    private int membershipgrade;
    //零钱    (数据库中从0开始)
    private double money;
    //是否是商家
    private int ismerchants;
    //是否是网站管理员
    private int isadmin;
    //密保问题
    private String encrypted;
    //密保答案
    private String encryptedanswer;

}
