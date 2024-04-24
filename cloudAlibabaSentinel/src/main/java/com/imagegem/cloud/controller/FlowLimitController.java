package com.imagegem.cloud.controller;

import com.imagegem.cloud.service.FlowLimitService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/20
 */
@RestController
public class FlowLimitController {

    @Resource
    public FlowLimitService flowLimitService;

    @GetMapping("/testA")
    public String testA() {
        flowLimitService.common();
        return "testA.....";
    }

    @GetMapping("/testB")
    public String testB() {
        flowLimitService.common();
        return "testB.....";
    }

    @GetMapping("/testE")
    public String testE() {
        System.out.println("stand in line, waiting for deal..... " + System.currentTimeMillis());
        return "stand in line, waiting for deal..... " + System.currentTimeMillis();
    }

    @GetMapping("/testF")
    public String testF() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "I'm running......";
    }
}
