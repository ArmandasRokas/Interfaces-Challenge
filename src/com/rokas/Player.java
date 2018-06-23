package com.rokas;

import java.util.ArrayList;
import java.util.List;

public class Player implements Saveable {
    private String name;
    private int health;
    private String weapon;

    public Player (String name, int health){
        this.name = name;
        this.health = health;
        this.weapon = "sword";
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> valuesToStore = new ArrayList<String>();

        valuesToStore.add(name);
        valuesToStore.add(String.valueOf(health));
        valuesToStore.add(weapon);

        return valuesToStore;
    }

    @Override
    public void read(List<String> savedValues) {

        name = savedValues.get(0);
        health = Integer.parseInt(savedValues.get(1));
        weapon = savedValues.get(2);

    }
}
