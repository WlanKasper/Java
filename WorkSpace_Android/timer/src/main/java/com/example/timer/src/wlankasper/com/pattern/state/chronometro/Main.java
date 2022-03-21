package com.example.timer.src.wlankasper.com.pattern.state.chronometro;

import com.example.timer.src.wlankasper.com.pattern.state.chronometro.layout.Stopwatch;
import com.example.timer.src.wlankasper.com.pattern.state.chronometro.layout.StopwatchSwing;
import com.example.timer.src.wlankasper.com.pattern.state.chronometro.obs.StopwatchObserver;

public class Main {
    public static void main(String[] args) {
        Stopwatch sw = new Stopwatch();
        StopwatchSwing swS = new StopwatchSwing();
        StopwatchObserver ob = new StopwatchObserver();

        sw.registerObserver(ob);
        swS.setStopwatch(sw);
    }
}
