package com.pyz.quickstart.weather.job.service;

import com.pyz.quickstart.weather.job.service.inte.WeatherDataCollectionService;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    private static final Logger logger = LogManager.getLogger(WeatherDataCollectionServiceImpl.class);

    private final String WEATHER_BASE_URL = "http://wthrcdn.etouch.cn/weather_mini";

    private final Long TIME_OUT = 1800L;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void syncDataByCityId(String cityId) {
        logger.info("开始同步天气 ，cityId {}", cityId);

        String uri = WEATHER_BASE_URL + "?citykey=" + cityId;

        this.saveWeatherData(uri);
    }

    public void saveWeatherData(String uri) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        if (response.getStatusCode().value() == 200 && StringUtils.isNotBlank(response.getBody())) {
            try {
                ops.set(uri, response.getBody(), TIME_OUT, TimeUnit.SECONDS);
            } catch (Exception e){
                logger.error(e.getMessage(), e);
            }
        }
    }
}
