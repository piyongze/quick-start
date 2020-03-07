package com.pyz.quickstart.weather.job.job;

import com.pyz.quickstart.weather.job.client.CityClient;
import com.pyz.quickstart.weather.job.service.inte.WeatherDataCollectionService;
import com.pyz.quickstart.weather.job.vo.City;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataSyncJob extends QuartzJobBean {

    private static final Logger logger = LogManager.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Autowired
    private CityClient cityClient;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("开始同步天气任务");
        List<City> cityList = null;
        //todo 用api微服务实现
        try{
            cityList = cityClient.listCity();
        } catch (Exception e){
            logger.error("获取城市信息失败", e);
            throw new RuntimeException("获取城市信息失败");
        }

        cityList.forEach(per -> weatherDataCollectionService.syncDataByCityId(per.getCityId()));
        logger.info("执行结束");
    }
}
