package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//            getIntegers(5);
            int[]abs = new int[] {2,3,4,5,1};
//            printArray(abs);
            sortIntegers(abs);
        }


        public static int [] getIntegers(int amountOfelements){
            Scanner scanner = new Scanner(System.in);
            //System.out.println("Enter " + amountOfelements + " elements");

            int [] newArray = new int[amountOfelements];
            for (int i = 0; i < amountOfelements; i++){
                newArray[i] = scanner.nextInt();
                scanner.nextLine();
            }
            return newArray;
    }

    public static void printArray(int[] inputArray){
        for (int i = 0; i < inputArray.length; i++){
            System.out.println("Element " + i + " contents " + inputArray[i]);
        }
    }

    public static int [] sortIntegers(int[] inputArray){
        int[]outputArray = inputArray;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < outputArray.length-1; i++) {
                if (outputArray[i] < outputArray[i+1]){
                    int temp = outputArray[i];
                    outputArray[i] = outputArray[i+1];
                    outputArray[i+1] = temp;
                    flag = true;
                }
            }
        }
             for (int i = 0; i< outputArray.length;i++){
            System.out.println(outputArray[i]);
        }
        return outputArray;
    }


}
