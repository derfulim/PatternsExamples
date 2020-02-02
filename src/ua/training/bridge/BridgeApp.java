package ua.training.bridge;

public class BridgeApp {
    public static void main(String[] args) {
        Car c = new Coupe(new Mercedes());
        c.showDetails();
    }
}

abstract class Car{
    Make make;
    public Car(Make make) {
        this.make = make;
    }
    abstract void showType();
    public void showDetails() {
        showType();
        make.setMake();
    }
}

class Sedan extends Car{
    public Sedan(Make make){
        super(make);
    }

    @Override
    void showType() {
        System.out.println("Sedan");
    }
}
class Coupe extends Car{
    public Coupe(Make make){
        super(make);
    }

    @Override
    void showType() {
        System.out.println("Coupe");
    }
}

class Hatchback extends Car{
    public Hatchback(Make make) {
        super(make);
    }

    @Override
    void showType() {
        System.out.println("Hathcback");
    }
}

interface Make{
    void setMake();
}

class Kia implements Make{
    @Override
    public void setMake() {
        System.out.println("KIA");
    }
}

class Skoda implements Make{
    @Override
    public void setMake() {
        System.out.println("Skoda");
    }
}
class Mercedes implements Make{
    @Override
    public void setMake() {
        System.out.println("Mercedes");
    }
}