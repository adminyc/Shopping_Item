package com.wykl.pojo;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * 省实体类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Provincetable {
    //省ID
    private int pid;
    //省名称
    private String pname;
}
