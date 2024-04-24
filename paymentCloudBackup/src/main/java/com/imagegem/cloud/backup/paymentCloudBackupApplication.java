package com.imagegem.cloud.backup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/11
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.imagegem.cloud.backup.mapper")
@RefreshScope
public class paymentCloudBackupApplication {
    public static void main(String[] args) {
        SpringApplication.run(paymentCloudBackupApplication.class,args);
    }
}
