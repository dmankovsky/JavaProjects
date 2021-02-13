package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {
	// The sooner a bug is discovered, the better/cheaper
        // we will create our own generic classes here
        // to create sort of a filter that will only allow a particluar type of player to be added to the team, we are making team into a generic class

        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team <FootballPlayer> adelaideCrows = new Team <>("Adelaide Crows"); // proper assignment of a generic class
        adelaideCrows.addPlayer(joe);
        //adelaideCrows.addPlayer(pat);
        //adelaideCrows.addPlayer(beckham);

        System.out.println(adelaideCrows.numPlayers());

        Team <BaseballPlayer> baseBallTeam = new Team <>("Chicago Cubs");
        baseBallTeam.addPlayer(pat);

        Team <SoccerPlayer> brokenTeam = new Team <>("this won't work");
        brokenTeam.addPlayer(beckham);


        Team<FootballPlayer> melbourne = new Team <>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordon");
        melbourne.addPlayer(banks);

        Team<FootballPlayer> hawthorn = new Team <>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team <>("Fremantle");

        hawthorn.matchResult(fremantle, 1,0);
        hawthorn.matchResult(adelaideCrows,3,8);

        adelaideCrows.matchResult(fremantle,2,1);
        // adelaideCrows.matchResult(baseBallTeam,1,1);

        System.out.println("Rankings:");
        System.out.println(adelaideCrows.getName() + ": " + adelaideCrows.ranking());
        System.out.println(melbourne.getName() + ": " + melbourne.ranking());
        System.out.println(fremantle.getName() + ": " + fremantle.ranking());
        System.out.println(hawthorn.getName() + ": " + hawthorn.ranking());

        System.out.println(adelaideCrows.compareTo(melbourne));
        System.out.println(adelaideCrows.compareTo(hawthorn));

        System.out.println(melbourne.compareTo(adelaideCrows));
        System.out.println(melbourne.compareTo(melbourne));
    }
}
