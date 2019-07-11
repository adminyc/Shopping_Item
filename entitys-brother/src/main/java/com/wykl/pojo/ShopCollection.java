package com.wykl.pojo;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * 商品收藏类    中间表     Collection数据库中的表，由于冲突问题更名为ShopCollection
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class ShopCollection {
    //收藏表id
    private int cid;
    //用户id
    private int uid;
    //商品id
    private int gid;
}
