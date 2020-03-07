package com.pyz.quickstart.weather.city.controller;

import com.pyz.quickstart.weather.city.service.inte.CityDataService;
import com.pyz.quickstart.weather.city.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather/city")
@RefreshScope
public class WeatherCityController {

    @Value("${auther}")
    String auther;

    @Autowired
    CityDataService cityDataService;

    @GetMapping("/hello")
    public String sayHell(){
        return "hello " + auther;
    }

    @GetMapping("/all")
    public List<City> listCity() throws Exception{
        return cityDataService.listCity();

    }
}
