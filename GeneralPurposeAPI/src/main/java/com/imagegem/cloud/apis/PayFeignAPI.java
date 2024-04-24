package com.imagegem.cloud.apis;

import com.imagegem.cloud.common.BaseResponse;
import com.imagegem.cloud.dto.TPayDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/14
 */
//@FeignClient("paymentCloud")
@FeignClient("gateWayCloud")
public interface PayFeignAPI {

    String URL_PRE = "/api";

    @PostMapping(URL_PRE + "/add/payment")
    BaseResponse addPayment(@RequestBody TPayDTO tPayDTO);

    @GetMapping(URL_PRE + "/selectOne/payment/{paymentID}")
    BaseResponse SelectOnePayment(@PathVariable("paymentID") Integer paymentID);

    @GetMapping(URL_PRE + "/get/info")
    String getInfo();

    @GetMapping(URL_PRE + "/circuit/selectOne/payment/{paymentID}")
    String CircuitSelectOnePayment(@PathVariable("paymentID") Integer paymentID);

    @GetMapping(URL_PRE + "/bulkHead/selectOne/payment/{paymentID}")
    String bulkHeadSelectOnePayment(@PathVariable("paymentID") Integer paymentID);

    @GetMapping(URL_PRE + "/bulkHeadPool/selectOne/payment/{paymentID}")
    String bulkHeadPoolSelectOnePayment(@PathVariable("paymentID") Integer paymentID);

    @GetMapping(URL_PRE + "/rateLimiter/selectOne/payment/{paymentID}")
    String rateLimiterSelectOnePayment(@PathVariable("paymentID") Integer paymentID);

    @GetMapping(URL_PRE + "/Micrometer/payment/{paymentID}")
    String MicrometerPayment(@PathVariable("paymentID") String paymentID);

    /**
     * gateway
     *
     * @return
     */
    @GetMapping(URL_PRE + "/gateway/info")
    BaseResponse<String> getGatewayInfo();

    @GetMapping(URL_PRE + "/gateway/selectOne/payment/{paymentID}")
    BaseResponse gatewaySelectPayment(@PathVariable("paymentID") Integer paymentID);
}
