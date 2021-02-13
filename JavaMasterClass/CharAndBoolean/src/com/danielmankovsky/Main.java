package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {
        //width of char is 16 (2 bytes)
	char myChar = '\u00A9';
        System.out.println(myChar);

        boolean myBoolean = true;

        //byte
        //short
        //int
        //long
        //float
        //double
        //char
        //boolean

        String myString = "My new string";
        System.out.println(myString);

        String numberString = "4";
        numberString = numberString + "49.95";
        System.out.println(numberString);

        String lastString ="10";
        int myInt = 20;
        lastString = lastString + myInt;
        System.out.println(lastString);


    }
}
