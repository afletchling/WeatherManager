package me.afletchling.weathermanager.action;

public class Exit extends Action {
    public Exit() {
        super("Exit", "Exit the program.");
    }

    @Override
    public void Callback() {
        System.exit(0);
    }
}
