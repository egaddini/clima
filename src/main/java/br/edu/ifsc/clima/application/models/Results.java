package br.edu.ifsc.clima.application.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class Results {
    private int temp;
    private String date;
    private String time;
    private String conditionCode;
    private String description;
    private String currently;
    private String cid;
    private String city;
    private String imgId;
    private int humidity;
    private double cloudiness;
    private double rain;
    private String wind_speedy;
    private int windDirection;
    private String sunrise;
    private String sunset;
    private String conditionSlug;
    private String cityName;
    private List<Forecast> forecast;
    private String cref;

}
