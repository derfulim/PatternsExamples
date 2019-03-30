package ua.training.state;

public class StateApp {
    public static void main(String[] args) {
//        Station dfm = new RadioDFM();
//        Radio radio = new Radio();
//        radio.setStation(dfm);
//
//        for (int i = 0; i < 10; i++) {
//            radio.nextStation();
//            radio.play();
//        }

        Human human = new Human();
        human.setState(new Work());
        for (int i = 0; i <10 ; i++) {
            human.doSomething();
        }
    }
}

interface Station {
    void play();
}

class Radio7 implements  Station {
    @Override
    public void play() {
        System.out.println("Radio 7");
    }
}
    class RadioDFM implements  Station {
        @Override
        public void play() {
            System.out.println("RadioDFM");
        }
    }
    class VestiRadio implements  Station {
        @Override
        public void play() {
            System.out.println("VestiRadio");
        }
    }
//    Context
    class Radio{
    Station station;
    void setStation (Station st) {
        station = st;
    }
    void nextStation() {
        if (station instanceof Radio7) {
            setStation(new RadioDFM());
        }
        else if (station instanceof RadioDFM) {
            setStation(new VestiRadio());
        }
        else if (station instanceof VestiRadio) {
            setStation(new Radio7());
        }
    }

    void play() {
        station.play();
    }
}

class Human{
    private Activity state;
    public void setState(Activity s) {
        this.state = s;
    }

    public void doSomething() {
        state.doSomething(this);
    }
}
//State
interface Activity {
    void doSomething(Human context);
}

class Work implements Activity {
    @Override
    public void doSomething(Human context) {
        System.out.println("Working!");
        context.setState(new WeekEnd());
    }
}

class WeekEnd implements Activity{
    private  int count = 0;
    @Override
    public void doSomething(Human context) {
        if (count<3){
            System.out.println("Having rest!");
            count++;
        }
        else {
            context.setState(new Work());
            count =0;
        }
    }
}



