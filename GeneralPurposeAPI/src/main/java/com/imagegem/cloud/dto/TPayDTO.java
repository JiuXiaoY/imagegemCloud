package com.imagegem.cloud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TPayDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -4583900182886704565L;
    /**
     * 主键，序号
     */
    private Integer id;

    /**
     * 支付流水号
     */
    private String payNo;

    /**
     * 订单流水号
     */
    private String orderNo;

    /**
     * 用户账号ID
     */
    private Integer userId;

    /**
     * 交易金额
     */
    private BigDecimal amount;
}
