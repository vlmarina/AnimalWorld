package model;

import service.IllegalAliveException;
import service.IllegalFoodException;

public class Herbivore extends Animal {

    public Herbivore(String name, float m) {
        super(name, m);

    }

    public boolean eat(Food food) throws IllegalAliveException, IllegalFoodException {

        if (!isAlive)
            throw new IllegalAliveException();

        if (food.m == 0)
            throw new IllegalFoodException(IllegalFoodException.DEFAULT_MESSAGE_FOR_HERBIVORE);

        if (!(food instanceof Grass))
            throw new IllegalFoodException();

        float mTaken = food.m * 0.1f;
        this.m += mTaken;
        food.m -= mTaken;

        return true;
    }
}
