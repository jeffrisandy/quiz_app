package com.example.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int score =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswer(View view) {
        score = q1Score() +q2Score() + q3Score() +q4Score() +q5Score();


        Toast.makeText(this, "Your score is " + score + " of 5", Toast.LENGTH_SHORT).show();
    }

    public void reset(View view) {
        score = 0;

        // checkboxes
        List<Integer> checkBoxes = new ArrayList<Integer>();
        checkBoxes.add(R.id.q2_a1_checkbox);
        checkBoxes.add(R.id.q2_a2_checkbox);
        checkBoxes.add(R.id.q2_a3_checkbox);

        // radio button groups
        List<Integer> buttons = new ArrayList<Integer>();
        buttons.add(R.id.q1_radio_group);
        buttons.add(R.id.q4_radio_group);
        buttons.add(R.id.q5_radio_group);


        // clear checkboxes
        for (int name : checkBoxes) {
            clearCheckBox(name);
        }

        //clear buttons
        for (int name : buttons) {
            clearButton(name);
        }

        // clear editText

        clearText(R.id.q3_answer_text);

        Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show();
    }



    private int q1Score() {
        boolean answer = answerButton(R.id.q1_a1_button);
        if (answer) {
            return 1;
        } else {
            return 0;
        }
    }

    private int q2Score() {
        boolean answer1 = answerCheckBox(R.id.q2_a2_checkbox);
        boolean answer2 = answerCheckBox(R.id.q2_a3_checkbox);
        if (answer1 && answer2) {
            return 1;
        } else {
            return 0;
        }
    }

    private int q3Score(){
        String answer = answerText(R.id.q3_answer_text);
        if (answer.equals( "David De Gea")) {
            return 1;
        } else {
            return 0;
        }

    }

    private int q4Score() {
        boolean answer = answerButton(R.id.q4_a2_button);
        if (answer) {
            return 1;
        } else {
            return 0;
        }
    }

    private int q5Score() {
        boolean answer = answerButton(R.id.q5_a3_button);
        if (answer) {
            return 1;
        } else {
            return 0;
        }
    }

    private boolean answerCheckBox(int name) {
        CheckBox answer = findViewById(name);
        boolean answerCheck= answer.isChecked();
        return answerCheck;
    }

    private boolean answerButton(int name) {
        RadioButton answer = findViewById(name);
        boolean answerCheck= answer.isChecked();
        return answerCheck;
    }

    private String answerText(int name) {
        EditText nameField = findViewById(name);
        String nameString = nameField.getText().toString();
        return nameString;
    }

    private void clearCheckBox(int name) {
        CheckBox answer = findViewById(name);

        if (answer.isChecked()) {
            answer.toggle();
        }
    }

    private void clearButton(int name) {
        RadioGroup answer = findViewById(name);
        answer.clearCheck();

    }

    private void clearText(int name) {
        EditText nameField = findViewById(name);
        nameField.setText("");
    }

}
