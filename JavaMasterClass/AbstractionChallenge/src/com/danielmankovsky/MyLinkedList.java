package com.danielmankovsky;

public class MyLinkedList implements NodeList {
    private MyListItem root = null;

    public MyLinkedList(MyListItem root) {
        this.root = root;
    }

    @Override
    public MyListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(MyListItem newItem) {
        if(this.root == null) {
            // The list was empty, so this item becomes the head of the list
            this.root = newItem;
            return true;
        }

        MyListItem currentItem = this.root;
        while(currentItem != null) {
            int comparison = (currentItem.compareTo(newItem));
            if(comparison <0) {
                // newItem is greater, move right if possible
                if(currentItem.moveToNext() != null) {
                    currentItem = currentItem.moveToNext();
                } else {
                    // there is no next, so insert at end of list
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            } else if(comparison >0) {
                // newItem is less, insert before
                if(currentItem.moveToPrevious() != null) {
                    currentItem.moveToPrevious().setNext(newItem).setPrevious(currentItem.moveToPrevious());
                    newItem.setNext(currentItem).setPrevious(newItem);
                } else {
                    // the node with a previous is the root
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                // equal
                System.out.println(newItem.getValue() + " is already present, not added.");
                return false;
            }
        }

        return false;

    }

    @Override
    public boolean removeItem(MyListItem item) {
        if (item!=null){
            System.out.println("Deleting item " + item.getValue());
        }
        MyListItem currentItem = this.root;
        while (currentItem != null){
            int comparison = currentItem.compareTo(item);
            if(comparison == 0){
                //found item to delete
                if (currentItem == this.root){
                    this.root = currentItem.moveToNext();
                } else
                {
                    currentItem.moveToPrevious().setNext(currentItem.moveToNext());
                    if (currentItem.moveToNext() != null){
                        currentItem.moveToNext().setPrevious(currentItem.previousValue);
                    }
                }
                return true;
            } else if (comparison < 0){
                currentItem = currentItem.moveToNext();
            } else {
                //We are at an item greater than the one to be deleted
                //so the item if not in the list
                return false;
            }
        }
        // We have reached the end of the list
        // without finding the item to delete
        return false;
    }

    @Override
    public void traverse(MyListItem root) {
        if (root == null){
            System.out.println("The list is empty.");
        } else {
            while (root != null){
                System.out.println(root.getValue());
                root = root.moveToNext();
            }
        }
    }
}
