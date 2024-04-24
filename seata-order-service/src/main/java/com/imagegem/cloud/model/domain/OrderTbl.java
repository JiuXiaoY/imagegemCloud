package com.imagegem.cloud.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName order_tbl
 */
@TableName(value ="order_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderTbl implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 商品编码
     */
    private String commodityCode;

    /**
     * 库存
     */
    private Integer count;

    /**
     * 金额
     */
    private Integer money;

    /**
     * 订单状态，0表示创建中，1表示已完成
     */
    private Integer status;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}