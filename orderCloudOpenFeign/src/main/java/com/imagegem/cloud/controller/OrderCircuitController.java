package com.imagegem.cloud.controller;

import com.imagegem.cloud.apis.PayFeignAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/16
 */
@Slf4j
@RestController
@RequestMapping("/feign")
public class OrderCircuitController {
    @Resource
    private PayFeignAPI payFeignAPI;

    @GetMapping("/circuit/selectOne/payment/{paymentID}")
    @CircuitBreaker(name = "paymentCloud", fallbackMethod = "myCircuitFallback")
    public String CircuitSelectOnePayment(@PathVariable("paymentID") Integer paymentID) {
        return payFeignAPI.CircuitSelectOnePayment(paymentID);
    }

    public String myCircuitFallback(Integer paymentID, RuntimeException t) {
        return "MyCircuit: 服务繁忙 paymentID is: " + paymentID;
    }

    /**
     * 基于信号量实现的舱壁隔离
     *
     * @param paymentID
     * @return
     */

/*
    @GetMapping("/bulkHead/selectOne/payment/{paymentID}")
    @Bulkhead(name = "paymentCloud", fallbackMethod = "myBulkHeadFallback", type = Bulkhead.Type.SEMAPHORE)
    public String bulkHeadSelectOnePayment(@PathVariable("paymentID") Integer paymentID){
        return payFeignAPI.bulkHeadSelectOnePayment(paymentID);
    }

    public String myBulkHeadFallback(Integer paymentID, RuntimeException t) {
        return "myBulkHead: 服务繁忙 paymentID is: " + paymentID ;
    }
*/


    /**
     * 基于线程池实现的舱壁隔离
     *
     * @param paymentID
     * @return
     */

//    @GetMapping("/bulkHeadPool/selectOne/payment/{paymentID}")
//    @Bulkhead(name = "paymentCloud", fallbackMethod = "myBulkHeadPoolFallback", type = Bulkhead.Type.THREADPOOL)
//    public CompletableFuture<String> bulkHeadPoolSelectOnePayment(@PathVariable("paymentID") Integer paymentID) {
//        log.info(Thread.currentThread().getName() + "start=====================");
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info(Thread.currentThread().getName() + "leave=====================");
//        return CompletableFuture.supplyAsync(() ->
//                payFeignAPI.bulkHeadPoolSelectOnePayment(paymentID) + "Bulkhead.Type.THREADPOOL");
//    }
//
//    public CompletableFuture<String> myBulkHeadPoolFallback(Integer paymentID, RuntimeException t) {
//        return CompletableFuture.supplyAsync(() -> "myBulkHead: 服务繁忙 paymentID is: " + paymentID);
//    }


    /**
     * 限流
     *
     * @param paymentID
     * @return
     */
    @GetMapping("/rateLimiter/selectOne/payment/{paymentID}")
    @RateLimiter(name = "paymentCloud", fallbackMethod = "myrateLimiterFallback")
    public String rateLimiterSelectOnePayment(@PathVariable("paymentID") Integer paymentID) {
        return payFeignAPI.rateLimiterSelectOnePayment(paymentID);
    }

    public String myrateLimiterFallback(Integer paymentID, RuntimeException t) {
        return "myrateLimiterFallback: 服务繁忙 paymentID is: " + paymentID;
    }

}
