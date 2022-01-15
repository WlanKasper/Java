package wlankasper.com.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import wlankasper.com.contacts.src.Tree;

public class MainActivity extends AppCompatActivity {

    Tree root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        root = new Tree(0,"",null);
    }
}