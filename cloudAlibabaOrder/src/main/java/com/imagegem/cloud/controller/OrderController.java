package com.imagegem.cloud.controller;

import com.imagegem.cloud.apis.SentinelFeignAPI;
import com.imagegem.cloud.common.BaseResponse;
import com.imagegem.cloud.constant.URLConstant;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/20
 */
@Slf4j
@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/nacos/get/infos")
    public String nacosGetInfos() {
        String result = restTemplate.getForObject(URLConstant.PAYMENT_URL + "/nacos/get/infos", String.class);
        return result + "NacosOrder: hello";
    }

    /**
     * openFeign
     */

    @Resource
    private SentinelFeignAPI sentinelFeignAPI;

    @GetMapping("/sentinel/openFeign/Nacos/{paymentID}")
    public BaseResponse getPayment(@PathVariable("paymentID") Integer paymentID) {
        return sentinelFeignAPI.getPayment(paymentID);
    }

}
