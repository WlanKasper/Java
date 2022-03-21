package com.wlankasper.stopwatch.state;

import android.annotation.SuppressLint;

import com.wlankasper.stopwatch.MainActivity;

public class StopPressedStopwatchState implements StopwatchState {

    MainActivity stopwatchAndroid;

    public StopPressedStopwatchState(MainActivity stopwatchAndroid) {
        this.stopwatchAndroid = stopwatchAndroid;
    }

    @Override
    public void handleStopwatch() {
        if (stopwatchAndroid.sw != null)
            stopwatchAndroid.sw.stop();
        stopwatchAndroid.sw = null;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void handleUI() {
        stopwatchAndroid.timerDisplay.setText("Time: " + stopwatchAndroid.formatTime(0L));
        stopwatchAndroid.start.setText("Start");
    }

    @Override
    public void changeState() {
        stopwatchAndroid.setState(stopwatchAndroid.getNotRunningState());
    }
}
