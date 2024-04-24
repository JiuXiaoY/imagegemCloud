package com.imagegem.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imagegem.cloud.model.domain.TPay;

import java.util.List;

/**
* @author 86187
* @description 针对表【t_pay(支付交易表)】的数据库操作Service
* @createDate 2024-04-11 15:16:00
*/
public interface TPayService extends IService<TPay> {

    Boolean addPayment(TPay tPay);

    int deletePayment(TPay tPay);

    int updatePayment(TPay tPay);

    TPay selectOnePayment(Integer id);

    List<TPay> selectAllPayment();
}
