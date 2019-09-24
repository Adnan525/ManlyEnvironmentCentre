package com.muntasir.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button quizButton;
    private Button contactButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizButton = (Button) findViewById(R.id.quizButton);
        quizButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              openPamphletQuestion();
                                          }
                                      }

        );
        
        contactButton = (Button) findViewById(R.id.contactButton);
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContactUs();
            }
        });
    }

    private void openContactUs() {
        Intent contactUsIntent = new Intent(this, ContactUs.class);
        startActivity(contactUsIntent);
    }

    private void openPamphletQuestion() {
        Intent pamphletQuestionIntent = new Intent(this, QuizAudit.class );
        startActivity(pamphletQuestionIntent);
    }
}
