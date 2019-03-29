package ua.training.chainofresponsibility;

public class ChainApp {
    public static void main(String[] args) {
        Logger logger = new SMSLogger((Level.ERROR));
        Logger flogger = new FileLogger((Level.DEBUG));
        Logger emailLogger = new EmailLogger(Level.INFO);
        logger.setNext(flogger);
        flogger.setNext(emailLogger);
        logger.writeMessage("Все хорошо",Level.INFO);
        logger.writeMessage("Отладка",Level.DEBUG);
        logger.writeMessage("Система упала",Level.ERROR);

    }
}

class Level{
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

abstract class Logger{
    int priority;
    Logger next;

    public Logger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    public void writeMessage(String message, int level) {
        if (level<=priority) {
            write(message);
        }
        if(next!=null) {
            next.writeMessage(message, level);
        }
    }

    public void write(String message) {
        System.out.println(message);
    }




}

class SMSLogger extends Logger {

    public SMSLogger(int priority) {
        super(priority);
    }

    public void write(String message) {
        System.out.println("SMS: " + message);
    }
}

class FileLogger extends Logger {

    public FileLogger(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Записываем в файл: " + message);
    }
}

class EmailLogger extends Logger {

    public EmailLogger(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Отправляем на почту: " + message);
    }
}
