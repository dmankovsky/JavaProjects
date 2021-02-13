package com.danielmankovsky;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner (System.in);
    static Bank myBank = new Bank ();

    public static void main(String[] args) {

        myBank.addBranch("MyBranch");

        myBank.addCustomerToBranch("ben","MyBranch",100.10);
        myBank.addCustomerToBranch("sam","MyBranch",200.20);

        myBank.addTransactionToCustomer("ben","MyBranch",1213.123);

        //myBank.findBranch("MyBranch");

        myBank.listCustomersOfBranch("MyBranch",true);

        if (!myBank.addCustomerToBranch("Bob","MyBranch2",348.34)){
            System.out.println("Error. Branch does not exist.");
        }





    }

}
