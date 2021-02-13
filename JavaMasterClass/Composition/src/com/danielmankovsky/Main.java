package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(25,45,34);
        Case theCase = new Case ("AAA","asus","240",dimensions);
        Monitor theMonitor = new Monitor ("skldfns", "dell","middle",new Resolution(2540,1440) );
        Motherboard theMotherboard = new Motherboard("daslfjnlsaf","gigabyte",8,5,"skjfg");

        PC thePC = new PC(theCase,theMonitor,theMotherboard);
        thePC.powerUp();
    }
}
