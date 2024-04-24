package com.imagegem.cloud;

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
@EnableDiscoveryClient
@EnableFeignClients
public class orderCloudOpenFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(orderCloudOpenFeignApplication.class,args);
    }
}