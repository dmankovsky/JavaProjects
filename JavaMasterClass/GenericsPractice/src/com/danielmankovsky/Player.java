package com.danielmankovsky;

public abstract class Player {
    String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
