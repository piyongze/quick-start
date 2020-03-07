package com.pyz.quickstart.weather.web.service;

import com.pyz.quickstart.weather.web.client.DataClient;
import com.pyz.quickstart.weather.web.service.inte.WeatherReportService;
import com.pyz.quickstart.weather.web.vo.Weather;
import com.pyz.quickstart.weather.web.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse response = dataClient.getDataByCityId(cityId);
        return response.getData();
    }
}
