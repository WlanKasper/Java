package com.example.timer.src.wlankasper.com.pattern.state.chronometro.state;

import com.example.timer.src.wlankasper.com.pattern.state.chronometro.layout.StopwatchSwing;

public class RunningStopwatchState implements StopwatchState {
    StopwatchSwing stopwatchSwing;

    public RunningStopwatchState(StopwatchSwing stopwatchSwing) {
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
        stopwatchSwing.sw.stop();
    }

    @Override
    public void handleUI() {
        stopwatchSwing.start.setText("Resume");
    }

    @Override
    public void changeState() {
        stopwatchSwing.setState(stopwatchSwing.getPausedState());
    }
}
