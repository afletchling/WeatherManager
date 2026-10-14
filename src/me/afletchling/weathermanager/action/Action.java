package me.afletchling.weathermanager.action;

public abstract class Action {
    private String name = "";
    private String description = "";

    public Action(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public abstract void Callback();
}
