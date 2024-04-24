package com.imagegem.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imagegem.cloud.common.Errorcode;
import com.imagegem.cloud.exception.BusinessException;
import com.imagegem.cloud.mapper.TPayMapper;
import com.imagegem.cloud.model.domain.TPay;
import com.imagegem.cloud.service.TPayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 86187
 * @description 针对表【t_pay(支付交易表)】的数据库操作Service实现
 * @createDate 2024-04-11 15:16:00
 */
@Service
public class TPayServiceImpl extends ServiceImpl<TPayMapper, TPay>
        implements TPayService {

    @Resource
    private TPayMapper tPayMapper;

    @Override
    public Boolean addPayment(TPay tPay) {
        int insert = tPayMapper.insert(tPay);
        return insert == 1;
    }

    @Override
    public int deletePayment(TPay tPay) {
        Integer id = tPay.getId();
        QueryWrapper<TPay> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        Long countResult = tPayMapper.selectCount(queryWrapper);
        if (countResult <= 0) {
            throw new BusinessException(Errorcode.PARAMS_ERROR, "订单不存在");
        }
        return tPayMapper.delete(queryWrapper);
    }

    @Override
    public int updatePayment(TPay tPay) {
        QueryWrapper<TPay> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", tPay.getId());
        Long countResult = tPayMapper.selectCount(queryWrapper);
        if (countResult<=0) {
            throw new BusinessException(Errorcode.PARAMS_ERROR, "订单不存在");
        }
        return tPayMapper.update(tPay, queryWrapper);
    }

    @Override
    public TPay selectOnePayment(Integer id) {
        TPay tPay = tPayMapper.selectById(id);
        if (tPay == null) {
            throw new BusinessException(Errorcode.PARAMS_ERROR, "订单不存在");
        }
        return tPay;
    }

    @Override
    public List<TPay> selectAllPayment() {
        // 查询所有的支付记录
        // 返回查询结果
        return tPayMapper.selectList(null);
    }
}




