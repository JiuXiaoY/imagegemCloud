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
 * @TableName storage_tbl
 */
@TableName(value ="storage_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorageTbl implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 商品编码
     */
    private String commodityCode;

    /**
     * 总库存
     */
    private Integer count;

    /**
     * 已用库存
     */
    private Integer usedCount;

    /**
     * 剩余库存
     */
    private Integer residue;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}