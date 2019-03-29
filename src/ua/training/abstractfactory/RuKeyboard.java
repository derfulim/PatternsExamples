package abstractfactory;

public class RuKeyboard implements Keyboard {
    public RuKeyboard() {
        super();
    }

    @Override
    public void print() {
        System.out.println("Печатаем строку");

    }

    @Override
    public void println() {
        System.out.println("Печатаем строку с переводом строки");
    }
}
