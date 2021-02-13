package com.company;

import java.util.ArrayList;

public class ContactList {
    private String myPhoneNumber;
    private ArrayList<Contact> myContacts;

    public ContactList(String myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber;
        this.myContacts = new ArrayList<Contact>();
    }


    public boolean addContact(Contact newContact){
        if (findContact(newContact.getName())>=0){
            System.out.println("Contact already on the list");
            return false;
        } else {
            myContacts.add(newContact);
            return true;
        }
    }

    public void printContacts(){
        for (int i = 0; i < myContacts.size();i++){
            System.out.println((i + 1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        if (findContact(oldContact)<0){
            System.out.println(oldContact.getName() + " was not found");
            return false;
        } else if (findContact(newContact.getName()) != -1){
            System.out.println("Update failed. Contact already exists");
            return false;
        } else {
            this.myContacts.set(findContact(oldContact),newContact);
            System.out.println("Contact " + oldContact.getName() + " was updated with " + newContact.getName());
            return true;
        }
    }


    private int findContact(Contact contactToCheck){
        return myContacts.indexOf(contactToCheck);
    }

    private int findContact(String contactName){
        for (int i = 0; i < this.myContacts.size();i++){
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contact contact){
        if(findContact(contact)>=0){
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact (String contactName){
        int position = findContact(contactName);
        if (position>=0){
            return this.myContacts.get(position);
        } else {
            return null;
        }
    }

    public boolean removeContact(Contact contact){
        if (findContact(contact.getName())>=0){
            myContacts.remove(contact);
            System.out.println("Contact " + contact.getName() + " deleted successfully");
            return true;
        } else {
            System.out.println("Contact " + contact.getName() + " not found");
            return false;
        }
    }

}
