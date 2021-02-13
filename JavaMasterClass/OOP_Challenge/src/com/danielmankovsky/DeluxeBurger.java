package com.danielmankovsky;

public class DeluxeBurger extends BasicBurger {
    public DeluxeBurger(String breadType, String meat) {
        super(breadType, meat);
        super.addAdditions("chips","drinks");
    }

    @Override
    public void addAdditions(String add1Name) {
        System.out.println("Unable to add additions to Deluxe burger");
    }

    @Override
    public void addAdditions(String add1Name, String add2Name) {
        System.out.println("Unable to add additions to Deluxe burger");
    }

    @Override
    public void addAdditions(String add1Name, String add2Name, String add3Name) {
        System.out.println("Unable to add additions to Deluxe burger");
    }

    @Override
    public void addAdditions(String add1Name, String add2Name, String add3Name, String add4Name) {
        System.out.println("Unable to add additions to Deluxe burger");
    }
}
