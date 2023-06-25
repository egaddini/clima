package br.edu.ifsc.clima.application.services;

import br.edu.ifsc.clima.application.models.Forecast;
import br.edu.ifsc.clima.application.models.WeatherData;

public class WeatherData2ForecastAdapter implements IWeatherData2ForecastAdapter {

    @Override
    public Forecast converter(WeatherData weather) {
        return weather.getResults().getForecast().get(0);

    }

}
