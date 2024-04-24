package com.imagegem.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imagegem.cloud.common.BaseResponse;
import com.imagegem.cloud.common.Errorcode;
import com.imagegem.cloud.common.ResultUtils;
import com.imagegem.cloud.exception.BusinessException;
import com.imagegem.cloud.mapper.AccountTblMapper;
import com.imagegem.cloud.model.domain.AccountTbl;
import com.imagegem.cloud.service.AccountTblService;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 86187
 * @description 针对表【account_tbl】的数据库操作Service实现
 * @createDate 2024-04-23 15:25:28
 */
@Service
@Slf4j
public class AccountTblServiceImpl extends ServiceImpl<AccountTblMapper, AccountTbl>
        implements AccountTblService {

    @Resource
    private AccountTblMapper accountTblMapper;

    @Override
    public BaseResponse deductAccountMoney(String userId, int moneyUsed) {
        // 先查询此账户存不存在
        QueryWrapper<AccountTbl> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        AccountTbl selectResult = accountTblMapper.selectOne(queryWrapper);
        if (selectResult == null) {
            log.info("Account is not exist, the userId is: " + userId);
            throw new BusinessException(Errorcode.SYSTEM_ERROR);
        }

        // update account
        selectResult.setUsedMoney(selectResult.getUsedMoney() + moneyUsed);
        selectResult.setResidue(selectResult.getResidue() - moneyUsed);

        int update = accountTblMapper.update(selectResult, queryWrapper);

        // 模拟超时异常
//        try {
//            TimeUnit.SECONDS.sleep(70);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        if (update > 1) {
            log.info("reset account successful");
            return ResultUtils.success(selectResult);
        } else {
            log.info("error to reset account");
            return ResultUtils.error(Errorcode.SYSTEM_ERROR);
        }
    }
}




