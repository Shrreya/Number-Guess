package com.example.shrreya.mygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GuessActivity extends AppCompatActivity implements View.OnClickListener{

    TextView guess_textview;
    Button bigger_button, smaller_button, yes_button;
    int num =0, f=1, l=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);
        guess_textview = (TextView) findViewById(R.id.guess_textview);
        bigger_button = (Button) findViewById(R.id.bigger_button);
        smaller_button = (Button) findViewById(R.id.smaller_button);
        yes_button = (Button) findViewById(R.id.yes_button);
        bigger_button.setOnClickListener(this);
        smaller_button.setOnClickListener(this);
        yes_button.setOnClickListener(this);

        guess(f,l);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id) {
            case R.id.bigger_button:
                guess(num + 1, l);
                break;
            case R.id.smaller_button:
                guess(f, num - 1);
                break;
            case R.id.yes_button: {
                Intent intent = new Intent(this, WinningActivity.class);
                startActivity(intent);
                break;
            }
        }
    }

    public void guess(int first, int last) {
        f=first;
        l=last;
        num = (first+last)/2;
        guess_textview.setText("Is your number "+num+"?");
    }
}
