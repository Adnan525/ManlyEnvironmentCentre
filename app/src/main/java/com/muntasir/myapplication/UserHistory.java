package com.muntasir.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UserHistory extends AppCompatActivity {

    private Button applianceHistory;
    private Button quizHistory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_history);

        applianceHistory = (Button) findViewById(R.id.applianceData);
        applianceHistory.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    openApplianceHistory();
                                                }
                                            }

        );

        quizHistory = (Button) findViewById(R.id.quizData);
        quizHistory.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    openQuizHistory();
                                                }
                                            }

        );
    }

    private void openApplianceHistory() {
        Intent userApplianceHistory = new Intent(this, ApplianceAnswers.class );
        startActivity(userApplianceHistory);
    }

    private void openQuizHistory() {
        Intent userQuizHistory = new Intent(this, QuizAnswers.class );
        startActivity(userQuizHistory);
    }
}
