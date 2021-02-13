package com.danielmankovsky;

public class Table {
    private int legs;
    private String colour;

    public Table(int legs, String colour) {
        this.legs = legs;
        this.colour = colour;
    }

    public void switchOnTableLamp(){
        System.out.println("Table lamp switched.");
    }

}
