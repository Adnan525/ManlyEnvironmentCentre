package com.muntasir.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class QuizAudit extends AppCompatActivity {

    private PamphletQuestions mQuestionLibrary = new PamphletQuestions();


//    private TextView mScoreView;
//    private Button mButtonChoice1;
//    private String mAnswer;

    private TextView mQuestionView;
    private Button mYes;
    private Button mNo;
    private Integer mScore = 0;
    private int mQuestionNumber = -1;  //set to -1 since onCreate() increases the number by 1 while starting

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_audit);

       // mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mYes = (Button)findViewById(R.id.yesButton);
        mNo = (Button)findViewById(R.id.noButton);

        updateQuestion();

        //button yes will get 1 point

        //Yes button listener
        mYes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                    mScore = mScore + 1;
                    updateQuestion();
                    //This line of code is optiona
                    //Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

//                else {
//                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
//                    updateQuestion();
//                }
            }
        });


        //No button listener
        //no point
        mNo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                updateQuestion();
            }
        });
    }

    private void updateQuestion(){
        mQuestionNumber++;

        //System.out.println(mScore);

        if(mQuestionNumber == mQuestionLibrary.getQuestions().length)
        {
            File path = getApplicationContext().getFilesDir();
            File ratingHistory = new File(path, "ratingHistory.txt");
            String prevUsage = "";


            try
            {
                System.out.println("Checking old file");
                System.out.println("--------------------------------------------");
                int length = (int)ratingHistory.length();
                byte[] usageInBytes = new byte[length];
                //File readRatingHistory = new File ("ratingHistory.txt");
                FileInputStream read = new FileInputStream(ratingHistory);
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
                System.out.println("Opeinig file not working");
                System.out.println("--------------------------------------------");
            }

            try
            {
                FileOutputStream write = new FileOutputStream(ratingHistory);
                //PrintWriter ratingHistory = new PrintWriter("ratingHistory.txt");
                String update = prevUsage + " " + mScore.toString();
                write.write(update.getBytes());
                //write.write("Score to save = someInt val".getBytes());
                System.out.println("--------------------------------------------");
                System.out.println("File successfully created and stored at " + getFilesDir());
                System.out.println("--------------------------------------------");
                write.close();
                System.out.println();

//                PrintWriter ratingHistory = new PrintWriter("ratingHistory.txt", "UTF-8");
//                ratingHistory.println(mScore);
//                ratingHistory.close();

            }
            catch (Exception e)
            {
                System.out.println("--------------------------------------------");
                System.out.println("File not found");
                System.out.println("--------------------------------------------");
            }
            //System.out.println(mScore);
            Intent showScore = new Intent(this, ShowScore.class);
            showScore.putExtra("score", mScore);
            startActivity(showScore);
        }
        else
        {
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        }

    }


//    private void updateScore(int point) {
//        mScoreView.setText("" + mScore);
//    }
}