package ua.training.abstractfactory;


public class EnKeyboard implements Keyboard {
    public EnKeyboard() {
        super();
    }

    @Override
    public void print() {
        System.out.println("Print line");

    }

    @Override
    public void println() {
        System.out.println("Print new line");
    }
}


