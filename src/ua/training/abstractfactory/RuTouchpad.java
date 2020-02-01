package ua.training.abstractfactory;


public class RuTouchpad implements Touchpad {
    public RuTouchpad() {
        super();
    }

    @Override
    public void track(int deltaX, int deltaY) {
       int s = (int) Math.sqrt(Math.pow(deltaX,2)+Math.pow(deltaX,2));
        System.out.println("Передвинулись на " + s + " пикселей");
    }
}
