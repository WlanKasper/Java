package com.wlankasper.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.wlankasper.stopwatch.func.Stopwatch;
import com.wlankasper.stopwatch.observer.Observer;
import com.wlankasper.stopwatch.observer.StopwatchObserver;
import com.wlankasper.stopwatch.state.NotRunningStopwatchState;
import com.wlankasper.stopwatch.state.PausedStopwatchState;
import com.wlankasper.stopwatch.state.RunningStopwatchState;
import com.wlankasper.stopwatch.state.StopPressedStopwatchState;
import com.wlankasper.stopwatch.state.StopwatchState;

public class MainActivity extends AppCompatActivity implements Observer {

    public TextView timerDisplay;
    public Button start, stop;

    public Stopwatch sw;
    public StopwatchState notRunningState;
    public StopwatchState runningState;
    public StopwatchState pausedState;
    public StopwatchState stopPressedState;

    public StopwatchState currentState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addButtonListeners();
        initializeStates();
    }

    private void init(){
        sw = new Stopwatch();
        StopwatchObserver ob = new StopwatchObserver();
        sw.registerObserver(ob);


        timerDisplay = findViewById(R.id.timerText);
        start = findViewById(R.id.btn1);
        stop = findViewById(R.id.btn2);
        stop.setClickable(false);

    }

    public void addButtonListeners() {
        // Adding Listeners to the Buttons

        start.setOnClickListener(view -> handleStartPress());
        stop.setOnClickListener(view -> handleStopPress());
    }

    public void initializeStates() {
        // Initializing states
        notRunningState = new NotRunningStopwatchState(this);
        runningState = new RunningStopwatchState(this);
        pausedState = new PausedStopwatchState(this);
        stopPressedState = new StopPressedStopwatchState(this);
        currentState = stopPressedState;
        currentState.execute();
    }

    private void handleStartPress() {
        currentState.execute();

    }

    private void handleStopPress() {
        currentState = stopPressedState;
        currentState.execute();
    }

    public void setState(StopwatchState stopwatchState) {
        currentState = stopwatchState;
    }

    public void setSw(Stopwatch sw) {
        this.sw = sw;
    }

    public StopwatchState getNotRunningState() {
        return notRunningState;
    }

    public StopwatchState getRunningState() {
        return runningState;
    }

    public StopwatchState getPausedState() {
        return pausedState;
    }

    @SuppressLint("DefaultLocale")
    public String formatTime(long time) {
        int time1 = (int) time;
        int millis, secs, minutes, hours;
        String formattedTime;

        millis = time1 % 1000;
        time1 = time1 / 1000;
        secs = time1 % 60;
        time1 = time1 / 60;
        minutes = time1 % 60;
        time1 = time1 / 60;
        hours = time1 % 60;

        formattedTime = String.format("%02d", secs) + ":" + String.format("%03d", millis);
        if (minutes > 0)
            formattedTime = String.format("%02d", minutes) + ":" + formattedTime;
        if (hours > 0)
            formattedTime = String.format("%02d", hours) + ":" + formattedTime;
        return formattedTime;

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void update(long time) {
        runOnUiThread(() -> timerDisplay.setText("Time: " + formatTime(time)));
    }
}