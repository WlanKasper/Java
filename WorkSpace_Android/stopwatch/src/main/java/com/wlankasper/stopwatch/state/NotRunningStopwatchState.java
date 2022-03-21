package com.wlankasper.stopwatch.state;

import com.wlankasper.stopwatch.MainActivity;
import com.wlankasper.stopwatch.func.Stopwatch;

public class NotRunningStopwatchState implements StopwatchState {
    MainActivity stopwatchAndroid;

    public NotRunningStopwatchState(MainActivity stopwatchAndroid) {
        this.stopwatchAndroid = stopwatchAndroid;
    }

    @Override
    public void handleStopwatch() {
        Stopwatch sw = new Stopwatch();
        stopwatchAndroid.setSw(sw);
        sw.registerObserver(stopwatchAndroid);
        sw.start();
    }

    @Override
    public void handleUI() {
        stopwatchAndroid.start.setText("Pause");
    }

    @Override
    public void changeState() {
        stopwatchAndroid.setState(stopwatchAndroid.getRunningState());
    }
}