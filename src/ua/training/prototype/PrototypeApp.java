package ua.training.prototype;

public class PrototypeApp {
    public static void main(String[] args) {
        Human original = new Human(18, "Vasya");
        System.out.println(original);

        Human copy = (Human) original.copy();
        System.out.println(copy);

        HumanFactory factory = new HumanFactory(copy);
        Human h1 = factory.makeCopy();
        System.out.println(h1);

        factory.setPrototype(new Human(30, "Valeria"));
        Human hw = factory.makeCopy();
        System.out.println(hw);
    }
}
