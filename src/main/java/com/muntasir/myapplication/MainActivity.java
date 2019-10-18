package com.muntasir.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button quizButton;
    private Button contactButton;
    private Button button2;
    private Button userHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizButton = (Button) findViewById(R.id.quizButton);
        quizButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              openQuizWelcome();
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

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("123");

                openApplianceUsage();
            }
        });

        userHistory = (Button) findViewById(R.id.userHistoryButton);
        userHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserHistory();
            }
        });
    }

    private void openContactUs() {
        Intent contactUsIntent = new Intent(this, ContactUs.class);
        startActivity(contactUsIntent);
    }

    private void openQuizWelcome() {
        Intent pamphletQuestionIntent = new Intent(this, QuizWelcome.class );
        startActivity(pamphletQuestionIntent);
    }

    private void openApplianceUsage() {
        Intent applianceUsageIntent = new Intent(this, ApplianceUsage.class );
        startActivity(applianceUsageIntent);
    }

    private void openUserHistory() {
        Intent userHistoryIntent = new Intent(this, UserHistory.class );
        startActivity(userHistoryIntent);
    }
}
