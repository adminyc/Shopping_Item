package com.wykl.pojo;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * 商品状态实体类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Goodsstate {
    //商品状态ID
    private int gid;
    //商品状态
    private String gstate;
}
