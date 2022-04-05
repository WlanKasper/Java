package it.volta.ts.quartae.smirnov_artur.wordle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: 21/03/22 TO REFACTOR 
    private final String DICTIONARY = getApplicationContext().getString(R.string.dictionary);

    private static final int BLOCKS = 30;
    private String wordle;

    private TextView[] tiles;

    private Dialog infoDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createInfoDialog();
        initGame();
    }

    private void initGame() {
        setWordle();
        initBlocks();
    }

    private void initBlocks() {
        tiles = new TextView[BLOCKS];
        for (int i = 0; i < BLOCKS; i++) {
            int id = this.getResources().getIdentifier("c" + i, "id", this.getPackageName());
            tiles[i] = findViewById(id);
        }
    }

    private void setWordsToBlocks() {
    }

    private void setWordle() {
        String[] arrayFromString = DICTIONARY.split("\n");
        wordle = arrayFromString[2];
    }

    //  ------------------- Dialog Information -------------------
    private void createInfoDialog() {
        infoDialog = new Dialog(this);
        infoDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        infoDialog.setContentView(R.layout.info_dialog);
        addOnClickStart();
        infoDialog.show();
    }

    private void addOnClickStart() {
        Button btn_start = infoDialog.findViewById(R.id.buttonStart);
        btn_start.setOnClickListener(view -> infoDialog.dismiss());
    }
}