package com.danielmankovsky;

public class Main {

    public static void main(String[] args) {
        Itelephone dansPhone; // not Desktop dansphone, would not work this way.
        dansPhone = new DeskPhone(123456);
        dansPhone.powerOn();
        dansPhone.callPhone(123456);
        dansPhone.answer();

        dansPhone = new MobilePhone(24565);
        dansPhone.powerOn();
        dansPhone.callPhone(24565);
        dansPhone.answer();



    }
}
