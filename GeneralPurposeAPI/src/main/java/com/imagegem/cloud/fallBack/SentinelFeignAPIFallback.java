package com.imagegem.cloud.fallBack;

import com.imagegem.cloud.apis.SentinelFeignAPI;
import com.imagegem.cloud.common.BaseResponse;
import com.imagegem.cloud.common.ResultUtils;
import org.springframework.stereotype.Component;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/21
 */
@Component
public class SentinelFeignAPIFallback implements SentinelFeignAPI {

    @Override
    public BaseResponse getPayment(Integer paymentID) {
        return ResultUtils.error(9999, "this is a fallback call", "fallback服务降级");
    }
}
