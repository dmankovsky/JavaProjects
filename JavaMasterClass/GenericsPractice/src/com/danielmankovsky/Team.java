package com.danielmankovsky;

import java.util.ArrayList;

public class Team <T extends Player>{

    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList <T>  members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer (T player){
        if (members.contains(player)){
            System.out.println("Player already in the team.");
            return false;
        } else {
            members.add(player);
            System.out.println("Player " + player.getName() + " added to the team " + this.name);
            return true;
        }
    }
}
