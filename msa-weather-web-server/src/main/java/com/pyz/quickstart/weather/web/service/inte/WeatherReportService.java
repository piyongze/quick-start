package com.pyz.quickstart.weather.web.service.inte;

import com.pyz.quickstart.weather.web.vo.Weather;

public interface WeatherReportService {

    Weather getDataByCityId(String cityId);
}
