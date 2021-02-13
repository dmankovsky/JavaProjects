package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {
        //width of int is 32 (4 bytes)
	int myIntValue =5/3;
	    //width of float is 32 (4 bytes)
	float myFloatValue = 5F/3f;
	    //width of float is 64 (8 bytes)
	double myDoubleValue =5d/3d;
        System.out.println("myIntValue =" + myIntValue);
        System.out.println("myFloatValue =" + myFloatValue);
        System.out.println("myDoubleValue =" + myDoubleValue);


        double NoKg = 54.34;
        double NoPo = NoKg * 0.45359237;
        System.out.println("no in pounds is " + NoPo);

    }
}
