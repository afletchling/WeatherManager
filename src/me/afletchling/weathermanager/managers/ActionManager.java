package me.afletchling.weathermanager.managers;

import me.afletchling.weathermanager.action.Action;

import java.util.ArrayList;
import java.util.Arrays;

public class ActionManager {
    public ArrayList<Action> actions = new ArrayList<Action>();
    public static ActionManager INSTANCE = new ActionManager();

    public void addAction(Action... actions) {
        this.actions.addAll(Arrays.asList(actions));
    }

    // Print out each action with the associated name and description.
    public void displayActions() {
        for (int index = 0; index < this.actions.size(); index++) {
            Action action = this.actions.get(index);
            System.out.println("\u001b[32m" + (index + 1) + ". " + action.getName() + " - " + action.getDescription() + "\u001b[0m");
        }
    }

    // Trigger the action callback based on the input index, throws ArrayIndexOutOfBoundsException if the input is not valid.
    public void triggerAction(String input) throws ArrayIndexOutOfBoundsException {
        int index = Integer.parseInt(input) - 1;
        Action action = this.actions.get(index);
        action.Callback();
    }
}
