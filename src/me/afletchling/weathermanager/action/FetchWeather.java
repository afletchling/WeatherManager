package me.afletchling.weathermanager.action;

import me.afletchling.weathermanager.managers.APIManager;
import me.afletchling.weathermanager.managers.WeatherManager;
import me.afletchling.weathermanager.types.WeatherResponse;
import me.afletchling.weathermanager.utils.Util;

import java.io.IOException;

public class FetchWeather extends Action {
    public FetchWeather() {
        super("Fetch current weather", "Fetch the current weather data using the OpenWeatherAPI");
    }

    @Override
    public void Callback() {
        double latitude = Util.readTerminalNumber("What is the latitude? ");
        double longitude = Util.readTerminalNumber("What is the longitude? ");

        try {
            WeatherManager.INSTANCE.addWeatherEntry(APIManager.INSTANCE.fetchWeather(latitude, longitude));
            System.out.println("Added current weather!");
        } catch (IOException exception) {
            System.out.println("\u001b[31m[*] Failed to add weather: " + exception.getMessage());
        }
    }
}
