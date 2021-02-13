package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {
        Account bobsAccount = new Account("12345", 0.00, "Bob Brown", "email@mail.com", "093-55-67");

        System.out.println(bobsAccount.getNumber());
        System.out.println(bobsAccount.getBalance());
    }
}
