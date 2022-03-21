package com.example.timer.src.wlankasper.com.pattern.state.chronometro.state;

import com.example.timer.src.wlankasper.com.pattern.state.chronometro.layout.Stopwatch;
import com.example.timer.src.wlankasper.com.pattern.state.chronometro.layout.StopwatchSwing;

public class NotRunningStopwatchState implements StopwatchState {
    StopwatchSwing stopwatchSwing;

    public NotRunningStopwatchState(StopwatchSwing stopwatchSwing) {
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
        Stopwatch sw = new Stopwatch();
        stopwatchSwing.setStopwatch(sw);
        sw.registerObserver(stopwatchSwing);
        sw.start();
    }

    @Override
    public void handleUI() {
        stopwatchSwing.start.setText("Pause");
        stopwatchSwing.stop.setVisible(true);
    }

    @Override
    public void changeState() {
        stopwatchSwing.setState(stopwatchSwing.getRunningState());
    }
}
