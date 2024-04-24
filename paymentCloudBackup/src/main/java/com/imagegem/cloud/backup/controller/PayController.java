package com.imagegem.cloud.backup.controller;

import cn.hutool.core.bean.BeanUtil;
import com.imagegem.cloud.backup.domain.TPay;
import com.imagegem.cloud.backup.service.TPayService;
import com.imagegem.cloud.common.BaseResponse;
import com.imagegem.cloud.common.Errorcode;
import com.imagegem.cloud.common.ResultUtils;
import com.imagegem.cloud.dto.TPayDTO;
import com.imagegem.cloud.exception.BusinessException;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/11
 */
@Slf4j
@RestController
@SuppressWarnings("all")
@RequestMapping("/api")
public class PayController {

    @Resource
    private TPayService tPayService;

    @PostMapping("/add/payment")
    public BaseResponse<TPay> add(@RequestBody TPayDTO tPayDTO) {
        log.info(tPayDTO.toString());
        TPay tPay = new TPay();
        BeanUtil.copyProperties(tPayDTO, tPay);
        Boolean result = tPayService.addPayment(tPay);
        if (result) {
            return ResultUtils.success(tPay);
        } else {
            throw new BusinessException(Errorcode.PARAMS_ERROR);
        }
    }

    @PostMapping("/delete/payment")
    public BaseResponse<TPay> delete(@RequestBody TPay tPay) {
        int result = tPayService.deletePayment(tPay);
        if (result > 0) {
            return ResultUtils.success(tPay);
        } else {
            throw new BusinessException(Errorcode.SYSTEM_ERROR);
        }
    }

    @PostMapping("/update/payment")
    public BaseResponse<TPay> updatePayment(@RequestBody TPayDTO tPayDTO) {
        TPay tPay = new TPay();
        BeanUtil.copyProperties(tPayDTO, tPay);
        int result = tPayService.updatePayment(tPay);
        if (result > 0) {
            return ResultUtils.success(tPay);
        } else {
            throw new BusinessException(Errorcode.SYSTEM_ERROR);
        }
    }

    @GetMapping("/selectOne/payment/{paymentID}")
    public BaseResponse<TPay> selectPayment(@PathVariable("paymentID") Integer paymentID) {
        TPay tPay = tPayService.selectOnePayment(paymentID);
        if (tPay == null) {
            return ResultUtils.error(Errorcode.PARAMS_ERROR, "支付记录不存在", "");
        } else {
            return ResultUtils.success(tPay);
        }
    }

    @GetMapping("/selectAll/payment")
    public BaseResponse<TPay> selectAllPayment() {
        List<TPay> tPays = tPayService.selectAllPayment();
        return ResultUtils.success(tPays);
    }

    /**
     * test
     */
    @Value("${server.port}")
    private String port;
    @GetMapping("/get/info")
    public String getActive(@Value("${imagegem.info}") String info){
        return "message: " + info + port;
    }

}
