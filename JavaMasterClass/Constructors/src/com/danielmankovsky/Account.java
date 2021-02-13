package com.danielmankovsky;

public class Account {
    private String number;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public Account (){ //no "void" indicate it is a constructor
        this("5678",2.50,"Default name","Default address","default phone");
     /*the line above starting with this must be the first one - call constructor from another constructor*/
        System.out.println("Empty constructor called");
    }

    public Account(String number, double balance, String customerName, String email, String phoneNumber){
        System.out.println("Account constructor with parameters called");
    this.number = number;
    this.balance = balance;
    this.customerName = customerName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    }

    /*to create getters and setters in bulk: code -> generate -> getters and setters*/

    public void deposit (double depositAmount){
        this.balance += depositAmount;
        System.out.println("Deposit of " + depositAmount + " made. New balance is " + this.balance);
    }

    public void withdrawal (double withdrawalAmount){
        if (this.balance - withdrawalAmount <0){
            System.out.println("Only " + this.balance + " available. Withdrawal not processed");
        } else{
            this.balance -= withdrawalAmount;
            System.out.println("Withdrawal of " + withdrawalAmount + " processed. Remaining balance: " + this.balance);
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
