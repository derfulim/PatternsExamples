package ua.training.templatemethod;

public class TemplateMethodApp {
    public static void main(String[] args) {
        C a = new A();
        C b = new B();
        a.templateMethod();
        b.templateMethod();
    }

}

abstract class C{
    public void templateMethod() {
        System.out.print(1);
        differ();
        System.out.print(3);
        differ2();
        System.out.println();
    }

    abstract void differ();
    abstract void differ2();
}
class A extends C {
    @Override
    void differ() {
        System.out.print(2);
    }

    @Override
    void differ2() {
        System.out.print("A");
    }
}

class B extends C{
    @Override
    void differ() {
        System.out.print(4);
    }

    @Override
    void differ2() {

    }
}
