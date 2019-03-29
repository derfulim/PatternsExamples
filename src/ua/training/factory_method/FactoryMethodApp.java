package ua.training.factory_method;

public class FactoryMethodApp {
    public static void main(String[] args) {
        WatchMaker watchMaker =
        getWatchMakerByName("Digital");

        watchMaker.createWatch().showTime();
    }

    public static WatchMaker getWatchMakerByName(String maker){
        if (maker.equals("Rome")){return new RomeWatchMaker();}
        else if (maker.equals("Digital")){return new DigitalWatchMaker();}
        throw new RuntimeException("Не поддерживаемый производитель часов " + maker);
    }
}
