package net.ukr.vlsv.hw01_03_userinput_quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tQuestion;
    TextView tRight;
    TextView tWrong;
    TextView tFinish;

    RadioButton rAnswer1;
    RadioButton rAnswer2;
    RadioButton rAnswer3;

    Button bSubmit;

    int result=0;
    int countOK = 0;
    int countERR = 0;
    int countAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tQuestion = findViewById(R.id.tQuestion);
        tRight = findViewById(R.id.tRight);
        tWrong = findViewById(R.id.tWrong);
        tFinish = findViewById(R.id.tFinish);

        rAnswer1 = findViewById(R.id.answer1);
        rAnswer2 = findViewById(R.id.answer2);
        rAnswer3 = findViewById(R.id.answer3);

        bSubmit  = findViewById(R.id.submit);

        showRezult();
        newQuestion();
    }
    public void countRezult() {
        String sAnswer = "0";

        if (rAnswer1.isChecked()) sAnswer = rAnswer1.getText().toString();
        if (rAnswer2.isChecked()) sAnswer = rAnswer2.getText().toString();
        if (rAnswer3.isChecked()) sAnswer = rAnswer3.getText().toString();

        if (Integer.parseInt(sAnswer) == result) countOK++;  else countERR++;

        showRezult();
    }
    public void newQuestion() {

        if (countAnswer++ != 0) {
            countRezult();
        }

        Random random = new Random();
        int a = random.nextInt(20);
        int b = random.nextInt(20);
        int d = random.nextInt(2)+1;

        result = a + b;

        tQuestion.setText(a + "+" + b + "=?");

        rAnswer1.setText("" + random.nextInt(40));
        rAnswer2.setText("" + random.nextInt(40));
        rAnswer3.setText("" + random.nextInt(40));


        if (d == 1) rAnswer1.setText("" + result);
        if (d == 2) rAnswer2.setText("" + result);
        if (d == 3) rAnswer3.setText("" + result);

    }

    public void onClickSubmit(View view) {
        if ((countOK + countERR) == 2) {
            countRezult();

            tQuestion.setVisibility(TextView.GONE);
            bSubmit.setVisibility(Button.GONE);
            rAnswer1.setVisibility(RadioButton.GONE);
            rAnswer2.setVisibility(RadioButton.GONE);
            rAnswer3.setVisibility(RadioButton.GONE);

            String textFinish = "";

            if (++countOK == countAnswer) textFinish = "You're a winner!"; else textFinish = "You lose!";

            tFinish.setText(textFinish);
        }
        else newQuestion();
    }

    public void showRezult() {
        tRight.setText("Right " + countOK);
        tWrong.setText("Wrong " + countERR);
    }
}


