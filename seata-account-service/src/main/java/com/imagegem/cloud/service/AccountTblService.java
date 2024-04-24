package com.imagegem.cloud.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.imagegem.cloud.common.BaseResponse;
import com.imagegem.cloud.model.domain.AccountTbl;

/**
* @author 86187
* @description 针对表【account_tbl】的数据库操作Service
* @createDate 2024-04-23 15:25:28
*/
public interface AccountTblService extends IService<AccountTbl> {

    BaseResponse deductAccountMoney(String userId, int moneyUsed);
}
