package ua.training.singleton;

public class SingletonApp {
    public static void main(String[] args) throws InterruptedException {

        final int SIZE = 1000;
//        Singleton arr[] = new Singleton[SIZE];

        Thread t[] = new Thread[SIZE];

        for (int i = 0; i<SIZE; i++) {
        t[i] = new Thread(new R());
        t[i].start();
        }
        for (int i = 0; i<SIZE; i++) {
        t[i].join();
        }

        System.out.println(Singleton.counter);


    }
}
