package ua.training.delegate;

public class DelegateApp {
    public static void main(String[] args) {
//        A a = new A();
////        a.f();

        Painter painter = new Painter();
        painter.setGraphics(new Circle());
        painter.draw();
    }
}
