package com.imagegem.cloud.model.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 支付交易表
 * @TableName t_pay
 */
@TableName(value ="t_pay")
@Data
public class TPay implements Serializable {
    /**
     * 主键，序号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 支付流水号
     */
    @TableField("pay_no")
    private String payNo;

    /**
     * 订单流水号
     */
    @TableField("order_no")
    private String orderNo;

    /**
     * 用户账号ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 交易金额
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 删除标志，默认0不删除，1删除
     */
    @TableLogic
    @TableField("deleted")
    private Integer deleted;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}