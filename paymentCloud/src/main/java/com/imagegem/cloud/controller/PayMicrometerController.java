package com.imagegem.cloud.controller;

import cn.hutool.core.util.IdUtil;
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
@SuppressWarnings("all")
@RequestMapping("/api")
public class PayMicrometerController {

    @GetMapping("/Micrometer/payment/{paymentID}")
    public String MicrometerPayment(@PathVariable("paymentID")String paymentID){
        return "Hello, I'm Micrometer: paymentID is: " + paymentID + IdUtil.simpleUUID();
    }
}
