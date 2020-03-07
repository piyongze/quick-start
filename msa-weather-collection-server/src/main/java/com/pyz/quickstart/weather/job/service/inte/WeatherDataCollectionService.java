package com.pyz.quickstart.weather.job.service.inte;

public interface WeatherDataCollectionService {

    /**
     * 依据城市ID同步天气数据
     * @param cityId
     */
    void syncDataByCityId(String cityId);
}
