/**
 * 使用/actuator/bus-refresh 刷新配置
 * 测试自动刷新时 使用ngrok反向代理
 */
package com.pyz.quickstart.weather.config.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather/config/")
public class ConfigController {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }
}
