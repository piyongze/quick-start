package com.pyz.quickstart.weather.web.client;

import com.pyz.quickstart.weather.web.vo.City;
import com.pyz.quickstart.weather.web.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="msa-weather-gateway-server", fallback = DataClientFallback.class)
public interface DataClient {

    @GetMapping("/weather/city/all")
    List<City> listCity() throws Exception;

    @GetMapping("/weather/api/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId")String cityId);
}
