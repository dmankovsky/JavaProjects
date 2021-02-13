package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {
	int newScore = calculateScore("Bob", 400);
        System.out.println("New score is " + newScore);
        calculateScore(75);
        calculateScore();
        calcFeetAndInchesToCentimeters(5,7);
        calcFeetAndInchesToCentimeters(100);

    }

    public static int calculateScore (String playerName, int score){
        System.out.println("Player " + playerName + " scored " + score + " points.");
        return score * 1000;
    }

    public static int calculateScore (int score){
        System.out.println("Unnamed player " +  " scored " + score + " points.");
        return score * 1000;
    }
    public static int calculateScore (){
        System.out.println("No player, no score. ");
        return 0;
    }


    public static double calcFeetAndInchesToCentimeters (double feet, double inches){
        if (feet >=0 && inches >=0 && inches <=12){
            double centimeters = (feet *12 * 2.54);
            centimeters += inches * 2.54;
            System.out.println(feet + " feet " + inches + " inches = " + centimeters + " centimeters");
            return centimeters;
        } else {
            System.out.println("Invalid parameters");
            return -1;
        }
    }
// alternative validation check is the opposite: if (inches <0) {return -1;} double =feet...
    public static double calcFeetAndInchesToCentimeters (double inches){
        if (inches >=0){
            double feet = (int) inches / 12;
            double remainingInches = (int) inches %12;
            System.out.println(inches + " inches is equal to " + feet + " feet and " + remainingInches + " remainingInches");
            return calcFeetAndInchesToCentimeters(feet, remainingInches);
        } else {
            System.out.println("Invalid parameters");
            return -1;
        }
    }



}
