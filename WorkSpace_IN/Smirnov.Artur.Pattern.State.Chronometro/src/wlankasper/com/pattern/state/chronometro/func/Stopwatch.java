package wlankasper.com.pattern.state.chronometro.func;

import wlankasper.com.pattern.state.chronometro.obs.Observable;
import wlankasper.com.pattern.state.chronometro.obs.Observer;

import java.util.ArrayList;
import java.util.Iterator;

public class Stopwatch implements Runnable, Observable {
    private final ArrayList<Observer> observers;
    private long offset, currentStart;
    private boolean isStopped;
    private Thread th;

    public Stopwatch() {
        offset = 0L;
        currentStart = System.currentTimeMillis();
        isStopped = true;
        observers = new ArrayList<>();
    }

    public void start() {
        if (isStopped) {
            th = new Thread(this);
            th.start();
            currentStart = System.currentTimeMillis() - offset;
        }

        isStopped = false;
    }

    public void stop() {
        if (!isStopped) {
            th = null;
            offset = System.currentTimeMillis() - currentStart;
        }
        isStopped = true;
    }

    public long getTime() {
        if (!isStopped)
            return System.currentTimeMillis() - currentStart;
        else
            return offset;
    }

    @Override
    public void run() {
        while (!isStopped) {
            notifyObservers();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
        Iterator<Observer> iter = observers.iterator();
        while (iter.hasNext()) {
            Observer o = iter.next();
            o.update(getTime());
        }
    }
}