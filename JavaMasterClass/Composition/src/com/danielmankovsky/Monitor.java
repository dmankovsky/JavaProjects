package com.danielmankovsky;

public class Monitor {
    private String Model;
    private String manufacturer;
    private String size;
    private Resolution nativeResolution;

    public Monitor(String model, String manufacturer, String size, Resolution nativeResolution) {
        Model = model;
        this.manufacturer = manufacturer;
        this.size = size;
        this.nativeResolution = nativeResolution;
    }

    public void drawPixelAt (int x, int y, String colour){
        System.out.println("Draw at " + x + "," + y + "," + " in colour " + colour);
    }

    public String getModel() {
        return Model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getSize() {
        return size;
    }

    public Resolution getNativeResolution() {
        return nativeResolution;
    }
}
