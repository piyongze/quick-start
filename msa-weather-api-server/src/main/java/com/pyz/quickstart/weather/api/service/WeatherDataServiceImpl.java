package com.pyz.quickstart.weather.api.service;

import com.alibaba.fastjson.JSON;
import com.pyz.quickstart.weather.api.service.inte.WeatherDataService;
import com.pyz.quickstart.weather.api.vo.WeatherResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private static final Logger logger = LogManager.getLogger(WeatherDataServiceImpl.class);

    private final String WEATHER_BASE_URL = "http://wthrcdn.etouch.cn/weather_mini";


    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_BASE_URL + "?citykey=" + cityId;
        return doGetWeatherData(uri);
    }

    public WeatherResponse getDataByCityName(String cityName){
        String uri = WEATHER_BASE_URL + "?city=" + cityName;
        return doGetWeatherData(uri);
    }

    private WeatherResponse doGetWeatherData(String uri){
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        if(stringRedisTemplate.hasKey(uri)){
            String strBody = ops.get(uri);
            WeatherResponse weatherResponse = JSON.parseObject(strBody, WeatherResponse.class);
            return weatherResponse;
        }
        return null;
    }
}
