package com.wykl.pojo;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * 商品实体类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Goods {
    //商品id
    private int gid;
    //父级分类ID
    private int parentcategory;
    //子分类ID
    private int gclassification;
    //商品名字
    private String gname;
    //商品副标题
    private String gsubtitle;
    //产品主图
    private String imageurl;
    //产品附图
    private String subimage;
    //商品价格
    private double prices;
    //商品状态
    private int goodsstate;
}
