package com.danielmankovsky;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {  //press "psvm" then "tab"
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit,"Sydney");
        addInOrder(placesToVisit,"Melbourne");
        addInOrder(placesToVisit,"Brisbane");
        addInOrder(placesToVisit,"Perth");
        addInOrder(placesToVisit,"Canberra");
        addInOrder(placesToVisit,"Adelaide");
        addInOrder(placesToVisit,"Darwin");

        printList(placesToVisit);

        addInOrder(placesToVisit,"Darwin");
        printList(placesToVisit);

        visit(placesToVisit);
/*
        printList(placesToVisit); //printList will accept LinkedList as parameter and be using concept of ITERATOR!!!!

        placesToVisit.add(1,"Alice Springs");

        printList(placesToVisit);

        placesToVisit.remove(4);
        printList(placesToVisit);
*/
        //all above was also possible with arraylist; so nothing new
        //now we will add functionality to check: every time an item is added, it is added in alphabetical order
        //we'll be using List Iterator, similar to iterator, but gives more flexibility; is perfect for such tasks as adding items and sorting etc.
        //see method addInOrder below

    }

    private static void printList(LinkedList<String> linkedList){
        //iterator is another way of accessing and going through elements of array or list
        Iterator<String> i = linkedList.iterator(); //method iterator is part of LinkedList, comes with it
        //here we are doing equivalent of for loop
        while (i.hasNext()){//i.hasNext checks whether next element exists
            System.out.println("Now visiting " + i.next());  //= while element is pointing at sth/there exists the next element, show current record and go on
            //will show actual current value before moving on
        //i.next changes value of iterator; equivalent to i++
        }
        System.out.println("==============================");
    }


//    Now I just wanna make a point that writing methods with side effects
//
//    such as using .next is generally to be avoided.
//
//    So unless you really know what you're doing,
//
//    it's not a good idea to write a method that both returns a value and
//
//    changes the object that it's called from.

    private static boolean addInOrder (LinkedList<String> linkedList, String newCity){
        ListIterator<String> stringListIterator = linkedList.listIterator(); //just a setup; not pointing anywhere; only at .next() it goes to first record
        // and starts pointing

        while (stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareTo(newCity); //compareTo gives a number: 0 - both are equal;
            if (comparison == 0){
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if (comparison > 0) {//then new item should appear before existing one
                //problem: we used .next(). so we returned the current item, checked alphabet order and moved on; to insert item before existing one
                // (if comparison > 0), we need to move one item back
                //cool thing: linked list in java stores linkes both to the next and to the previous element; that's why you can go back in list
                stringListIterator.previous();//go back to the previous match / record that's linked to this one
                stringListIterator.add(newCity);
                return true;
                //in common iterator you cannot go back; here you can; cool
            } else if (comparison < 0){
                //move on next city; nothing to do, already moved to the next, so just add a new item to the end of the list
            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit (LinkedList<String> cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;//variable that solves the problem with coming to the previous item
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()){ //update all the videos afterwards; here mistake; == comparison ever works for strings, so use .isEmpty
            System.out.println("No cities in the itinerary.");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine(); //cleans input line after nextInt()
            switch (action) {
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;
                case 1:
                if (!goingForward){
                    if (listIterator.hasNext()){
                        listIterator.next();
                    }
                    goingForward = true;
                }
                if (listIterator.hasNext()){
                    System.out.println("Now visiting " + listIterator.next());
                } else {
                    System.out.println("Reached the end of the list");
                    goingForward = false;
                }
                    break;
                case 2:
                    if (goingForward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward=false;
                    }
                    if (listIterator.hasPrevious()){ //for previous exists as well
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }

    }

    private static void printMenu(){
        System.out.println("Available actions:\n press ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print menu options");
    }
//algorithms were developed to detect loops in linked list structures; example: Tortoise and the Hare algorithm
    //we need to keep track of which direction we are going and allow for the in-between nature of the iterator
}
