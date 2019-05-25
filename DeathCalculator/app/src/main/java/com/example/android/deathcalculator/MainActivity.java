package com.example.android.deathcalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText age;
    int totalTries = 0;
    int score = 0;
    String getrec = "";
    String getName = "";
    TextView warning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        warning = (TextView) findViewById(R.id.warning);


    }

    public void checkCredentials(View view){
        String getrec = age.getText().toString();
        String getName = name.getText().toString();
        if(getrec == null || "".equals(getrec)  || (getName == null || "".equals(getName))){
            warning.setText("Please enter valid credentials");
        }
        else if(Integer.parseInt(getrec) >= 100){
            warning.setText("Please enter a number below 100");
        }
        else {
            totalTries += 1;
            Intent i = new Intent(this, ActivityTwo.class);
            String info = Integer.toString(totalTries);
            String infoScore = Integer.toString(score);
            Bundle bundle = new Bundle();
            bundle.putString("key1", getrec);
            bundle.putString("key2", info);
            bundle.putString("key3", infoScore);
            bundle.putString("key4", getName);
            i.putExtras(bundle);
            startActivityForResult(i,1);
        }

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                String info = data.getStringExtra("key");
                totalTries = Integer.parseInt(result);
                score = Integer.parseInt(info);
            }
        }
    }//onActivityResult

}
