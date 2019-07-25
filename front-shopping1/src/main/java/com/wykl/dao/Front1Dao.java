package com.wykl.dao;

import com.wykl.pojo.Couponpull;
import com.wykl.pojo.Users;

public interface Front1Dao {
    //登录
    public Users loginkl(Users users);
    //登录ajax验证用户名是否已经被注册
    public int findByUserName(String username);
    //用户的注册
    public int insertUser(Users users);
    //判断该手机号是否已经注册
    public int selectByPhone(String mobilephoneno);
    //判断优惠券是否有被领取
    public int judgeCoupon(Couponpull cp);
    //进行优惠券的领取
    public int addCouponpull(Couponpull cp);
}
