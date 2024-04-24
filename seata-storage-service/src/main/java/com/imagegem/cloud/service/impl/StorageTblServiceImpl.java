package com.imagegem.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imagegem.cloud.common.BaseResponse;
import com.imagegem.cloud.common.Errorcode;
import com.imagegem.cloud.common.ResultUtils;
import com.imagegem.cloud.model.domain.StorageTbl;
import com.imagegem.cloud.mapper.StorageTblMapper;
import com.imagegem.cloud.service.StorageTblService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 86187
 * @description 针对表【storage_tbl】的数据库操作Service实现
 * @createDate 2024-04-23 14:48:37
 */
@Service
@Slf4j
public class StorageTblServiceImpl extends ServiceImpl<StorageTblMapper, StorageTbl>
        implements StorageTblService {

    @Resource
    private StorageTblMapper storageTblMapper;

    @Override
    public BaseResponse deductCount(String commodityCode, int count) {
        // 先查出是否是有这个商品编码
        QueryWrapper<StorageTbl> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("commodity_code", commodityCode);
        StorageTbl searchResult = storageTblMapper.selectOne(queryWrapper);
        if (searchResult == null) {
            log.info("this product is not exist, commodityCode is: " + commodityCode);
            // TODO 返回错误结果
            return ResultUtils.error(Errorcode.PARAMS_ERROR);
        }
        // 存在这个账户，进行相关修改
        searchResult.setUsedCount(searchResult.getUsedCount() + count);
        searchResult.setResidue(searchResult.getResidue() - count);

        // 更新
        int update = storageTblMapper.update(searchResult, queryWrapper);
        if (update <= 0) {
            log.info("error to update storage.......");
            return ResultUtils.error(Errorcode.SYSTEM_ERROR);
        }
        log.info("update storage successful......");
        return ResultUtils.success(searchResult);
    }
}




