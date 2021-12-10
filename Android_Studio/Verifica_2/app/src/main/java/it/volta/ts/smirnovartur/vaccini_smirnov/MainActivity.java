package it.volta.ts.smirnovartur.vaccini_smirnov;

import static android.graphics.Color.GREEN;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView_Status, textView_Box_1, textView_Box_2, textView_Queue;
    Button button_Box_1, button_Box_2, button_AddNew, button_GoNext;
    EditText editText_Name, editText_Lastname;
    CheckBox checkBox_Moderna, checkBox_Pfizer, checkBox_SputnikV;

    boolean isSelect = false;
    String vaccine;

    PersonList personList;
    Box box1, box2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personList = new PersonList();
        box1 = new Box("Pfizer", "Moderna");
        box2 = new Box("Pfizer", "Sputnik");

        addObjects();
        checkSelect();

        button_AddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText_Name.getText() != null && editText_Lastname != null && isSelect) {
                    Person person = new Person(editText_Name.getText().toString(), editText_Lastname.getText().toString(), vaccine);
                    personList.addPerson(person);
                    textView_Queue.setText(personList.toString());
                }
            }
        });

        button_GoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!personList.toString().equals("")) {
                    for (int i = 0; i < personList.getArrayList().size();i++) {
                        if (!box1.isOccupied() && box1.controlTypeVaccine(personList.getArrayList().get(i))) {
                            box1.doVaccine(personList.getArrayList().get(i));
                            personList.deletePerson(personList.getArrayList().get(i));
                            textView_Queue.setText(personList.toString());
                            button_Box_1.setTextColor(Color.RED);
                            textView_Box_1.setText(String.valueOf(box1.getCounterVaccineted()));
                            break;
                        } else if (!box2.isOccupied() && box2.controlTypeVaccine(personList.getArrayList().get(i))) {
                            box2.doVaccine(personList.getArrayList().get(i));
                            personList.deletePerson(personList.getArrayList().get(i));
                            textView_Queue.setText(personList.toString());
                            button_Box_2.setTextColor(Color.RED);
                            textView_Box_2.setText(String.valueOf(box2.getCounterVaccineted()));
                            break;
                        } else{
                            textView_Status.setText("All boxs is occupied");
                        }
                    }
                }else{
                    textView_Status.setText("Queue is empty");
                }
            }
        });

        button_Box_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                box1.setOccupied(false);
                textView_Queue.setText(personList.toString());
                button_Box_1.setTextColor(GREEN);
            }
        });

        button_Box_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                box2.setOccupied(false);
                textView_Queue.setText(personList.toString());
                button_Box_2.setTextColor(GREEN);
            }
        });
    }

    protected void addObjects() {
        textView_Status = findViewById(R.id.TextView_Status);
        textView_Box_1 = findViewById(R.id.TextView_Box_1);
        textView_Box_2 = findViewById(R.id.TextView_Box_2);
        textView_Queue = findViewById(R.id.TextView_Queue);

        button_Box_1 = findViewById(R.id.Button_Box_1);
        button_Box_2 = findViewById(R.id.Button_Box_2);
        button_AddNew = findViewById(R.id.Button_AddNew);
        button_GoNext = findViewById(R.id.Button_GoNext);

        editText_Name = findViewById(R.id.EditText_Name);
        editText_Lastname = findViewById(R.id.EditText_Lastname);

        checkBox_Moderna = findViewById(R.id.CheckBox_Moderna);
        checkBox_Pfizer = findViewById(R.id.CheckBox_Pfizer);
        checkBox_SputnikV = findViewById(R.id.CheckBox_SputnikV);
    }

    protected void checkSelect() {
        checkBox_Moderna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSelect = true;
                vaccine = checkBox_Moderna.getText().toString();
                checkBox_Moderna.setChecked(true);
                checkBox_Pfizer.setChecked(false);
                checkBox_SputnikV.setChecked(false);
            }
        });
        checkBox_Pfizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSelect = true;
                vaccine = checkBox_Pfizer.getText().toString();
                checkBox_Moderna.setChecked(false);
                checkBox_Pfizer.setChecked(true);
                checkBox_SputnikV.setChecked(false);
            }
        });
        checkBox_SputnikV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSelect = true;
                vaccine = checkBox_SputnikV.getText().toString();
                checkBox_Moderna.setChecked(false);
                checkBox_Pfizer.setChecked(false);
                checkBox_SputnikV.setChecked(true);
            }
        });
    }
}