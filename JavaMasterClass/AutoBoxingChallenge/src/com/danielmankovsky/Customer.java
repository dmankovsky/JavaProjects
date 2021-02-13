package com.danielmankovsky;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions; // = new ArrayList<Double>();    better to initialize in the constructor

    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions=new ArrayList<Double>();
        addTransaction(initialAmount);
    }
    //check if constructor correct
    public Customer (String name){
        this.name = name;
        this.transactions=new ArrayList<Double>();
        addTransaction(0.0);
    }

    public void addTransaction (double amount){
        this.transactions.add(amount);
    }

    public String getName() {
        return name;
    }


    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
