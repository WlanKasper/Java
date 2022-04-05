package wlankasper.com.pattern.state.chronometro.obs;

public interface Observable {
    public void registerObserver(Observer o);

    public void notifyObservers();
}
