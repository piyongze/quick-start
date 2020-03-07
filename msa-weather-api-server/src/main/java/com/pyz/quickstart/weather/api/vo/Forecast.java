package com.pyz.quickstart.weather.api.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Forecast implements Serializable {
    private static final long serialVersionUID = 1L;

    private String date;
    private String high;
    private String fengxiang;
    private String low;
    private String fengli;
    private String type;
}
