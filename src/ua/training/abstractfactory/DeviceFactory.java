package abstractfactory;

public interface DeviceFactory {
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}
