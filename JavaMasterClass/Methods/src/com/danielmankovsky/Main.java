package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {//this is the main method containing lots of statements making up the method

        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int highScore = calculateScore (gameOver,score,levelCompleted,bonus);
        System.out.println("Your final score was " + highScore);

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        highScore = calculateScore(gameOver,score,levelCompleted,bonus);
        System.out.println("Your last score was " + highScore);


    }
    //create another method in what follows; cannot create a method within another method

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) { //in normal brackets input to the method, here: existing variables
    //no need to create those variables above, parameters of a method are created automat. as variables
    //void means do not send any value back as out put of the method
    //when need to use output for another method, change void into the data type we want to get back
        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;
            return finalScore;//once method void was changed into int, important to add the return line
            //in case of if command, return must be applied to all scenarios, all elses. Sth must be returned anyway
        } else {
            return -1;
            }
        }

    }


