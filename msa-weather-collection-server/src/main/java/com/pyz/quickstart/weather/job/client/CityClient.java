package com.pyz.quickstart.weather.job.client;

import com.pyz.quickstart.weather.job.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("msa-weather-city-server")
public interface CityClient {

    @GetMapping("/weather/city/all")
    List<City> listCity() throws Exception;
}
