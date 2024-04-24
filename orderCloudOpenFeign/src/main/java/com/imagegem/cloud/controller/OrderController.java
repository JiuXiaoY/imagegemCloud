package com.imagegem.cloud.controller;

import com.imagegem.cloud.apis.PayFeignAPI;
import com.imagegem.cloud.common.BaseResponse;
import com.imagegem.cloud.dto.TPayDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/12
 */
@Slf4j
@RestController
@RequestMapping("/feign")
public class OrderController {

    @Resource
    private PayFeignAPI payFeignAPI;

    @PostMapping("/add/payment")
    public BaseResponse addOrder(TPayDTO tPayDTO) {
        log.info("feign add order!");
        return payFeignAPI.addPayment(tPayDTO);
    }

    @GetMapping("/selectOne/payment/{paymentID}")
    public BaseResponse selectOnePayment(@PathVariable("paymentID") Integer paymentID) {
        log.info("feign select order!");
        return payFeignAPI.SelectOnePayment(paymentID);
    }

    @GetMapping("/get/info")
    public String getInfoByConsul() {
        return payFeignAPI.getInfo();
    }

}
