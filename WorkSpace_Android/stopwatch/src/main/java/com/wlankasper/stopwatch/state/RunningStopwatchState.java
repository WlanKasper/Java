package com.wlankasper.stopwatch.state;

import com.wlankasper.stopwatch.MainActivity;

public class RunningStopwatchState implements StopwatchState {

    MainActivity stopwatchAndroid;

    public RunningStopwatchState(MainActivity stopwatchAndroid) {
        this.stopwatchAndroid = stopwatchAndroid;
    }

    @Override
    public void handleStopwatch() {
        stopwatchAndroid.sw.stop();
    }

    @Override
    public void handleUI() {
        stopwatchAndroid.start.setText("Resume");
    }

    @Override
    public void changeState() {
        stopwatchAndroid.setState(stopwatchAndroid.getPausedState());
    }
}
