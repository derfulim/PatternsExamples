package ua.training.singleton;

public class Singleton {
    public static int counter = 0;
    private static volatile Singleton instance = null;
    private Singleton() {
        counter++;
    }

//    public static synchronized Singleton getInstance() {
//        if(instance == null){
//            instance = new Singleton();}
//
//        return instance;
//    }

    public static  Singleton getInstance() {
        if(instance == null){
            synchronized (Singleton.class){
                if (instance==null) {instance = new Singleton();}
            }
        }

        return instance;
    }

//    public static Singleton getInstance(){
//        return instance;
//    }


}
