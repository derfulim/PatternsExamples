package ua.training.prototype;

public class Human implements CopyAble {
    int age;
    String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }


    @Override
    public Object copy() {
        Human copy = new Human(age,name);
        return copy;
    }

    @Override
    public String toString() {
        return "Human [age = " + age + ", name = " + name + "]";
    }
}
