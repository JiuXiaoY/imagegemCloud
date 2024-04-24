package com.imagegem.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class orderCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(orderCloudApplication.class,args);
    }
}
