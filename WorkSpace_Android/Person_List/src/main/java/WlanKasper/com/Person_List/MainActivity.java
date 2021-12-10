package WlanKasper.com.Person_List;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import WlanKasper.com.Person_List.src.Person;
import WlanKasper.com.Person_List.src.PersonList;

public class MainActivity extends AppCompatActivity {

    EditText inputTextName, inputTextLastname;
    Button buttonAddInDB;
    TextView viewDBout;

    Person person;
    PersonList personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTextName = findViewById(R.id.inputTextName);
        inputTextLastname = findViewById(R.id.inputTextLastname);
        buttonAddInDB = findViewById(R.id.buttonAddInDB);
        viewDBout = findViewById(R.id.viewDBout);

        viewDBout.setMovementMethod(new ScrollingMovementMethod());

        personList = new PersonList();

        buttonAddInDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person = new Person();
                person.setPersonData(inputTextName.getText().toString(), inputTextLastname.getText().toString());

                System.out.println(" -------- NEW TEXT LOG -------- " + person.toString());

                personList.addNewPerson(person);
                viewDBout.setText(personList.getPersonList());

            }
        });
    }
}