package com.danielmankovsky;

public class HealthyBurger extends BasicBurger  {
        private Addition addition5;
        private Addition addition6;


    public HealthyBurger(String meat) {
        super("brown rye", meat);
    }

    @Override
    public void returnAdditions() {
        super.returnAdditions();
        if (this.addition5 != null){
            System.out.println("Your fifth addition: " + addition5.getAdditName() + ", price: " + addition5.getAdditPrice());
        }
        if (this.addition6 != null){
            System.out.println("Your sixth addition: " + addition6.getAdditName() + ", price: " + addition6.getAdditPrice());
        }
    }

    public void addAdditions(String add1Name, String add2Name, String add3Name, String add4Name, String add5Name) {
        super.addAdditions(add1Name, add2Name, add3Name, add4Name);
        this.addition5 = new Addition(add5Name);
        super.setSumTotal(super.getSumTotal() + addition5.getAdditPrice());
    }

    public void addAdditions(String add1Name, String add2Name, String add3Name, String add4Name, String add5Name, String add6Name) {
        super.addAdditions(add1Name, add2Name, add3Name, add4Name);
        this.addition5 = new Addition(add5Name);
        this.addition6 = new Addition(add6Name);
        super.setSumTotal(super.getSumTotal() + this.addition5.getAdditPrice() + this.addition6.getAdditPrice());
    }

}
