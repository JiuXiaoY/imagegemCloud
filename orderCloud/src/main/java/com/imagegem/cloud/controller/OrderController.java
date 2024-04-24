package com.imagegem.cloud.controller;

import com.imagegem.cloud.common.BaseResponse;
import com.imagegem.cloud.constant.URLConstant;
import com.imagegem.cloud.dto.TPayDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/12
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/add/payment")
    public BaseResponse addOrder(TPayDTO tPayDTO) {
        log.info(tPayDTO.toString());
        return restTemplate.postForObject(URLConstant.PAYMENT_URL + "/add/payment", tPayDTO, BaseResponse.class);
    }

    @GetMapping("/selectOne/payment/{paymentID}")
    public BaseResponse selectOnePayment(@PathVariable("paymentID") Integer paymentID) {
        return restTemplate.getForObject(URLConstant.PAYMENT_URL + "/selectOne/payment/" + paymentID, BaseResponse.class, paymentID);
    }

    @PostMapping("/delete/payment")
    public BaseResponse deletePayment(TPayDTO tPayDTO) {
        return restTemplate.postForObject(URLConstant.PAYMENT_URL + "/delete/payment", tPayDTO, BaseResponse.class);
    }

    @PostMapping("/update/payment")
    public BaseResponse updatePayment(TPayDTO tPayDTO) {
        return restTemplate.postForObject(URLConstant.PAYMENT_URL + "/update/payment", tPayDTO, BaseResponse.class);
    }

    @GetMapping("/get/info")
    public String getInfoByConsul() {
        return restTemplate.getForObject(URLConstant.PAYMENT_URL + "/get/info", String.class);
    }

    @GetMapping("/get/discovery")
    public void getDiscovery(){

        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);

        List<ServiceInstance> instances = discoveryClient.getInstances("paymentCloud");
        instances.forEach(instance-> System.out.println(instance.toString()));

    }
}
