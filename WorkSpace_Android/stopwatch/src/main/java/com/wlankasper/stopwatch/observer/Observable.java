package com.wlankasper.stopwatch.observer;

public interface Observable {
    public void registerObserver(Observer o);

    public void notifyObservers();
}
