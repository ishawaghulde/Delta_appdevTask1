package com.example.android.deathcalculator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTwo extends AppCompatActivity {
    EditText guess;
    LinearLayout changeColor;
    TextView comment;

    TextView result;
    TextView name;
    int age = 0;
    int noOfTries = 0;
    int totalTries = 0;
    int score = 0;
    int grad = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        changeColor = (LinearLayout) findViewById(R.id.changeColor);
        comment = (TextView) findViewById(R.id.comment);
        result = (TextView) findViewById(R.id.score);
        name = (TextView) findViewById(R.id.name);

        Bundle bundle = getIntent().getExtras();
        String strAge = bundle.getString("key1");
        String strTry = bundle.getString("key2");
        String strInfo = bundle.getString("key3");
        String getName = bundle.getString("key4");
        age = Integer.parseInt(strAge);
        totalTries = Integer.parseInt(strTry);
        score = Integer.parseInt(strInfo);
        name.setText(getName);



    }

    public void checkGuess(View view){
        int guessedAge;

        guess = (EditText) findViewById(R.id.guess);
        String strGuessedAge = guess.getText().toString();
        if(strGuessedAge == null || "".equals(strGuessedAge)) {

            comment.setText("Please enter age");

        }
        else{
            noOfTries += 1;
            guessedAge = Integer.parseInt(strGuessedAge);
            int diff = Math.max(age - guessedAge, guessedAge - age);
            int max = Math.max(age - 0, 100 - age);
            if (max % 10 < 5) {
                grad = max / 10;
            } else {
                grad = (max / 10) + 1;
            }


            if (noOfTries != 7) {
                int triesLeft = 7 - noOfTries;


                if (diff > 9 * grad) {
                    changeColor.setBackgroundColor(Color.parseColor("#C0392B"));
                    String str = "You have " + triesLeft + " tries left.";
                    comment.setText(str);
                } else if (diff > 8 * grad) {
                    changeColor.setBackgroundColor(Color.parseColor("#CD6155"));
                    String str = "You have " + triesLeft + " tries left.";
                    comment.setText(str);
                } else if (diff > 7 * grad) {
                    changeColor.setBackgroundColor(Color.parseColor("#D9880"));
                    String str = "You have " + triesLeft + " tries left.";
                    comment.setText(str);
                } else if (diff > 6 * grad) {
                    changeColor.setBackgroundColor(Color.parseColor("#E6B0AA"));
                    String str = "You have " + triesLeft + " tries left.";
                    comment.setText(str);
                } else if (diff > 5 * grad) {
                    changeColor.setBackgroundColor(Color.parseColor("#F2D7D5"));
                    String str = "You have " + triesLeft + " tries left.";
                    comment.setText(str);
                } else if (diff > 4 * grad) {
                    changeColor.setBackgroundColor(Color.parseColor("#EAFAF1"));
                    String str = "You have " + triesLeft + " tries left.";
                    comment.setText(str);
                } else if (diff > 3 * grad) {
                    changeColor.setBackgroundColor(Color.parseColor("#D5F5E3"));
                    String str = "You have " + triesLeft + " tries left.";
                    comment.setText(str);
                } else if (diff > 2 * grad) {
                    changeColor.setBackgroundColor(Color.parseColor("#ABEBC6"));
                    String str = "You have " + triesLeft + " tries left.";
                    comment.setText(str);
                } else if (diff > grad) {
                    changeColor.setBackgroundColor(Color.parseColor("#82E0AA"));
                    String str = "You have " + triesLeft + " tries left.";
                    comment.setText(str);
                } else if (diff < grad && diff != 0) {
                    changeColor.setBackgroundColor(Color.parseColor("#58D68D"));
                    String str = "You have " + triesLeft + " tries left.";
                    comment.setText(str);

                } else if (diff == 0) {
                    changeColor.setBackgroundColor(Color.parseColor("#2ECC71"));
                    String s = "Hurray! You win!";
                    comment.setText(s);
                    score += 1;
                }
            } else if (noOfTries == 7) {
                String s = "Uh Oh! You've run out of tries. Try again!";
                comment.setText(s);
            } else {
                comment.setText("Try another victim!");
            }
        }




    }

    public void goToFirstActivity(View view){
        Intent returnIntent = new Intent();
        String result = Integer.toString(totalTries);
        String infoScore = Integer.toString(score);
        returnIntent.putExtra("result",result);
        returnIntent.putExtra("key", infoScore);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();


    }

    public void generateScore(View view){
        String res = "Total number of tries : " + totalTries + "\n Number of wins : " + score;
        result.setText(res);

    }



}
