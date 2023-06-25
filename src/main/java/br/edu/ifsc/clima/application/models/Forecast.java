package br.edu.ifsc.clima.application.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Forecast {
    private String date;
    private String weekday;
    private int max;
    private int min;
    private double cloudiness;
    private double rain;
    private int rain_probability;
    private String wind_speedy;
    private String description;
    private String condition;

}
