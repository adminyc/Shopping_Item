package com.wykl.pojo;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * 市区实体类
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Thecititable {
    //市id
    private int tid;
    //市区名称
    private String tname;
    //省id外键
    private int tpid;

}
