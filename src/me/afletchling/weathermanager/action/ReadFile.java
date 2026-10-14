package me.afletchling.weathermanager.action;

import me.afletchling.weathermanager.managers.WeatherManager;
import me.afletchling.weathermanager.utils.Util;

public class ReadFile extends Action {
    public ReadFile() {
        super("Read from storage", "Read stored weather data from a file path.");
    }

    @Override
    public void Callback() {
        WeatherManager.INSTANCE.readFromFile(Util.readTerminal("Which path would you like to read from? "));
    }
}
