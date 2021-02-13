package com.danielmankovsky;

import java.util.ArrayList;

public class Team <T extends Player> implements  Comparable<Team<T>>{ // changing class declaration, T means type; the type remains unknown until we instantiate a class i.e. at runtime
    // bounded type parameters - to validate the types that can be parsed
    // Player is thus set as the upper bound of T

    // extends Player & Coach & Manager - sythax to use multiple bounds; one of those has to be an interface (not two?)
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    //List<SoccerPlayer> and List <FootballPlayer> have nothing in common. Their common parent is List! Not the Player Class

    //private ArrayList<Player> members = new ArrayList<>(); // to make that generic, see next line:
    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer (T player){ //instead of Player player; is now a parametrized type
        if (members.contains(player)){
            System.out.println(player.getName() + " is already on this team.");
            return false;
        } else {
            members.add(player);  // Player is abstract class, still can be parsed. this is generics (at the definition of the ArrayList of type Player, not specific type of player).
            // allows to add all three types of players that implement that
            // interface with one call
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int numPlayers (){
        return this.members.size();
    }

    public void matchResult (Team<T> opponent, int ourScore, int theirScore){
        String message;
        if (ourScore>theirScore){
            won++;
            message = " beat ";
        } else if (ourScore==theirScore){
            tied++;
            message = " drew with ";
        } else {
            lost++;
            message = " lost to ";
        }
        played++;
        if (opponent != null){
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore,ourScore);
        }
    }

    public int ranking (){
        return (won * 2 ) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()){
            return -1;
        } else {
            if (this.ranking() < team.ranking()){
                return 1;
            } else {
                return 0;
            }
        }
    }


}
