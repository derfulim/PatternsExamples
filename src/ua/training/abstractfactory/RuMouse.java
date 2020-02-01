package ua.training.abstractfactory;


public class RuMouse implements Mouse {
    public RuMouse() {
        super();
    }

    @Override
    public void click() {
        System.out.println("Щелчок мышью");
    }

    @Override
    public void dblclick() {
        System.out.println("Двойной щелчок мышью");

    }

    @Override
    public void scroll(int direction) {
        if (direction>0) {
            System.out.println("Скроллим вверх");
        }
        else if (direction<0) {
            System.out.println("Скроллим вниз");
        }
        else System.out.println("Не скроллим");
    }
}
