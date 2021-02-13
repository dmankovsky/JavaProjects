package com.danielmankovsky;

class Movie {
    private String name;

    public Movie (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String plot(){
        return "No plot here";
    }
}

class Jaws extends Movie {
    public Jaws() {
        super("Jaws");
    }
    public String plot() {
        return "A shark eats lots of people";
    }
}

class IndependenceDay extends Movie{
    public IndependenceDay() {
        super ("IndependenceDay");
    }
    public String plot(){
        return "Aliens attack the Earth";
    }
}

class StarWars extends Movie {
    public StarWars () {
        super("StarWars");
    }
    public String plot(){
        return "Star Wars plot";
    }
}

class MazeRunner extends Movie {
    public MazeRunner(){
        super("MazeRunner");
    }
    public String plot(){
        return "Kids try and escape a maze";
    }
}

class Forgettable extends Movie {
    public Forgettable() {
        super("Forgettable");
    }
    //no plot method
}

public class Main {

    public static void main(String[] args) {
    for (int i=1;i<11;i++){
        Movie movie=randomMovie();
        System.out.println("Movie #" + i + " : " + movie.getName() + "\n" +
        "Plot: " + movie.plot() + "\n");
    }
}
    public static Movie randomMovie(){
        int randomNumber=(int)(Math.random()*5)+1;
        System.out.println("Random number generated was: " + randomNumber);
        switch (randomNumber){
            case 1:
                return new Jaws();
                //break; //break unnecessary here
            case 2:
                return new StarWars();
                //break;
            case 3:
                return new IndependenceDay();
                //break;
            case 4:
                return new MazeRunner();
                //break;
            case 5:
                //return new Forgettable();
        }
        return null;
    }
}

