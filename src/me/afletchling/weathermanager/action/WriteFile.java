package me.afletchling.weathermanager.action;

import me.afletchling.weathermanager.managers.WeatherManager;
import me.afletchling.weathermanager.utils.Util;

public class WriteFile extends Action {
    public WriteFile() {
        super("Write to storage", "Write stored weather data to a file path.");
    }

    @Override
    public void Callback() {
        WeatherManager.INSTANCE.writeToFile(Util.readTerminal("Which path would you like to write to? "));
    }
}
