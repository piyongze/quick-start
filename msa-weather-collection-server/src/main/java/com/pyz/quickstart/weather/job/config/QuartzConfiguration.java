package com.pyz.quickstart.weather.job.config;

import com.pyz.quickstart.weather.job.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {

    private final int TIME= 1800;  //更新频率

    @Bean
    public JobDetail weatherDataSyncJobJobDetail() {
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob").storeDurably().build();
    }

    @Bean
    public Trigger sampleJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(TIME).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobJobDetail())
                .withIdentity("weatherDataSyncTrigger").withSchedule(scheduleBuilder).build();
    }
}
