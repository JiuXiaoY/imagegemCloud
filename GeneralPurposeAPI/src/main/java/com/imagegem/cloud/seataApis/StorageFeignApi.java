package com.imagegem.cloud.seataApis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/22
 */
@FeignClient(value = "seata-storage-service")
public interface StorageFeignApi {
    @GetMapping("/deduct/storage/count")
    void deductStorageCount(@RequestParam("commodityCode")String commodityCode,
                            @RequestParam("count")int count);
}
