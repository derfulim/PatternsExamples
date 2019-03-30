package ua.training.observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ObserverApp {
    public static void main(String[] args) {

        Observed station = new MeteoStation();
        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());
        ((MeteoStation) station).setMeasurements(25, 760);
        ((MeteoStation) station).setMeasurements(-5, 745);

    }
}

interface Observed{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyobservers();
}

class MeteoStation implements Observed {
    int temperature;//Наблюдаемый имеет и меняет свое состояние и посылает это изменение своим подписчикам, а медиатор нет
    int pressure;

    List<Observer> observers = new ArrayList<>(); //имеет коллекцию подписчиков и не делает различий между ними

    public void setMeasurements(int t,int p) { //наблюдаемый изменяет состояние и рассылает свое изменившееся состояние подписчикам
        temperature = t;
        pressure = p;
        notifyobservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);

    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyobservers() {
        for (Observer o:observers) {
            o.handleEvent(temperature, pressure);
        }
    }
}

interface Observer{
    void handleEvent(int temp, int presser); //наблюдатели могут только принимать сообщения
}

class ConsoleObserver implements Observer{
    public void handleEvent(int temp, int pressure) {
        System.out.println("Погода изменилась. Температура = " + temp + ", Давление = " + pressure + "." );
    }
}

class FileObserver implements Observer{


    @Override
    public void handleEvent(int temp, int pressure) {
        File f;
        try{
            f = File.createTempFile("TempPressure", "_txt");
            PrintWriter pw = new PrintWriter(f);
            pw.println("Погода изменилась. Температура = " + temp + ", Давление = " + pressure + "." );
            pw.println();
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
