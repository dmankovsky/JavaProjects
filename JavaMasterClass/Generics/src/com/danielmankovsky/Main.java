package com.danielmankovsky;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    ArrayList <Integer> items = new ArrayList<>();  // can contain anything, not just integer as here
	    items.add(1);
        items.add(2);
        items.add(3);
//        items.add("dan");
        items.add(4);
        items.add(5);

        printDoubled(items);
    }

    public static void printDoubled(ArrayList<Integer> n){
        for (int i : n){ //before using Generics, were saying Object i, now Integer. And now we know what data type we are using
            //System.out.println((Integer) i * 2); getting rid of the cast in brackets - will recognize the data type automatically:
            System.out.println(i*2);
        }
    }
}
