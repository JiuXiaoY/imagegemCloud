package com.imagegem.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.imagegem.cloud.common.BaseResponse;
import com.imagegem.cloud.common.ResultUtils;
import com.imagegem.cloud.dto.TPayDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/20
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/nacos/get/infos")
    public String nacosGetInfos() {
        return "nacos: the port is: " + port + ":  " + IdUtil.simpleUUID();
    }

    /**
     * openfeign + sentinel
     */
    @GetMapping("/openfeign/sentinel/getPayment/{paymentID}")
    @SentinelResource(value = "openfeign_sentinel", blockHandler = "OSBlockHandler")
    public BaseResponse getPayment(@PathVariable("paymentID") Integer paymentID) {
        TPayDTO tPayDTO = new TPayDTO();
        tPayDTO.setId(100);
        tPayDTO.setPayNo("100");
        tPayDTO.setAmount(BigDecimal.valueOf(100));
        tPayDTO.setOrderNo("100");
        tPayDTO.setUserId(100);

        return ResultUtils.success(tPayDTO);
    }

    public BaseResponse OSBlockHandler(@PathVariable("paymentID") Integer paymentID, BlockException blockException) {
        return ResultUtils.error(8848, "服务不可用", "流控阈值限制错误返回");
    }
}
