public class Car extends Vehicle {

    public int wheels;
    public int doors;
    public int gears;
    private boolean isManual;

    private int currentGear;

    public Car(String name, String size, int wheels, int doors, int gears, boolean isManual) {
        super(name, size);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.isManual = isManual;
        this.currentGear = 1;
    }

    public void changeGear (int gear){
        this.currentGear=gear;
        System.out.println("Car.setGear(): switch gear to " + gear);
    }

    public void changeVelocityAndDirection (int speed, int direction){
        move (speed, direction);
        System.out.println("Change velocity to " + speed + " and direction to "+ direction);
    }

}
