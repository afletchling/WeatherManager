package me.afletchling.weathermanager.managers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import me.afletchling.weathermanager.types.WeatherResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

public class WeatherManager {
    public final static WeatherManager INSTANCE = new WeatherManager();
    private final Gson gson = new Gson();
    private final Path runningDir = Paths.get("");
    private ArrayList<WeatherResponse> weatherArray = new ArrayList<>();

    // Add a new weather entry into storage
    public void addWeatherEntry(WeatherResponse response) {
        this.weatherArray.add(response);
    }

    // Loop backwards from last to first and display the associated weather information.
    public void displayAllEntries() {
        for (int index = this.weatherArray.size() - 1; index >= 0; index--) {
            WeatherResponse weather = this.weatherArray.get(index);
            StringJoiner builder = new StringJoiner(", ");
            builder.add("Weather: " + weather.weather.get(0).description);
            builder.add("Tempature: " + weather.main.temp + "F");
            builder.add("Location: " + weather.name);
            System.out.println("\u001b[33m[" + new Date(weather.dt * 1000) + "] " + builder);
        }
    }

    // Read and parse out weather data from a file path.
    public void readFromFile(String pathName) {
        Path filePath = Paths.get(pathName);
        Path runningDir = Paths.get("");

        if (filePath.toAbsolutePath().normalize().startsWith(runningDir.toAbsolutePath().normalize())) {
            try {
                weatherArray = gson.fromJson(Files.readAllLines(filePath).get(0), new TypeToken<List<WeatherResponse>>(){}.getType());
            } catch (IOException exception) {
                System.out.println("\u001b[31m[*] Failed to read file: " + exception.getMessage());
            }
        } else {
            System.out.println("\u001b[31m[*] Invalid file path.");
        }
    }

    // Write out the current storage into the specified file path.
    public void writeToFile(String pathName) {
        Path filePath = Paths.get(pathName);
        Path runningDir = Paths.get("");

        if (filePath.toAbsolutePath().normalize().startsWith(runningDir.toAbsolutePath().normalize())) {
            try {
                Files.write(filePath, gson.toJson(this.weatherArray).getBytes());
            } catch (IOException exception) {
                System.out.println("\u001b[31m[*] Failed to write file: " + exception.getMessage());
            }
        } else {
            System.out.println("\u001b[31m[*] Invalid file path.");
        }
    }
}
