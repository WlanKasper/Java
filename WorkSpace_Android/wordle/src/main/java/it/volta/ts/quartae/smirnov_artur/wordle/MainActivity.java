package it.volta.ts.quartae.smirnov_artur.wordle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // TODO: 21/03/22 TO REFACTOR 
//    private final String DICTIONARY = getApplicationContext().getString(R.string.dictionary);

    private Dialog infoDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createInfoDialog();
    }


//  ------------------- Dialog Information -------------------
    private void createInfoDialog(){
        infoDialog = new Dialog(this);
        infoDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        infoDialog.setContentView(R.layout.info_dialog);
        addOnClickStart();
        infoDialog.show();
    }

    private void addOnClickStart(){
        Button btn_start = infoDialog.findViewById(R.id.buttonStart);
        btn_start.setOnClickListener(view -> infoDialog.dismiss());
    }


}