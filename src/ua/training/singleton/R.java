package ua.training.singleton;

public class R implements Runnable {
    @Override
    public void run() {
        Singleton.getInstance();
    }
}
