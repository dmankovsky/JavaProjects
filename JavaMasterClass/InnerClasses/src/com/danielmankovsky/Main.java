package com.danielmankovsky;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner (System.in);
    private static Button btnPrint = new Button ("Print");

    public static void main(String[] args) {

        Gearbox mcLaren = new Gearbox (6);
//        Gearbox.Gear first = mcLaren.new Gear (1, 12.3); //since Gear is an inner class to Gearbox, it must be instantiated separately and explicitly
//        System.out.println(first.driveSpeed(1000));

        //Gearbox.Gear second = new Gearbox(2,15.4); would not work
        //Gearbox.Gear third = new mcLaren.Gear(3,17.8); would not work either

        // watch the first Gear creation and mind the syntax (first create the outer class, then the gear itself)

        //lines 8 to 9 were commented out following the course instructions and after the changes in gearbox class were made

    //    mcLaren.addGear(1,5.3);
    //    mcLaren.addGear(2,10.6);
    //    mcLaren.addGear(3,15.9);
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000));



 /*       class ClickListener implements Button.OnClickListener{
            public ClickListener(){
                System.out.println("I've been attached.");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked.");
            }
        }
        btnPrint.setOnClickListener(new ClickListener());*/
        btnPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked.");
            }
        });
        listen();
    }

    private static void listen(){
        boolean quit = false;
        while (!quit){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
            }
        }
    }
}
