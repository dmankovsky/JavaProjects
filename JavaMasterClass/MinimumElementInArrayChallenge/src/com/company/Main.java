package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //readElements(3);
        int[]abs = {1,2,3,4};
        reverse(abs);
    }

    private static int readInteger(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        return n;
    }

    private static int[] readElements(int n){
        Scanner sc = new Scanner(System.in);

        int[]array = new int[n];

        for (int i = 0; i < n; i++){
            array[i] = sc.nextInt();
            sc.nextLine();
        }
        return array;
    }

    private static int findMin(int[] inputArray){
        int min = inputArray[0];
        for (int i = 1; i<inputArray.length; i++){
            if (inputArray[i]< min){
                min = inputArray[i];
            }
        }
        return min;
    }

    private static void reverse(int[]inputArray){
        int [] outputArray;
        outputArray = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++){
            outputArray[inputArray.length-i-1] = inputArray[i];
        }
        for (int i = 0; i < inputArray.length; i++){
            System.out.println(outputArray[i]);
        }
        System.out.println("Array = " + Arrays.toString(inputArray));
        System.out.println("Reversed array = " + Arrays.toString(outputArray));
    }

}
