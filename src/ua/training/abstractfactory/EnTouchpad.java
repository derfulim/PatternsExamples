package abstractfactory;

public class EnTouchpad implements Touchpad {
    public EnTouchpad() {
        super();
    }

    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX,2)+Math.pow(deltaX,2));
        System.out.println("Moved " + s + " pixels");
    }
}

