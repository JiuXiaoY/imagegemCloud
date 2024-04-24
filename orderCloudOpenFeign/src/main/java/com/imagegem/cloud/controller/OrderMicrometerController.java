package com.imagegem.cloud.controller;

import com.imagegem.cloud.apis.PayFeignAPI;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/18
 */
@Slf4j
@RestController
@RequestMapping("/feign")
public class OrderMicrometerController {
    @Resource
    private PayFeignAPI payFeignAPI;

    @GetMapping("/Micrometer/payment/{paymentID}")
    public String MicrometerPayment(@PathVariable("paymentID")String paymentID){
        return payFeignAPI.MicrometerPayment(paymentID);
    }
}
