package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {
	boolean gameOver = true;
	int score = 4000;
	int levelCompleted =5;
	int bonus = 100;

//	if (score ==5000){
//        System.out.println("Your score was 5000.");}
//    //or the same:
//        if (score ==5000)
//            System.out.println("Your score was 5000.");
//
//    if (score < 5000 && score>1000){
//            System.out.println("Your score was less 5000 but greater than 1000.");
//    } else if (score <1000){
//            System.out.println("Yourscore was less than 1000");
//    }
//            else {
//        System.out.println("Got here.");
//    }
//once one part of if is executed, the rest ifs and elses are skipped

     if (gameOver==true){ //!!!can be abbreviated: if(gameOver==true)=if(gameOver)
         int finalScore = score + (levelCompleted * bonus);
     //finalScore was created within the code block, will not be recognized outside of it
     //score and others were not part of code block, will be recognized
         System.out.println("Your final score was " + finalScore);
     }
//this is because once the code block is executed, all the variables created in it are deleted
        //otherwise possible; from block can access variables created outside the block
    //int savedFinalScore = finalScore thus would not work

/*        int newScore = 1000;
        boolean newGameOver = true;
        int newLevelCompleted = 8;
        int newBonus = 200;

        if (newGameOver){
            int finalScore = newScore + (newLevelCompleted * newBonus);
            System.out.println("Your final score was " + finalScore);
        }*/

        score = 1000;
        levelCompleted =8;
        bonus = 200;

        if (gameOver==true) { //!!!can be abbreviated: if(gameOver==true)=if(gameOver)
            int finalScore = score + (levelCompleted * bonus);
            //finalScore was created within the code block, will not be recognized outside of it
            //score and others were not part of code block, will be recognized
            System.out.println("Your final score was " + finalScore);
        }

    }
}
