package me.afletchling.weathermanager.types;

import java.util.ArrayList;

// Holder class for the weather response.
public class WeatherResponse {
    public Coords coord;
    public ArrayList<WeatherMetadata> weather;
    public String base;
    public WeatherData main;
    public double visibility;
    public WindData wind;
    public CloudData clouds;
    public long dt;
    public SysData sys;
    public int timezone;
    public long id;
    public String name;
    public double cod;

    public class Coords {
        public double lon;
        public double lat;
    }

    public class WeatherData {
        public double temp;
        public double feels_like;
        public double temp_min;
        public double temp_max;
        public double pressure;
        public double humidity;
        public double sea_level;
        public double grnd_level;
    }

    public class WeatherMetadata {
        public long id;
        public String main;
        public String description;
        public String icon;
    }

    public class WindData {
        public double speed;
        public double deg;
        public double gust;
    }

    public class CloudData {
        public double all;
    }

    public class SysData {
        public double type;
        public long id;
        public String country;
        public long sunrise;
        public long sunset;
    }
}