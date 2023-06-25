package br.edu.ifsc.clima.application.menu.options;

import br.edu.ifsc.clima.application.models.WeatherData;
import br.edu.ifsc.clima.application.services.WeatherApiService;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PrevisaoProximosDias implements WeatherMenuStrategy {

    @Override
    public void printReturn() {
        try {
            System.out.println("Opção 3 selecionada - Consultar previsão climatica dos proóximos dias");
            WeatherApiService weatherApiService = WeatherApiService.getInstance();
            WeatherData weatherData = weatherApiService.getWeatherData(weatherApiService.getLocalidade());
            weatherData.getResults().getForecast().forEach(i -> weatherApiService.printWeatherForecast(i, weatherData.getResults().getCity()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getMenuPosition() {
        return 3;
    }

}
