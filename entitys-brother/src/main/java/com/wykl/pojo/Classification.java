package com.wykl.pojo;

import lombok.*;
import lombok.experimental.Accessors;

/**
 *  一级分类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Classification {
    //分类ID
    private int cid;
    //分类名字
    private String Categoryname;
}
