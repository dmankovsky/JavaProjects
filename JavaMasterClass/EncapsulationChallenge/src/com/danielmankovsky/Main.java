package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {

        Printer printer = new Printer(50, true);

        printer.fillToner(10);
//        printer.fillToner(10);
        printer.printPages(17);
    }
}
