package ua.training.builder;

public class Car {
    String make;
    Transmission transmission;
    int maxSpeeed;

    public void setMake(String make) {
        this.make = make;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeeed(int maxSpeeed) {
        this.maxSpeeed = maxSpeeed;}

    @Override
    public String toString() {
        return "Car [make = " + make + ", transmission = " + transmission + ", maxSpeed = " + maxSpeeed + "]";
    }
}
