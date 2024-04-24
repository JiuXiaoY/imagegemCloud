package com.imagegem.cloud.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


/**
 * 
 * @TableName account_tbl
 */
@TableName(value ="account_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountTbl implements Serializable {
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
     * 额度
     */
    private Integer money;

    /**
     * 已用额度
     */
    private Integer usedMoney;

    /**
     * 剩余额度
     */
    private Integer residue;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}