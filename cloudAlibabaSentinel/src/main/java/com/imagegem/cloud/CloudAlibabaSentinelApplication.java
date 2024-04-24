package com.imagegem.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author JXY
 * @version 1.0
 * @since $DATE
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaSentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaSentinelApplication.class,args);
    }
}