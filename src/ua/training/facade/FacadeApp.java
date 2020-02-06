package ua.training.facade;

public class FacadeApp {
    public static void main(String[] args) {
//        Power power = new Power();
//        power.on();
//        DVDRom dvdRom = new DVDRom();
//        dvdRom.load();
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvdRom);
        Computer computer = new Computer();
        computer.copy();

    }
}

    class Computer{
        Power power = new Power();
        DVDRom dvdRom = new DVDRom();
        HDD hdd = new HDD();

        void copy() {
            power.on();
            dvdRom.load();
            hdd.copyFromDVD(dvdRom);
        }

    }

    class Power {
        void on() {
            System.out.println("Turn on the power");
        }

        void off() {
            System.out.println("Turn off the power");}
        }


    class DVDRom {
    private boolean data = false;
    public boolean hasData() {
        return data;
    }

    void load() {
        data = true;
    }

    void unload() {
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRom dvdRom) {
        if(dvdRom.hasData()) {
            System.out.println("Data is copying from drive");
        }
        else {
            System.out.println("Inser disk with data");
        }
    }
}


