package com.wlankasper.stopwatch.state;

import com.wlankasper.stopwatch.MainActivity;

public class PausedStopwatchState implements StopwatchState {
    MainActivity stopwatchAndroid;

    public PausedStopwatchState(MainActivity stopwatchAndroid) {
        this.stopwatchAndroid = stopwatchAndroid;
    }

    @Override
    public void handleStopwatch() {
        stopwatchAndroid.sw.start();
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
