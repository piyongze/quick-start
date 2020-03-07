package com.pyz.quickstart.weather.city.service.inte;

import com.pyz.quickstart.weather.city.vo.City;

import java.util.List;

public interface CityDataService {

    List<City> listCity() throws Exception;
}
