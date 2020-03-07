package com.pyz.quickstart.weather.job.service;

import com.pyz.quickstart.weather.job.service.inte.WeatherDataCollectionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeatherDataCollectionServiceImplTest {

    @Autowired
    WeatherDataCollectionService weatherDataCollectionService;

    @Test
    void testSyncDataByCityId(){
        weatherDataCollectionService.syncDataByCityId("101280601");
    }

}