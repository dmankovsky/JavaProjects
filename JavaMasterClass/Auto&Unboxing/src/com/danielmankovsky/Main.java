package com.danielmankovsky;

import java.util.ArrayList;

class IntClass {
    private int myValue;

    public IntClass (int myValue){
        this.myValue = myValue;
    }

    public int getMyValue(){
        return myValue;
    }

    public void setMyValue (int myValue){
        this.myValue = myValue;
    }
}

public class Main {

    public static void main(String[] args) {
	    String [] strArray = new String[10];
	    int[] intArray = new int [10];

        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("Dan");

        //ArrayList<int> intArrayList = new ArrayList<int>();
        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(4738));


        Integer integer = new Integer(4738); // Integer is a class in its own right, as opposed to int
        Double doubleValue = new Double (343.2398);

        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();

        for (int i = 0; i<=10;i++){
            integerArrayList.add(Integer.valueOf(i));//taking value of i as primitive type and convert to Integer; thats autoboxing
        }

        for (int i = 0; i<=10;i++){
            System.out.println(i + " --> " + integerArrayList.get(i);//.intValue()); //intValue converts back to primitive type; thats unboxing
        }

        Integer myIntValue = 56; //why is it working? java when compiling the code executes actually the folllowing (doing the hard work for you):
        //Integer myIntValue = Integer.valueOf(56);

        int myInt = myIntValue;//Java is actually doing the following (to fix the mismatch between Integer and int):
        //int myInt =  myIntValue.intValue();

        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for (double dbl = 0.0;dbl <=10.0;dbl+=0.5){
            myDoubleValues.add(Double.valueOf(dbl));
        }

        for (int i =0; i<myDoubleValues.size();i++){
            double value = myDoubleValues.get(i);//.doubleValue();
            System.out.println(i + "-->" + value);
        }
    }



}
