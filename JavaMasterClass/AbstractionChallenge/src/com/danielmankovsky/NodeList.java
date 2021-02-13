package com.danielmankovsky;

public interface NodeList {
    MyListItem getRoot();
    boolean addItem(MyListItem item);
    boolean removeItem(MyListItem item);
    void traverse(MyListItem root); // start at the root and print all elements of the structure
}

