package com.imagegem.cloud.controller;

import com.imagegem.cloud.apis.PayFeignAPI;
import com.imagegem.cloud.common.BaseResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/19
 */
@Slf4j
@RestController
@RequestMapping("/feign")
public class OrderGateWayController {

    @Resource
    private PayFeignAPI payFeignAPI;

    @GetMapping("/gateway/selectOne/payment/{paymentID}")
    public BaseResponse selectPayment(@PathVariable("paymentID") Integer paymentID){
        return payFeignAPI.gatewaySelectPayment(paymentID);
    }

    @GetMapping("/gateway/info")
    public BaseResponse<String> getGatewayInfo(){
        return payFeignAPI.getGatewayInfo();
    }
}
