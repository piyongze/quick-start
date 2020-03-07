package com.pyz.quickstart.weather.web.client;

import com.pyz.quickstart.weather.web.vo.City;
import com.pyz.quickstart.weather.web.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataClientFallback implements DataClient{
    @Override
    public List<City> listCity() {
        List<City> cityList = null;
        cityList = new ArrayList<>();
        City city = new City() ;
        city.setCityId("101280601");
        city.setCityName("深圳");
        cityList.add(city);
        return cityList;
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return new WeatherResponse();
    }
}
