public class Outlander extends Car {

    private int roadServiceMonths;

    public Outlander (int roadServiceMonths){
        super ("Outlander","large",5,4,5,false );
                this.roadServiceMonths=roadServiceMonths;
    }

    public void accelerate (int rate){
        int newVelocity=getCurrentVelocity()+rate;
        if (newVelocity==0){
            stop();
        } else if (newVelocity>0 && newVelocity<=10){
            changeGear(1);
        }else if (newVelocity >10 && newVelocity <=20){
            changeGear(2);
        }else {
            changeGear(3);
        }
        if (newVelocity>0){
            changeVelocityAndDirection(newVelocity,getCurrentDirection());
        }
    }

}
