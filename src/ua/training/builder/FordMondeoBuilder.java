package ua.training.builder;

public class FordMondeoBuilder extends CarBuilder {
    @Override
    void buildMake() {
        car.setMake("Ford Mondeo");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);

    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeeed(260);

    }
}
