package br.edu.ifsc.clima.application.menu.options;

import br.edu.ifsc.clima.application.models.Forecast;
import br.edu.ifsc.clima.application.models.WeatherData;
import br.edu.ifsc.clima.application.services.WeatherApiService;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PrevisaoAmanha implements WeatherMenuStrategy {
    @Override
    public void printReturn() {
        try {
            System.out.println("Opção 2 selecionada - Consultar previsão climatica de amanhã");
            WeatherApiService weatherApiService = WeatherApiService.getInstance();
            WeatherData weatherData = weatherApiService.getWeatherData(weatherApiService.getLocalidade());
            Forecast forecast = weatherData.getResults().getForecast().get(1);
            weatherApiService.printWeatherForecast(forecast, weatherData.getResults().getCity());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getMenuPosition() {
        return 2;
    }

}
