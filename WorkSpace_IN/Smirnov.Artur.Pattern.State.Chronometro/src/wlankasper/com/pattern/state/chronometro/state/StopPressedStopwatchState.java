package wlankasper.com.pattern.state.chronometro.state;

import wlankasper.com.pattern.state.chronometro.func.StopwatchSwing;

public class StopPressedStopwatchState implements StopwatchState {
    StopwatchSwing stopwatchSwing;

    public StopPressedStopwatchState(StopwatchSwing stopwatchSwing) {
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
        if (stopwatchSwing.sw != null)
            stopwatchSwing.sw.stop();
        stopwatchSwing.sw = null;
    }

    @Override
    public void handleUI() {
        stopwatchSwing.timerDisplay.setText("Time: " + stopwatchSwing.formatTime(0L));
        stopwatchSwing.start.setText("Start");
        stopwatchSwing.stop.setVisible(false);
    }

    @Override
    public void changeState() {
        stopwatchSwing.setState(stopwatchSwing.getNotRunningState());
    }
}
