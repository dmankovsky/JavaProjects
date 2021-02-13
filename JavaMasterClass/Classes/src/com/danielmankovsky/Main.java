package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {
        Car porsche = new Car(); //unlike datatypes, classes need to be initialized; new Car() is necessary
        Car holden = new Car();
        System.out.println("Model is " + porsche.getModel());/*print before defining the model;
        will return null, since that is default state for a class and a string*/
        porsche.setModel("Carrera");
        System.out.println("Model is " + porsche.getModel());
    }
}
