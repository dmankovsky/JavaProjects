package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog ("Yorkie");
        dog.eat();
        dog.breath();

        Parrot parrot = new Parrot ("Australian ringneck");
        parrot.eat();
        parrot.breath();

        Penguin penguin = new Penguin("Emperor");
        penguin.fly();

    }
}
