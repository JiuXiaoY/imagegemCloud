package com.imagegem.cloud.controller;

import com.imagegem.cloud.common.BaseResponse;
import com.imagegem.cloud.model.domain.OrderTbl;
import com.imagegem.cloud.service.OrderTblService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/23
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private OrderTblService orderTblService;

    @PostMapping("/create/order")
    public BaseResponse createOrder(OrderTbl orderTbl) {
        return orderTblService.createOrder(orderTbl);
    }
}
