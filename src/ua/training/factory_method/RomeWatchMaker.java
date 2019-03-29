package ua.training.factory_method;

public class RomeWatchMaker implements WatchMaker {

    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}
