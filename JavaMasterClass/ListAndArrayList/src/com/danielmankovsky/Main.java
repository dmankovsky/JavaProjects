package com.danielmankovsky;

//import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

 //   private static Scanner s = new Scanner(System.in);
 //   private static int[] baseData = new int[10];

    private static Scanner scanner = new Scanner(System.in);
    public static GroceryList groceryList = new GroceryList();


    public static void main(String[] args) {
   /*     System.out.println("Enter 10 integers:");
        getInput();
        printArray(baseData);
        resizeArray();
        System.out.println("Enter 12 integers:");
        getInput();
        printArray(baseData);
    }

    private static void getInput(){
        for (int i = 0; i < baseData.length; i++){
            baseData[i] = s.nextInt();
        }
    }

    private static void printArray(int[] arr){
        for (int i = 0; i< arr.length; i++)
            System.out.println(arr[i] + " ");
        //System.out.println(); //???
    }

    private static void resizeArray(){
        int[] original = baseData;

        baseData = new int[12];
        for (int i = 0; i < original.length; i++)
            baseData[i] = original[i];
    }
*/

    boolean quit = false;
    int choice = 0;
    printInstructions();
        while (!quit) { //while not quit - we continue processing until the user decides to quit
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }

    }

    public static void printInstructions (){
        System.out.println("\nPress ");
        System.out.println("\t0 - To print choice options.");
        System.out.println("\t1 - To print the list of grocery items.");
        System.out.println("\t2 - To add an item to the list.");
        System.out.println("\t3 - To modify an item in the list.");
        System.out.println("\t4 - To remove an item from the list.");
        System.out.println("\t5 - To search for an item in the list.");
        System.out.println("\t6 - To quit the application.");
    }

    public static void addItem(){
        System.out.println("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }


    public static void modifyItem(){
        System.out.println("Enter current item name: ");
        String itemNumber = scanner.nextLine();
        System.out.println("Enter new item name: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNumber,newItem);
    }

    public static void removeItem(){
        System.out.println("Enter the item name to remove: ");
        String itemNumber = scanner.nextLine();
        groceryList.removeGroceryItem(itemNumber);
    }

    public static void searchForItem(){
        System.out.println("Item to search for: ");
        String searchItem = scanner.nextLine();
        if(groceryList.onFile(searchItem)){
            System.out.println("Found "+ searchItem + " in the grocery list.");
        } else {
            System.out.println(searchItem + " is not in the shopping list.");
        }
    }

    public static void processArrayList(){
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList()); //copy an array to another, faster than a for loop for every element
        ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());//insert one array into another when the later is created

        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }

}

