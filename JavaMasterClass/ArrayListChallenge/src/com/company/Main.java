package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ContactList myContactList = new ContactList("123412-1234-1234");

    public static void main(String[] args) {
        boolean quit = false;
        printActions();
        while(!quit){
            System.out.println("\nEnter action: (6 to show available options)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Shutting down");
                    quit = true;
                    break;
                case 1:
                    myContactList.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }


        }



    }


    public static void printActions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shutdown\n" +
                "1 - to print contacts\n" +
                "2 - to add a new contact\n" +
                "3 - to update existing contact\n" +
                "4 - to remove a contact\n" +
                "5 - query if an existing contact exists\n" +
                "6 - to print a list of available actions."
                );
        System.out.println("Choose your action:");
    }

    private static void addNewContact(){
        System.out.println("Enter new contact name:");
        String newName = scanner.nextLine();
        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();
        Contact contact = new Contact(newName,phoneNumber);
        if (myContactList.addContact(contact)){
            System.out.println("New contact added");
        } else {
            System.out.println("Contact is already on the list");
        }
    }

    private static void updateContact(){
        System.out.println("Enter existing contact name:");
        String name = scanner.nextLine();
        Contact existingContact = myContactList.queryContact("name");
        if (existingContact == null){
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new contact name");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number:");
        String newNumber = scanner.nextLine();
        Contact newContact = new Contact(newName,newNumber);
        if (myContactList.updateContact(existingContact,newContact)){
            System.out.println("Successfully updated");
        } else {
            System.out.println("Error updating records");
        }
    }

    private static void removeContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = myContactList.queryContact(name);
        if (existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }
        if(myContactList.removeContact(existingContactRecord)){
            System.out.println("Contact successfully deleted");
        } else{
            System.out.println("Error deleting contact");
        }
    }

    private static void queryContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = myContactList.queryContact(name);
        if (existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName() + ", phone number: " + existingContactRecord.getPhoneNumber() + ".");
    }


}
