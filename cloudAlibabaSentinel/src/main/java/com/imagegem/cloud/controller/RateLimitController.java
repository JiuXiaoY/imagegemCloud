package com.imagegem.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/21
 */
@RestController
public class RateLimitController {

    @GetMapping("/get/rate/info")
    public String getRateInfo() {
        return "thi is a nothing else, but ID is: " + IdUtil.simpleUUID();
    }

    @GetMapping("/get/rate/resource")
    @SentinelResource(value = "RateResource", blockHandler = "resourceBlockHandler")
    public String getRateResource() {
        return "thi is a resource, but ID is: " + IdUtil.simpleUUID();
    }

    public String resourceBlockHandler(BlockException blockException) {
        return "this is a handler, Message is: " + blockException.getMessage();
    }

    /**
     * hotkey
     */
    @GetMapping("/get/rate/hotkey")
    @SentinelResource(value = "hotkey", blockHandler = "hotkeyBlockHandler")
    public String getHotkey(@RequestParam(value = "p1", required = false) String p1,
                            @RequestParam(value = "p2", required = false) String p2) {
        return "thi is a hotkey, but ID is: " + IdUtil.simpleUUID();
    }
    public String hotkeyBlockHandler(BlockException blockException) {
        return "this is a hotkeyBlockHandler, Message is: " + blockException.getMessage();
    }
}
