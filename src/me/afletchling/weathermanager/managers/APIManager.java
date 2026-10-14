package me.afletchling.weathermanager.managers;

import com.google.gson.Gson;
import me.afletchling.weathermanager.types.WeatherResponse;
import me.afletchling.weathermanager.utils.Util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class APIManager {
    public static APIManager INSTANCE = new APIManager();
    private String API_KEY = "";
    private final Gson gson = new Gson();

    // Fetch the current weather from the OpenWeatherAPI using HttpURLConnection and GSON
    public WeatherResponse fetchWeather(double latitude, double longitude) throws IOException {
        if (!this.API_KEY.isEmpty()) {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=" + this.API_KEY);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.connect();

            if (connection.getResponseCode() <= 299) {
                return gson.fromJson(Util.readFromStream(connection.getInputStream(), "ASCII"), WeatherResponse.class);
            } else {
                throw new IOException(connection.getResponseCode() + ": " + Util.readFromStream(connection.getErrorStream(), "ASCII"));
            }
        }

        // Template data returned if the API key does not exist.
        return gson.fromJson("{\"coord\":{\"lon\":10.99,\"lat\":44.34},\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"base\":\"stations\",\"main\":{\"temp\":298.48,\"feels_like\":298.74,\"temp_min\":297.56,\"temp_max\":300.05,\"pressure\":1015,\"humidity\":64,\"sea_level\":1015,\"grnd_level\":933},\"visibility\":10000,\"wind\":{\"speed\":0.62,\"deg\":349,\"gust\":1.18},\"rain\":{\"1h\":3.16},\"clouds\":{\"all\":100},\"dt\":1661870592,\"sys\":{\"type\":2,\"id\":2075663,\"country\":\"IT\",\"sunrise\":1661834187,\"sunset\":1661882248},\"timezone\":7200,\"id\":3163858,\"name\":\"Zocca\",\"cod\":200}", WeatherResponse.class);
    }

    // Set the current API key based off of the input environment variable.
    public void setApiKey(String key) {
        this.API_KEY = key;
    }
}
