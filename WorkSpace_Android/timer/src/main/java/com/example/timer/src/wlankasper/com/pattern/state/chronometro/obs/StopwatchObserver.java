package com.example.timer.src.wlankasper.com.pattern.state.chronometro.obs;

public class StopwatchObserver implements Observer {

    @Override
    public void update(long time) {
        System.out.print("\rTime: " + time);
    }
}
