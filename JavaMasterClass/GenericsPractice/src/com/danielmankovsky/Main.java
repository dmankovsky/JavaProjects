package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {
	    Team <FootballPlayer> eintracht = new Team ("Eintracht");

	    FootballPlayer pele = new FootballPlayer("pele");
        FootballPlayer kaka = new FootballPlayer("kaka");

        BasketballPlayer wade = new BasketballPlayer("wade");
        BasketballPlayer oneal = new BasketballPlayer("oneal");

	    eintracht.addPlayer(pele);
        eintracht.addPlayer(kaka);
        eintracht.addPlayer(wade);
        eintracht.addPlayer(oneal);


    }
}
