package com.danielmankovsky;

public class Account {
    private String number;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public Account() { //no void or something, since this is a constructor
        this("45986745",2.50,"Default name","Default address",
                "Default phone");
        //that was a special use of the word "this"; nowhere else to find
        //"this" is calling a constructor from another constructor
        //the line with "this" must be the fist line that is called in the constructor
        System.out.println("Empty constructor called.");
    }

    public Account(String number, double balance, String customerName,
                   String email, String phoneNumber){
        System.out.println("Account constructor with parameters called.");
        this.number=number;
        //using setter here is not always justified;
        //there are scenarios where setNumber(number); would not work
        //rule of thumb: when using constructors, assign values directly like here
        //other rule: do not use any methods other than other constructors when creating a constructor

        this.balance=balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber=phoneNumber;
    }

    public Account(String customerName, String email, String phoneNumber) {
        this("9999",100.5, customerName, email, phoneNumber);
   }

    public void deposit(double amount){
        this.balance +=amount;
        System.out.println(amount + " deposited. New balance is " + this.balance);
    }

    public void withdrawal(double amount){
        if (this.balance - amount < 0){
            System.out.println("Cannot process. Max available balance: " + this.balance);
        }else{
            this.balance -=amount;
            System.out.println(amount + " withdrawn. New balance is " + this.balance);
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
