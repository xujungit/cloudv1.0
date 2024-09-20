package com.atguigu.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author: xujun
 * @updateUser: xujun
 * @date: 2024/8/26
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayDTO implements Serializable {
    private Integer id;
    private String payNo;
    private String orderNo;
    private Integer userId;
    private BigDecimal amount;
}
