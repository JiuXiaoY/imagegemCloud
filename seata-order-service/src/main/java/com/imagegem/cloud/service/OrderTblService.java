package com.imagegem.cloud.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.imagegem.cloud.common.BaseResponse;
import com.imagegem.cloud.model.domain.OrderTbl;

/**
* @author 86187
* @description 针对表【order_tbl】的数据库操作Service
* @createDate 2024-04-22 23:55:32
*/
@SuppressWarnings("all")
public interface OrderTblService extends IService<OrderTbl> {
    /**
     * create order
     */
    BaseResponse createOrder(OrderTbl orderTbl);
}
