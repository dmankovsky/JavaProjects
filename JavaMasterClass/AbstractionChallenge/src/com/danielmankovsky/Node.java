package com.danielmankovsky;

public class Node extends MyListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    MyListItem setPrevious(MyListItem previousValue) {
        this.previousValue=previousValue;
        return this.previousValue;
    }

    @Override
    MyListItem setNext(MyListItem nextValues) {
        this.nextValue = nextValues;
        return this.nextValue;
    }

    @Override
    MyListItem moveToNext() {
        return this.nextValue;
    }

    @Override
    MyListItem moveToPrevious() {
        return this.previousValue;
    }

    @Override
    int compareTo(MyListItem inputItem) {
        if (inputItem != null){
            return ((String) super.getValue()).compareTo((String)inputItem.getValue()); // String has its own compareTo method. If not use String, would have
            //to create own compareTo method
        } else {
            return -1;
        }
    }
}
