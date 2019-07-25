package com.wykl.service;

import com.wykl.pojo.Couponpull;
import com.wykl.pojo.Users;

public interface Front1Service {
    //登录
    public Users wykl_login(Users users);
    //登录ajax验证用户名是否已经被注册
    public int veruname(String username);
    //用户的注册
    public int addUser(Users users);
    //判断该手机号是否已经注册
    public int findByPhone(String mobilephoneno);
    //判断用户是否已经领取优惠券
    public int findByCoupon(Couponpull cp);
    //进行优惠券的领取
    public int couponPulling(Couponpull cp);
}
