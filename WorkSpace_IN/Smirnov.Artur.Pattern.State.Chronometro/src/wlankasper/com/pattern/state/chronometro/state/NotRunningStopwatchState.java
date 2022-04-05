package wlankasper.com.pattern.state.chronometro.state;

import wlankasper.com.pattern.state.chronometro.func.Stopwatch;
import wlankasper.com.pattern.state.chronometro.func.StopwatchSwing;

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
