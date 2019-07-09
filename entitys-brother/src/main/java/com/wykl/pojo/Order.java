package com.wykl.pojo;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * 订单实体类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Order {
    //订单ID
    private int oid;
    //订单号
    private String orderno;
    //商品编号
    private String productid;
    //商品单价
    private double commodityprice;
    //商品数量
    private int number;
    //商品状态
    private int goodsstate;
    //总价
    private double totalprice;
    //支付方式
    private int pay;
    //省
    private int province;
    //市
    private int thecity;
    //详细地址
    private String address;

}
