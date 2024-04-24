package com.imagegem.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author JXY
 * @version 1.0
 * @since $DATE
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.imagegem.cloud.mapper")
public class SeataAccountService {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountService.class, args);
    }
}