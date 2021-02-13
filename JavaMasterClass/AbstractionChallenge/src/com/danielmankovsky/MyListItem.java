package com.danielmankovsky;

public abstract class MyListItem {

    protected Object value;  // protected will allow access from the concrete subclass. If leave access modifier empty,
    // by default private (same package will have access, but not other packages)
    protected MyListItem previousValue = null;
    protected MyListItem nextValue = null;

    public MyListItem(Object value) {
        this.value = value;
    }

    abstract MyListItem moveToNext();
    abstract MyListItem moveToPrevious();

    abstract MyListItem setPrevious (MyListItem previousValue);
    abstract MyListItem setNext(MyListItem nextValues);

    abstract int compareTo(MyListItem inputItem);

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
