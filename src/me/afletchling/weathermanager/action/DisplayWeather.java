package me.afletchling.weathermanager.action;

import me.afletchling.weathermanager.managers.WeatherManager;

public class DisplayWeather extends Action {
    public DisplayWeather() {
        super("Display weather", "Display all currently stored weather entries.");
    }

    @Override
    public void Callback() {
        WeatherManager.INSTANCE.displayAllEntries();
    }
}
