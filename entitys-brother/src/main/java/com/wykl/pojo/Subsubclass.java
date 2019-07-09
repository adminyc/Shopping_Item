package com.wykl.pojo;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * 商品三级分类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Subsubclass {
    //子子分类id
    private int ssid;
    //子子分类名字
    private String subsubname;
    //父级id
    private int papacategory;
}
