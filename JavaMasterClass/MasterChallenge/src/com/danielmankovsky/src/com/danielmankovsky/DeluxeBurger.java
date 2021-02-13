package com.danielmankovsky.src.com.danielmankovsky;

import com.danielmankovsky.BasicHamburger;

public class DeluxeBurger extends BasicHamburger {
    public DeluxeBurger() {
        super("Deluxe", "Sausage & Bacon", 14.54, "White");
        super.addAddition1("Chips", 2.75);
        super.addAddition2("Drink", 1.81);
    }

    @Override
    public void addAddition1(String name, double price) {
        System.out.println("Cannot not add additional items to a deluxe burger");
    }

    @Override
    public void addAddition2(String name, double price) {
        System.out.println("Cannot not add additional items to a deluxe burger");
    }

    @Override
    public void addAddition3(String name, double price) {
        System.out.println("Cannot not add additional items to a deluxe burger");
    }

    @Override
    public void addAddition4(String name, double price) {
        System.out.println("Cannot not add additional items to a deluxe burger");
    }
}
