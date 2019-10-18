package com.muntasir.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;



public class ApplianceUsage extends AppCompatActivity {

    private Integer mScore = 0;

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mNext;
    private EditText mInput;

    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicance_usage);

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mNext = (Button)findViewById(R.id.next);
        mInput = (EditText)findViewById((R.id.input));


        updateQuestion();

        //Start of Button Listener for Button1
        mNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here
                if(!mInput.getText().toString().isEmpty()){
                    File path = getApplicationContext().getFilesDir();
                    File applianceHistory = new File(path, "applianceRating.txt");
                    String prevUsage = "";

                    try
                    {
                        System.out.println("Checking old file");
                        System.out.println("--------------------------------------------");
                        int length = (int)applianceHistory.length();
                        byte[] usageInBytes = new byte[length];
                        //File readRatingHistory = new File ("ratingHistory.txt");
                        FileInputStream read = new FileInputStream(applianceHistory);
                        //BufferedReader bReader = new BufferedReader(new InputStreamReader(read));
                        //StringBuilder sb = new StringBuilder();
                        read.read(usageInBytes);
                        prevUsage += new String(usageInBytes);
                        System.out.println("Old file contains : " + prevUsage);
                        read.close();
                    }
                    catch (Exception e)
                    {
                        System.out.println("--------------------------------------------");
                        System.out.println("Opening file not working");
                        System.out.println("--------------------------------------------");
                    }

                    try
                    {
                        FileOutputStream write = new FileOutputStream(applianceHistory);
                        //PrintWriter ratingHistory = new PrintWriter("ratingHistory.txt");
                        String update = prevUsage + " " + mInput.getText().toString();
                        write.write(update.getBytes());
                        System.out.println("--------------------------------------------");
                        System.out.println("File successfully created and stored at " + getFilesDir());
                        System.out.println("--------------------------------------------");
                        write.close();
                        System.out.println();

                    }
                    catch (Exception e)
                    {
                        System.out.println("--------------------------------------------");
                        System.out.println("File not found");
                        System.out.println("--------------------------------------------");
                    }
                    if(mQuestionNumber == mQuestionLibrary.mQuestions.length - 1) {
                        updateQuestion();
                        mInput.setVisibility(View.GONE);
                        mNext.setOnClickListener(new View.OnClickListener() {
                                                     @Override
                                                     public void onClick(View v) {
                                                         openMain();
                                                     }
                                                 }

                        );
                    }
                    else {
                        updateQuestion();

                    }
                }
                else if(mQuestionNumber == mQuestionLibrary.mQuestions.length - 1) {
                    updateQuestion();
                    mInput.setVisibility(View.GONE);
                    mNext.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     openMain();
                                                 }
                                             }

                    );
                }
                else {
                    updateQuestion();

                }

            }
        });






    }

    private void updateQuestion(){
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mQuestionNumber++;
        mInput.setText("");
        if(mQuestionNumber == mQuestionLibrary.mQuestions.length - 1)
            mNext.setText("SUBMIT");
        else if (mQuestionNumber == mQuestionLibrary.mQuestions.length)
            mNext.setText("FINISH");
    }


    /*private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }*/

    private void openMain() {
        Intent main = new Intent(this, MainActivity.class );
        startActivity(main);
    }
}