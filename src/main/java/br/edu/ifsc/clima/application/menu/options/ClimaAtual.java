package br.edu.ifsc.clima.application.menu.options;

import br.edu.ifsc.clima.application.models.WeatherData;
import br.edu.ifsc.clima.application.services.IWeatherData2ForecastAdapter;
import br.edu.ifsc.clima.application.services.WeatherApiService;
import br.edu.ifsc.clima.application.services.WeatherData2ForecastAdapter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ClimaAtual implements WeatherMenuStrategy {

    @Override
    public void printReturn() {
        try {
            System.out.println("Opção 1 selecionada - Clima atual");
            WeatherApiService weatherApiService = WeatherApiService.getInstance();
            WeatherData weatherData = weatherApiService.getWeatherData(weatherApiService.getLocalidade());
            IWeatherData2ForecastAdapter data = new WeatherData2ForecastAdapter();
            weatherApiService.printWeatherForecast(data.converter(weatherData), weatherData.getResults().getCity());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getMenuPosition() {
        return 1;
    }

}
