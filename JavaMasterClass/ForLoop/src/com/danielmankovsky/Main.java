package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {
        System.out.println("10000 at 2% is " + calculateInterest(10000.00, 2.0));

        for(int i =0; i<5; i++){
            System.out.println("Loop " + i + " hello!");
        }

        for (double interestRate=2;interestRate<=8;interestRate++){
        System.out.println("10000 at the interest of " + interestRate + " is " + String.format("%.2f",calculateInterest(10000,interestRate)));
        }

        System.out.println("***********************************");

        for (double interestRate=8;interestRate>=2;interestRate--){
            System.out.println("10000 at the interest of " + interestRate + " is " + String.format("%.2f",calculateInterest(10000,interestRate)));
        }

        int count =0;
        for (int i=10;i<50;i++){
            if (isPrime(i)==true){
                count++;
                System.out.println("Number " + i + " is a prime number.");
                if (count ==10){
                    System.out.println("Exiting for loop");
                    break;
                }
            }
        }


    }

    public static boolean isPrime (int n){
        if (n==1){
            return false;
        }
        for (int i=2;i<=n/2;i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;

    }
    public static double calculateInterest (double amount, double interestRate){
        return (amount * (interestRate/100));
    }
}
