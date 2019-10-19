package com.muntasir.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button quizButton;
    private Button contactButton;
    private Button button2;
    private Button userHistory;
    private Button exitButton;
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

        exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                killActivity();
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

    //kill activity code taken from https://www.instructables.com/id/HelloWorld-With-Exit-Button-AndroidStudio/
    private void killActivity() {
//        finish();
//        System.exit(0);
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Exit");
        builder.setMessage("Do you want to exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                finish();
            }
        });
        builder.setNegativeButton("No, go back to main menu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
