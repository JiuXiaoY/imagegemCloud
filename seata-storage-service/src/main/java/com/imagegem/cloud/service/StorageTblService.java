package com.imagegem.cloud.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.imagegem.cloud.common.BaseResponse;
import com.imagegem.cloud.model.domain.StorageTbl;

/**
* @author 86187
* @description 针对表【storage_tbl】的数据库操作Service
* @createDate 2024-04-23 14:48:37
*/
public interface StorageTblService extends IService<StorageTbl> {

    BaseResponse deductCount(String commodityCode, int count);
}
