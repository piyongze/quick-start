package com.pyz.quickstart.weather.api.controller;

import com.pyz.quickstart.weather.api.service.inte.WeatherDataService;
import com.pyz.quickstart.weather.api.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather/api/")
public class WeatherApiController {

    @Autowired
    WeatherDataService weatherDataService;

    @RequestMapping("/cityId/{cityId}")
    public WeatherResponse getReportByCityId(@PathVariable("cityId") String cityId) {
        return weatherDataService.getDataByCityId(cityId);
    }

    @RequestMapping("/cityName/{cityName}")
    public WeatherResponse getReportByCityName(@PathVariable("cityName") String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }
}
