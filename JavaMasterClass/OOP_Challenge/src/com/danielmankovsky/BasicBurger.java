package com.danielmankovsky;


public class BasicBurger {
    private String breadType;
    private String meat;
    private int additionsAmount = 0;
    private double basicPrice;
    private Addition addition1;
    private Addition addition2;
    private Addition addition3;
    private Addition addition4;
    private double sumTotal;

    public void returnAdditions(){
        if (this.addition1 != null){
            System.out.println("Your first addition: " + addition1.getAdditName() + ", price: " + addition1.getAdditPrice());
        }
        if (this.addition2 != null){
            System.out.println("Your second addition: " + addition2.getAdditName() + ", price: " + addition2.getAdditPrice());
        }
        if (this.addition3 != null){
            System.out.println("Your third addition: " + addition3.getAdditName() + ", price: " + addition3.getAdditPrice());
        }
        if (this.addition4 != null){
            System.out.println("Your forth addition: " + addition4.getAdditName() + ", price: " + addition4.getAdditPrice());
        }
    }

    protected void setBasicPrice(double basicPrice) {
        this.basicPrice = basicPrice;
    }

    protected void setSumTotal(double sumTotal) {
        this.sumTotal = sumTotal;
    }

    public BasicBurger(String breadType, String meat) {
        this.breadType = breadType;
        this.meat = meat;
        this.basicPrice = 5.50;
        this.sumTotal = 5.50;
    }

    public double getBasicPrice() {
        return this.basicPrice;
    }

    public double getSumTotal() {
        return this.sumTotal;
    }

    class Addition {
        private String additName;
        private double additPrice = 1.10;

        public Addition(String additName) {
            this.additName = additName;
        }

        public String getAdditName() {
            return additName;
        }

        public double getAdditPrice(){
            return additPrice;
        }
    }

    public void getBurgerSummary(){
        System.out.println("The price for the basis burger is " + this.basicPrice);
        returnAdditions();
        System.out.println("The sum total is: " + Math.round(this.sumTotal * 100.00)/100.0);
    }

    public void addAdditions(String add1Name){
            this.addition1 = new Addition(add1Name);
            additionsAmount ++;
            this.sumTotal += this.addition1.getAdditPrice();
    }

    public void addAdditions(String add1Name, String add2Name){
        this.addition1 = new Addition(add1Name);
        additionsAmount ++;
        this.addition2 = new Addition(add2Name);
        additionsAmount ++;
        this.sumTotal += this.addition1.getAdditPrice();
        this.sumTotal += this.addition2.getAdditPrice();
    }

    public void addAdditions(String add1Name, String add2Name, String add3Name){
        this.addition1 = new Addition(add1Name);
        additionsAmount ++;
        this.addition2 = new Addition(add2Name);
        additionsAmount ++;
        this.addition3 = new Addition(add3Name);
        additionsAmount ++;
        this.sumTotal += this.addition1.getAdditPrice();
        this.sumTotal += this.addition2.getAdditPrice();
        this.sumTotal += this.addition3.getAdditPrice();
    }

    public void addAdditions(String add1Name, String add2Name, String add3Name, String add4Name){
        this.addition1 = new Addition(add1Name);
        additionsAmount ++;
        this.addition2 = new Addition(add2Name);
        additionsAmount ++;
        this.addition3 = new Addition(add3Name);
        additionsAmount ++;
        this.addition4 = new Addition(add4Name);
        additionsAmount ++;
        this.sumTotal += this.addition1.getAdditPrice();
        this.sumTotal += this.addition2.getAdditPrice();
        this.sumTotal += this.addition3.getAdditPrice();
        this.sumTotal += this.addition4.getAdditPrice();
    }


}


