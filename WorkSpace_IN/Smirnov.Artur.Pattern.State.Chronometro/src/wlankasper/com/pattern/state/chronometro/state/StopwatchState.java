package wlankasper.com.pattern.state.chronometro.state;

public interface StopwatchState {

//    default void execute()
//    {
//        handleStopwatch();
//        handleUI();
//        changeState();
//    }

    public void execute();

    public void handleStopwatch();

    public void handleUI();

    public void changeState();
}
