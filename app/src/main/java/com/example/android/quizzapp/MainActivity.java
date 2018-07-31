package com.example.android.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Method to displays the score as a Toast

    public void submitAnswers(View view) {
        int score = calculateScore();

        EditText playerName = (EditText) findViewById(R.id.name_view);
        String name = playerName.getText().toString();
        String scoreMessage = "Congratulations " + name + "! Your score is " + score;

        Toast toastMassage = Toast.makeText(this, scoreMessage, Toast.LENGTH_LONG);
        toastMassage.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        View toastView = toastMassage.getView();
        toastView.setBackgroundResource(R.drawable.toast_background);
        toastMassage.show();
    }

    // Method to calculate the score

    private int calculateScore() {

        int answersCorrect = 0;

        boolean questionOneAnswer = questionOneCheck();
        boolean questionTwoAnswer = questionTwoCheck();
        boolean questionThreeAnswer = questionThreeCheck();
        boolean questionFourAnswer = questionFourCheck();
        boolean questionFiveAnswer = questionFiveCheck();

        if (questionOneAnswer) {
            answersCorrect++;
        }
        if (questionTwoAnswer) {
            answersCorrect++;
        }
        if (questionThreeAnswer) {
            answersCorrect++;
        }
        if (questionFourAnswer) {
            answersCorrect++;
        }
        if (questionFiveAnswer) {
            answersCorrect++;
        }

        return answersCorrect;
    }

    // Method to check the state of a first question

    private boolean questionOneCheck() {
        RadioButton questionOne = (RadioButton) findViewById(R.id.radio_bicycle);
        boolean questionOneAnswer = questionOne.isChecked();
        return questionOneAnswer;
    }

    // Method to check the state of a second question

    private boolean questionTwoCheck() {
        RadioButton questionTwo = (RadioButton) findViewById(R.id.radio_jeans);
        boolean questionTwoAnswer = questionTwo.isChecked();
        return questionTwoAnswer;
    }

    // Method to check the state of a third question

    private boolean questionThreeCheck() {
        RadioButton questionThree = (RadioButton) findViewById(R.id.radio_coffee_grounds);
        boolean questionThreeAnswer = questionThree.isChecked();
        return questionThreeAnswer;
    }

    // Method to check the state of a fourth question

    private boolean questionFourCheck() {
        RadioButton questionFour = (RadioButton) findViewById(R.id.radio_40);
        boolean questionFourAnswer = questionFour.isChecked();
        return questionFourAnswer;
    }

    // Method to check the state of a fifth question

    private boolean questionFiveCheck() {
        boolean questionFiveAnswer = false;

        CheckBox questionFiveHouse = (CheckBox) findViewById(R.id.checkbox_house);
        CheckBox questionFiveLamp = (CheckBox) findViewById(R.id.checkbox_lamp);
        CheckBox questionFiveAirplane = (CheckBox) findViewById(R.id.checkbox_airplane);
        CheckBox questionFiveVase = (CheckBox) findViewById(R.id.checkbox_vase);

        if (questionFiveHouse.isChecked() & questionFiveLamp.isChecked() & questionFiveAirplane.isChecked() & questionFiveVase.isChecked()) {
            questionFiveAnswer = false;
        } else if (questionFiveHouse.isChecked() & questionFiveLamp.isChecked() & questionFiveVase.isChecked()) {
            questionFiveAnswer = true;
        } else if (questionFiveHouse.isChecked() & questionFiveAirplane.isChecked() || questionFiveLamp.isChecked() & questionFiveVase.isChecked() & questionFiveAirplane.isChecked()) {
            questionFiveAnswer = false;
        } else if (questionFiveHouse.isChecked() & questionFiveVase.isChecked() || questionFiveLamp.isChecked()) {
            questionFiveAnswer = true;
        }

        return questionFiveAnswer;
    }

    // Method to check the state of a sixth question

    private boolean questionFiveCheck() {
        boolean questionSixAnswer = false;

        EditText questionSixChoice = (EditText) findViewById(R.id.main_question_view);

        if (questionSixChoice.getText().toString() == "yes" || questionSixChoice.getText().toString() == "Yes" || questionSixChoice.getText().toString() == "YES") {
            questionSixAnswer = true;
        }

        return questionSixAnswer;
    }

}
