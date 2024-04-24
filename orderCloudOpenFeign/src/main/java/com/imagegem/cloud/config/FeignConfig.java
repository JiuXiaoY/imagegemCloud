package com.imagegem.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/14
 */
@Configuration
public class FeignConfig {
    @Bean
    public Retryer myRetryer(){
//        return Retryer.NEVER_RETRY;
        return new Retryer.Default(100,1,3);
    }

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
