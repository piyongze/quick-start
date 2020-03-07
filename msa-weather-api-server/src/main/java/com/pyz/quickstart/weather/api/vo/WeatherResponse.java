package com.pyz.quickstart.weather.api.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class WeatherResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Weather data;
    private String status;
    private String desc;
}
