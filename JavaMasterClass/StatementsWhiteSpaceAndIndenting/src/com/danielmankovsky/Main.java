package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {
        int myVariable = 50; //the whole line is a statement, including int and ;
        myVariable++; //also statements
        myVariable--;
        System.out.println("This is a test"); //also statement, whole line
        //statements do not have to be in one line. Can be as follows:
        System.out.println("THis is" +
                " another " +
                "still more.");
        int anotherValiable = 50;
        myVariable++;
        System.out.println("This is another one.");
        //above is the same as if they were in different lines

    }
}

