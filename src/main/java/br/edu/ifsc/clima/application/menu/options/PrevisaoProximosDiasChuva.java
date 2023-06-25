package br.edu.ifsc.clima.application.menu.options;

import br.edu.ifsc.clima.application.models.WeatherData;
import br.edu.ifsc.clima.application.services.WeatherApiService;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PrevisaoProximosDiasChuva implements WeatherMenuStrategy {
    @Override
    public void printReturn() {
        try {
            System.out.println("Opção 4 selecionada - Consultar previsão climatica dos proóximos dias de chuva");
            WeatherApiService weatherApiService = WeatherApiService.getInstance();
            WeatherData weatherData = weatherApiService.getWeatherData(weatherApiService.getLocalidade());
            weatherData.getResults().getForecast().stream().filter(forecast -> forecast.getRain_probability() > 50).forEach(i -> weatherApiService.printWeatherForecast(i, weatherData.getResults().getCity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getMenuPosition() {
        return 4;
    }
}
