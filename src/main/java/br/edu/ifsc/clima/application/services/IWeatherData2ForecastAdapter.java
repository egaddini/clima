package br.edu.ifsc.clima.application.services;

import br.edu.ifsc.clima.application.models.Forecast;
import br.edu.ifsc.clima.application.models.WeatherData;

public interface IWeatherData2ForecastAdapter {
    Forecast converter(WeatherData weather);
}
