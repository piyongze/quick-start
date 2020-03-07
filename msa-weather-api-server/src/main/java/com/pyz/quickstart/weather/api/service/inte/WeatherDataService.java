package com.pyz.quickstart.weather.api.service.inte;


import com.pyz.quickstart.weather.api.vo.WeatherResponse;

public interface WeatherDataService {

    /**
     * id search weather
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * name search weather
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);

}
