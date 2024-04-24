package com.imagegem.cloud.controller;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/16
 */
@Slf4j
@RestController
@SuppressWarnings("all")
@RequestMapping("/api")
public class PayCircuitController {

    @GetMapping("/circuit/selectOne/payment/{paymentID}")
    public String CircuitSelectOnePayment(@PathVariable("paymentID") Integer paymentID){


        if(paymentID<0){
            throw new RuntimeException("ID can not be negative");
        }

        if (paymentID==9999) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "hello Circuit! paymentID is: " + paymentID + IdUtil.simpleUUID();
    }

    @GetMapping("/bulkHead/selectOne/payment/{paymentID}")
    public String bulkHeadSelectOnePayment(@PathVariable("paymentID") Integer paymentID){


        if(paymentID<0){
            throw new RuntimeException("ID can not be negative");
        }

        if (paymentID==2) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "hello bulkHead! paymentID is: " + paymentID + IdUtil.simpleUUID();
    }

    @GetMapping("/bulkHeadPool/selectOne/payment/{paymentID}")
    public String bulkHeadPoolSelectOnePayment(@PathVariable("paymentID") Integer paymentID){


        if(paymentID<0){
            throw new RuntimeException("ID can not be negative");
        }

        if (paymentID==2) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "hello bulkHeadPool! paymentID is: " + paymentID + IdUtil.simpleUUID();
    }

    @GetMapping("/rateLimiter/selectOne/payment/{paymentID}")
    public String rateLimiterSelectOnePayment(@PathVariable("paymentID") Integer paymentID){


        if(paymentID<0){
            throw new RuntimeException("ID can not be negative");
        }

        if (paymentID==2) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "hello rateLimiter! paymentID is: " + paymentID + "/t" + IdUtil.simpleUUID();
    }


}
