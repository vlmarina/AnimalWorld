package model;

import service.IllegalAliveException;
import service.IllegalFoodException;

import java.io.Serializable;

public abstract class Food implements Serializable {

    protected String name;
    protected float m;

    protected int id;

    protected Food(String name, float m) throws IllegalFoodException {
        super();

        if (m <= 0)
            throw new IllegalAliveException(IllegalAliveException.DEFAULT_MESSAGE_FOR_BIRTH);

        this.name = name;
        this.m = m;
    }

    public String getInfo() {
        return "name = " + name + " m = " + m;
    }
    public String getAllInfo() {
        return "name= "+name + " m= " + m;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getM() {
        return m;
    }

    public void setM(float m) {
        this.m = m;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
