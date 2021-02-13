package com.danielmankovsky;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean isDuplex;

    public Printer(int tonerLevel, boolean isDuplex) {
        if (tonerLevel > -1 && tonerLevel >= 100) {
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1;
        }
        this.isDuplex = isDuplex;
        this.pagesPrinted = 0;
    }

    public void fillToner(int percentageFilled){
        if (this.tonerLevel+percentageFilled <=100){
            this.tonerLevel=this.tonerLevel+percentageFilled;
            System.out.println("Toner filled. New level: " + this.tonerLevel);
        } else if (this.tonerLevel+percentageFilled > 100){
            System.out.println("Too much toner filled in. Max fill available: " + (100-this.tonerLevel) + "%.");
        }
    }

    public void printPages (int pagesToPrint){
        if (isDuplex==true){
            if (pagesToPrint%2==0){
            this.pagesPrinted=this.pagesPrinted+pagesToPrint/2;
            System.out.println(pagesPrinted + " pages printed.");
            } else if (pagesToPrint%2 > 0){
                this.pagesPrinted=this.pagesPrinted+pagesToPrint/2+1;
                System.out.println(pagesPrinted + " pages printed.");
            }
        } else {this.pagesPrinted=this.pagesPrinted+pagesToPrint;
            System.out.println(pagesPrinted + " pages printed.");
        }
    }

}


