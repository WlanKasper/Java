package wlankasper.com.recursion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonRecurs, buttonExit;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.centerText);

        buttonExit = findViewById(R.id.bottomButtExit);
        buttonExit.setOnClickListener(view -> finish());

        buttonRecurs = findViewById(R.id.recursButt);
        buttonRecurs.setOnClickListener(view -> {
            String str = new Recursion().recursionPalindrome((String) text.getText());
            text.setText(str);
        });
    }

    class Recursion {
        //---------Palindrome recursion---------
        public String recursionPalindrome(String str){
            if (str.length() == 1)
                return str;

            return recursionPalindrome(str.substring(1)) + str.charAt(0);
        }
    }

}