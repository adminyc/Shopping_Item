package com.wykl.pojo;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * 商品一级分类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Subclass {
    //子分类id
    private int sid;
    //子分类名字
    private String subcategoryname;
    //父分类id
    private int parentcategory;
}
