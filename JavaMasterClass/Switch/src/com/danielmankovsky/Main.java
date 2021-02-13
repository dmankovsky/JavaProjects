package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {
        int value = 1;
        if (value == 1) {
            System.out.println("Value was 1.");
        } else if (value == 2) {
            System.out.println("Value was 2.");
        } else {
            System.out.println("Was not 1 or 2.");
        }

        int switchValue = 3;

        switch (switchValue) {
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Was a 3, or a 4, or a 5.");
                System.out.println("Actually it was a " + switchValue);
                break;
            default: //special key word!!!
                System.out.println("Was not 1 or 2.");
                break;//if leave this break out, nothing changes, yet better use
        }

        char charValue = 'A';
        switch (charValue) {
            case 'A':
                System.out.println("Value was A.");
                break;
            case 'B':
                System.out.println("Value was B.");
                break;
            case 'C':
                System.out.println("Value was C.");
                break;
            case 'D':
                System.out.println("Value was D.");
                break;
            default:
                System.out.println("Value was not found.");
                break;
        }
//in Java 8 and above they added switch command for strings

        String month = "January";
        switch (month.toLowerCase()) {//pay attention to this thing!!!
            case "january":
                System.out.println("Jan");
                break;
            case "june":
                System.out.println("Jun");
                break;
            default:
                System.out.println("Not sure");
                break;
        }


    }
}
