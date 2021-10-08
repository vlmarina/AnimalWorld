package model;

import service.IllegalAliveException;
import service.IllegalFoodException;

public class Predator extends Animal {

    public Predator(String name, float m) {
        super(name, m);

    }

    public boolean eat(Food food) throws IllegalAliveException, IllegalFoodException {

        if (!isAlive)
            throw new IllegalAliveException();

        if (!(food instanceof Animal))
            throw new IllegalFoodException();

        if (!((Animal) food).isAlive)
            throw new IllegalFoodException(IllegalFoodException.DEFAULT_MESSAGE_FOR_PREDATOR);

        if (hunt(food)) {
            this.m += food.m;
            food.m = 0;
            return true;
        }
        return false;
    }


    private boolean hunt(Food food) {

        if (food.m <= this.m / 2) {
            ((Animal) food).kill();
            return true;
        } else
            return false;
    }

}
