package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {

        Account bobsAccount = new Account();//("12345",0.00, "Bob Brown",
                //"email@mail.com","009-09-0989");

        System.out.println(bobsAccount.getBalance());
        System.out.println(bobsAccount.getNumber());

        bobsAccount.withdrawal(100);

        bobsAccount.deposit(50);
        bobsAccount.withdrawal(100);

        bobsAccount.deposit(50);
        bobsAccount.withdrawal(100);

        Account timsAccount = new Account("Tim","email@mail.com","2370");
        System.out.println(timsAccount.getNumber() + " name " + timsAccount.getCustomerName());

        VipCustomer person1 = new VipCustomer();
        System.out.println(person1.getName());

        VipCustomer person2 = new VipCustomer("Bob",25000);
        System.out.println(person2.getName());
        System.out.println(person2.getEmail());

        VipCustomer person3 = new VipCustomer("Tim",100,"ssfdlgkm@mail.com");
        System.out.println(person3.getName());
        System.out.println(person3.getEmail());

    }


}
