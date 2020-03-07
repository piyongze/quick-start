package com.pyz.quickstart.weather.api.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Yesterday implements Serializable {
    private static final long serialVersionUID = 1L;
    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}
