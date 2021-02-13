package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {
        //int has a width of 32
	int myMinValue = -2_147_483_648;
	int myMaxValue = 2_147_483_647;
	int myTotal=(myMinValue/2);
        System.out.println("myTotal =" + myTotal);

	//byte has a width of 8
	byte myByteValue = 10;
	byte myNewByteValue = (byte) (myByteValue/2);
        System.out.println("myNewByteValue =" + myNewByteValue);

	//short has a width of 16; all those datatypes work with integers
	short myShortValue = 32767;

	//long has a width of 64; can store 2 to the power 63
	long myLongValue = 100L;


	byte newByte = 12;
	short newShort = 19;
	int newInt =22;
	long newLong = 50000 + 10*(newByte + newShort + newInt);
        System.out.println("newLong =" + newLong);

        int newValue = 50;
        if (newValue == 50)
			System.out.println( "This is true");

        boolean isCar = false;
        if (isCar == true)
			System.out.println("This is not supposed to happen");

        isCar = true;
        boolean wasCar = isCar ? true : false;
        if (wasCar)
			System.out.println("WasCar is true");

		double value1 = 20;
		double value2 = 80;
		double result1 = (value1 + value2)*25;
		System.out.println("Remainder:" + result1%40);

		if (result1%40 <= 20)
			System.out.println("Total was over the limit");
	}
}
