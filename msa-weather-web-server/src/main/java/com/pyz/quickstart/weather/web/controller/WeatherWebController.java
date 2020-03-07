package com.pyz.quickstart.weather.web.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pyz.quickstart.weather.web.client.DataClient;
import com.pyz.quickstart.weather.web.service.inte.WeatherReportService;
import com.pyz.quickstart.weather.web.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/weather/web/")
public class WeatherWebController {

    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private DataClient dataClient;

    @GetMapping("/hello")
    public String sayHello() {
        return "hello.";
    }

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {

        List<City> cityList = dataClient.listCity();
        model.addAttribute("title", "老魏的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }

}
