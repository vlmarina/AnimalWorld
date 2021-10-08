package controller;

import model.Food;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class ServerResponce implements Serializable {

    int command;
    HashMap<Integer, Food> argument;

    public ServerResponce(int command) {
        this.command = command;
        this.argument = null;
    }

    public ServerResponce(int command,HashMap<Integer, Food> argument) {
        this.command = command;
        this.argument = argument;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(HashMap<Integer, Food> argument) {
        this.argument = argument;
    }
}
