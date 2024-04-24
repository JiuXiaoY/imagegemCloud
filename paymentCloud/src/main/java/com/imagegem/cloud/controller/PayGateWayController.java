package com.imagegem.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.imagegem.cloud.common.BaseResponse;
import com.imagegem.cloud.common.Errorcode;
import com.imagegem.cloud.common.ResultUtils;
import com.imagegem.cloud.model.domain.TPay;
import com.imagegem.cloud.service.TPayService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/18
 */
@Slf4j
@RestController
@SuppressWarnings("all")
@RequestMapping("/api")
public class PayGateWayController {
    @Resource
    private TPayService tPayService;

    @GetMapping("/gateway/selectOne/payment/{paymentID}")
    public BaseResponse gatewaySelectPayment(@PathVariable("paymentID") Integer paymentID) {
        TPay tPay = tPayService.selectOnePayment(paymentID);
        if (tPay == null) {
            return ResultUtils.error(Errorcode.PARAMS_ERROR, "支付记录不存在", "");
        } else {
            return ResultUtils.success(tPay);
        }
    }

    @GetMapping("/gateway/info")
    public BaseResponse<String> getGatewayInfo() {
        return ResultUtils.success("gateway info test: " + IdUtil.simpleUUID());
    }

    @GetMapping("/gateway/filter/info")
    public BaseResponse<String> getGatewayFilterinfo(HttpServletRequest httpServletRequest) {
        String result = "";
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headName = headerNames.nextElement();
            String headerValue = httpServletRequest.getHeader(headName);
            log.info(headName + ": " + headerValue);
            if (headName.equalsIgnoreCase("X-Request-imagegem") || headName.equalsIgnoreCase("X-Request-lovegem")) {
                result = result + headName + ": " + headerValue + "   next   ";
            }
        }
        return ResultUtils.success("this is a filter: " + result + "  ID is: " + IdUtil.simpleUUID());
    }
}
