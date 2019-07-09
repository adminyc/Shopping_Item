package com.wykl.pojo;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * 支付类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Paycategory {
    //支付类型ID
    private int payid;
    //支付类型
    private String paycategory;

}
