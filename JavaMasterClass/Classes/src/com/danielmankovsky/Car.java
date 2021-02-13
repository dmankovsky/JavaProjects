package com.danielmankovsky;

public class Car {
    private int doors; //the state component for a car
    private int wheels;
    private String model;
    private String engine;
    private String colour;

    public void setModel(String model){
        String validModel = model.toLowerCase();
        if (validModel.equals("carrera")||validModel.equals("commodore")) {
            this.model = model;
        } else{
            this.model= "Unknown";
        }
    }
    public  String getModel(){
        return this.model; // when typing this. a dropdown comes up; f there stands for field, m for method
        //padlock in the dropdown is saying the thing is open/public or closed/private
    }


}
