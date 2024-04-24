package com.imagegem.cloud.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/4/20
 */
@RestController
@RefreshScope
public class NacosConfigClientController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/nacos/get/config/info")
    public String getNacosConfigInfo(@Value("${imagegem.infos}")String imagegem){
        return "port is: " + port + "  infos: " + imagegem + "  :ID is" + IdUtil.simpleUUID();
    }
}
