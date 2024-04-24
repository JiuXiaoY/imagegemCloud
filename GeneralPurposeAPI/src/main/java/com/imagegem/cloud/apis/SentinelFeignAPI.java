package com.imagegem.cloud.apis;

import com.imagegem.cloud.common.BaseResponse;
import com.imagegem.cloud.fallBack.SentinelFeignAPIFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/21
 */
@FeignClient(value = "cloudAlibabaPayment", fallback = SentinelFeignAPIFallback.class)
public interface SentinelFeignAPI {

    @GetMapping("/openfeign/sentinel/getPayment/{paymentID}")
    BaseResponse getPayment(@PathVariable("paymentID") Integer paymentID);
}
