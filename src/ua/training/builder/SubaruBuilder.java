package ua.training.builder;

public class SubaruBuilder extends CarBuilder {
    @Override
    void buildMake() {
        car.setMake("Subaru");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);

    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeeed(320);

    }
}