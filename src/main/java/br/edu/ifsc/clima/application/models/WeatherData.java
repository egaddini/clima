package br.edu.ifsc.clima.application.models;

import lombok.Data;

@Data
public class WeatherData {
    private String by;
    private boolean validKey;
    private Results results;
    private double executionTime;
    private boolean fromCache;

}

