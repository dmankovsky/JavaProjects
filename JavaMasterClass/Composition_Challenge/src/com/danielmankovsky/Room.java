package com.danielmankovsky;

public class Room {

    private Table table;
    private Switchers switcher;
    private Walls wall;

    public Room(Table table, Switchers switcher, Walls wall) {
        this.table = table;
        this.switcher = switcher;
        this.wall = wall;
    }

    public Table getTable() {
        return table;
    }

    public Switchers getSwitcher() {
        return switcher;
    }

    public Walls getWall() {return wall; }

    public void manipulateTable(){
        table.switchOnTableLamp();
        //getTable().switchOnTableLamp();
    }

    public void turnSwitcher (){
        System.out.println("switcher turned");
    }

}

