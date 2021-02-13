package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {

        int number =5;
        int finishNumber =20;
        /*while (number <= finishNumber){
            if(!isEvenNumber(number)){
                number++;
                continue; //opposite to break
            }
            System.out.println(number + " is even.");
            number++;
        }*/

        int count=1;
        while (count <= 5 && number <=finishNumber) {
                if (!isEvenNumber(number)) {
                    number++;
                    continue; //opposite to break
                }
                System.out.println(number);
                number++;
                count++;
            } System.out.println("5 even numbers found.");

        //alternative solution:

        number =5;
        finishNumber =20;
        int evenNumbersFound =0;
        while (number <=finishNumber) {
            if (!isEvenNumber(number)) {
                number++;
                continue;
            }

            System.out.println("Even number " + number);
            number++;
            evenNumbersFound++;
            if (evenNumbersFound >= 5) {
                break;
            }
            }
            System.out.println("Total even numbers found =" + evenNumbersFound);









        isEvenNumber(11);
/*
        int count = 1;
        while (count != 5) {
            System.out.println("Count value is " + count);
            count++;
        }


        count = 1;
        while (true) {
            if (count == 5) {
                break;
            }
            System.out.println("Count value is " + count);
            count++;
        }

    for (int i=6; i!=6; i++){
        System.out.println("Count value is "+ count); //code never gets executed this way
    }
    // with do while gets executed at least once

    count=6;
    do {
        System.out.println("Count value was " + count);
        count ++;
        if (count > 100){
            break;
        }
    } while (count !=6); //mind the syntax
*/

    }
    public static boolean isEvenNumber (int n){
        if (n%2==0){
            return true;
        } else {
            return false;
        }
    }

}