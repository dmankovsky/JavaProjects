package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {
    Switchers switcher = new Switchers("green");
    Table table = new Table (3,"blue");
    Walls wall = new Walls ("north");

    Room room = new Room (table, switcher, wall);
    room.getSwitcher().turnOnLight();

    room.manipulateTable();

    //room.getWall().drawBlinds();

    room.manipulateTable();
    }

}
