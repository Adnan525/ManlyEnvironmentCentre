package com.muntasir.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.PrintWriter;

public class ShowScore extends AppCompatActivity {

    private Button quitButton;
    private TextView mScoreView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        Intent check = getIntent();
        if(check.hasExtra("score"))
        {
            System.out.println("In show Score. Extra val exists");
            int score = check.getIntExtra("score", 0);
            System.out.println(score);

            mScoreView = (TextView) findViewById(R.id.score);
            mScoreView.setText(score + "");
            //mScoreView.setText(check.getStringExtra("score").toString());
        }

        quitButton = (Button) findViewById(R.id.quitButton);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainMenu();
            }
        });
    }

    public void openMainMenu()
    {
        Intent mainMenu = new Intent(this, MainActivity.class);
        startActivity(mainMenu);
    }



}
