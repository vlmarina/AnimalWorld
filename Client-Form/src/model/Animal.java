package model;

import service.IllegalAliveException;
import service.IllegalFoodException;

public abstract class Animal extends Food {

    protected boolean isAlive;

    protected Animal(String name, float m) {

        super(name, m);
        this.isAlive = true;

    }

    public void kill() throws IllegalAliveException {

        if (!isAlive)
            throw new IllegalAliveException(IllegalAliveException.DEFAULT_MESSAGE_FOR_ANIMAL_KILL);

        isAlive = false;
    }

    public abstract boolean eat(Food food) throws IllegalAliveException, IllegalFoodException;

    public String getInfo() {
        return name + " " + m + " " + isAlive;
    }
    public String getAllInfo() {
        return "name= "+name + " m= " + m + " isAlive= " + isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

}
