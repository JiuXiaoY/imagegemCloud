package com.imagegem.cloud.controller;

import com.imagegem.cloud.common.BaseResponse;
import com.imagegem.cloud.service.StorageTblService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/23
 */
@RestController
@Slf4j
public class StorageController {

    @Resource
    private StorageTblService storageTblService;

    @GetMapping("/deduct/storage/count")
    public BaseResponse deductStorageCount(@RequestParam("commodityCode") String commodityCode,
                                           @RequestParam("count") int count) {
        return storageTblService.deductCount(commodityCode, count);
    }
}
