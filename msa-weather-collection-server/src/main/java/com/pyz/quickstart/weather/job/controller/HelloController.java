package com.pyz.quickstart.weather.job.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather/job/")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
