import me.afletchling.weathermanager.action.*;
import me.afletchling.weathermanager.managers.APIManager;
import me.afletchling.weathermanager.managers.ActionManager;
import me.afletchling.weathermanager.utils.Util;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Parse the API KEY from the .env file for safe keeping.
        APIManager.INSTANCE.setApiKey(Optional.ofNullable(System.getenv("API_KEY")).orElse(""));
        ActionManager.INSTANCE.addAction(new FetchWeather(), new DisplayWeather(), new ReadFile(), new WriteFile(), new Exit());

        System.out.println("\u001b[33mHello! Welcome to WeatherManager!\u001b[0m");

        while (true) {
            System.out.println();
            ActionManager.INSTANCE.displayActions();
            String line = Util.readTerminal("What action would you like to perform? ");

            try {
                ActionManager.INSTANCE.triggerAction(line);
            } catch (Exception exception) {
                System.out.println("Invalid action! Please try again.");
            }
        }
    }
}