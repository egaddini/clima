package br.edu.ifsc.clima.application.services;

import br.edu.ifsc.clima.application.models.Forecast;
import br.edu.ifsc.clima.application.models.WeatherData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherApiService {
    private static final String API_KEY = "SUA-CHAVE";
    private static final String BASE_URL = "https://api.hgbrasil.com/weather";

    private Gson gson;

    private static WeatherApiService instance;

    @Getter
    @Setter
    private boolean woeid;

    private WeatherApiService() {
        gson = new GsonBuilder().create();
    }

    public static WeatherApiService getInstance() {
        if (instance == null) {
            synchronized (WeatherApiService.class) {
                if (instance == null) {
                    instance = new WeatherApiService();
                }
            }
        }
        return instance;
    }

    public WeatherData getWeatherData(String city) throws IOException {
        String apiUrl = woeid ? BASE_URL + "?key=" + API_KEY + "&woeid=" +  city : BASE_URL + "?key=" + API_KEY + "&city_name=" + city;
        String jsonResponse = sendGetRequest(apiUrl);
        return gson.fromJson(jsonResponse, WeatherData.class);
    }
    private String sendGetRequest(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            in.close();
            return response.toString();
        } else {
            throw new IOException("GET request failed with response code: " + responseCode);
        }
    }

    public void printWeatherForecast(Forecast forecast, String city) {
        System.out.println("---------------------------------------");
        System.out.println("Data: " + forecast.getDate() + " " + city);
        System.out.println("Dia da semana: " + forecast.getWeekday());
        System.out.println("Temperatura máxima: °C " + forecast.getMax());
        System.out.println("Temperatura mínima: °C " + forecast.getMin());
        System.out.println("Nebulosidade: " + forecast.getCloudiness());
        System.out.println("Chuva: " + forecast.getRain());
        System.out.println("Probabilidade de chuva: " + forecast.getRain_probability() + "%");
        System.out.println("Velocidade do vento: " + forecast.getWind_speedy());
        System.out.println("Descrição: " + forecast.getDescription());
        System.out.println("---------------------------------------");
    }

    public String getLocalidade() {
        return woeid ? WOEIDState() : promptCityAndState();
    }

    private String promptCityAndState() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Digite o estado: ");
        String estado = scanner.nextLine();
        return cidade + "," + estado;
    }

    private String WOEIDState() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o Where On Earth IDentifier: ");
        int woeid = scanner.nextInt();
        return String.valueOf(woeid);
    }

}


