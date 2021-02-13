package com.danielmankovsky;

public class Switchers {
    private String colour;

    public Switchers(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void turnOnLight(){
        System.out.println("Light turned on.");
    }
}
