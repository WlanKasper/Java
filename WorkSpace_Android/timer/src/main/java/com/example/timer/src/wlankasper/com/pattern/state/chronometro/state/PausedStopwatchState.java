package com.example.timer.src.wlankasper.com.pattern.state.chronometro.state;

import com.example.timer.src.wlankasper.com.pattern.state.chronometro.layout.StopwatchSwing;

public class PausedStopwatchState implements StopwatchState {
    StopwatchSwing stopwatchSwing;

    public PausedStopwatchState(StopwatchSwing stopwatchSwing) {
        this.stopwatchSwing = stopwatchSwing;
    }

    @Override
    public void execute() {
        handleStopwatch();
        handleUI();
        changeState();
    }

    @Override
    public void handleStopwatch() {
        stopwatchSwing.sw.start();
    }

    @Override
    public void handleUI() {
        stopwatchSwing.start.setText("Pause");
    }

    @Override
    public void changeState() {
        stopwatchSwing.setState(stopwatchSwing.getRunningState());
    }
}
