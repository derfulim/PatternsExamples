package ua.training.builder;

public class BuilderApp {
    public static void main(String[] args) {
//    Car car = new CarBuilder().buildMake("Mercedes").
////            buildTransmission(Transmission.AUTO).
//            buildMaxSpeed(280).build();
//        System.out.println(car);}
        Director director = new Director();
        director.setBuilder(new FordMondeoBuilder());
        Car car = director.buildCar();
        System.out.println(car);

    }
}
