package com.imagegem.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/20
 */
@Service
public class FlowLimitService {

    @SentinelResource(value = "common")
    public void common(){
        System.out.println("this is a common");
    }
}
