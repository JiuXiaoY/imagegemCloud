package com.imagegem.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imagegem.cloud.common.BaseResponse;
import com.imagegem.cloud.common.Errorcode;
import com.imagegem.cloud.common.ResultUtils;
import com.imagegem.cloud.mapper.OrderTblMapper;
import com.imagegem.cloud.model.domain.OrderTbl;
import com.imagegem.cloud.seataApis.AccountFeignApi;
import com.imagegem.cloud.seataApis.StorageFeignApi;
import com.imagegem.cloud.service.OrderTblService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 86187
 * @description 针对表【order_tbl】的数据库操作Service实现
 * @createDate 2024-04-22 23:55:32
 */
@Service
@Slf4j
@SuppressWarnings("all")
public class OrderTblServiceImpl extends ServiceImpl<OrderTblMapper, OrderTbl>
        implements OrderTblService {

    @Resource
    private OrderTblMapper orderTblMapper;
    @Resource
    private StorageFeignApi storageFeignApi;
    @Resource
    private AccountFeignApi accountFeignApi;

    /**
     * create order
     *
     * @param orderTbl 订单实体
     */
    @Override
    @GlobalTransactional(name = "global_unify", rollbackFor = Exception.class)
    public BaseResponse createOrder(OrderTbl orderTbl) {
        //xid全局事务的检查
        String xid = RootContext.getXID();
        log.info("create order & xid is: " + xid);

        //订单新建时默认的状态为0
        orderTbl.setStatus(0);
        int saveResult = orderTblMapper.insert(orderTbl);
        if (saveResult <= 0) {
            return ResultUtils.error(Errorcode.PARAMS_ERROR);
        }
        QueryWrapper<OrderTbl> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", orderTbl.getId());

        OrderTbl result = orderTblMapper.selectOne(queryWrapper);
        if (result == null) {
            log.info("order create fail, order message is: " + result.toString());
            return ResultUtils.error(Errorcode.PARAMS_ERROR);
        }
        log.info("order create successful, order message is: " + result.toString());

        //  扣减库存
        log.info("start to deduct account......");
        storageFeignApi.deductStorageCount(result.getCommodityCode(), result.getCount());
        log.info("end to deduct account......");

        //  扣减余额
        log.info("start to deduct money......");
        accountFeignApi.deductAccountMoney(result.getUserId(), result.getMoney());
        log.info("end to deduct money......");

        //  修改订单状态
        log.info("start to reset orderStatus......");
        result.setStatus(1);
        int update = orderTblMapper.update(result, queryWrapper);

        if (update <= 0) {
            log.info("error to reset orderStatus......");
            return ResultUtils.error(Errorcode.SYSTEM_ERROR);
        }

        log.info("end to reset orderStatus......");
        return ResultUtils.success(result);
    }
}




