package com.rokas;

import java.util.ArrayList;
import java.util.List;

public class Monster implements Saveable {

    private String name;
    private int health;

    public Monster(String name,int health){
        this.name = name;
        this.health = health;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", health=" + health +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> valuesToStore = new ArrayList<String>();

        valuesToStore.add(name);
        valuesToStore.add(String.valueOf(health));

        return valuesToStore;
    }

    @Override
    public void read(List<String> savedValues) {

        name = savedValues.get(0);
        health = Integer.parseInt(savedValues.get(1));

    }
}
