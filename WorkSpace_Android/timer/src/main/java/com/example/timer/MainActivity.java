package com.example.timer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.timer.src.wlankasper.com.pattern.state.chronometro.obs.Observer;
import com.example.timer.src.wlankasper.com.pattern.state.chronometro.state.NotRunningStopwatchState;
import com.example.timer.src.wlankasper.com.pattern.state.chronometro.state.PausedStopwatchState;
import com.example.timer.src.wlankasper.com.pattern.state.chronometro.state.RunningStopwatchState;
import com.example.timer.src.wlankasper.com.pattern.state.chronometro.state.StopPressedStopwatchState;
import com.example.timer.src.wlankasper.com.pattern.state.chronometro.state.StopwatchState;

public class MainActivity extends AppCompatActivity  implements Observer {

    TextView time;
    Button start, stop;

    public StopwatchState notRunningState;
    public StopwatchState runningState;
    public StopwatchState pausedState;
    public StopwatchState stopPressedState;
    public StopwatchState currentState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initObjects();

    }

    private void initObjects() {
        time = findViewById(R.id.text);
        start = findViewById(R.id.btn_first);
        stop = findViewById(R.id.btn_second);
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

    @Override
    public void update(long time) {

    }
}