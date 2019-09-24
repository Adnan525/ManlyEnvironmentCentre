package com.muntasir.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

public class QuizAudit extends AppCompatActivity {

    private PamphletQuestions mQuestionLibrary = new PamphletQuestions();


//    private TextView mScoreView;
//    private Button mButtonChoice1;
//    private String mAnswer;

    private TextView mQuestionView;
    private Button mYes;
    private Button mNo;
    private int mScore = 0;
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
            try
            {
                FileOutputStream ratingHistory = null;
                ratingHistory = openFileOutput("ratingHistory.txt", MODE_PRIVATE);
                ratingHistory.write(mScore);
                System.out.println("--------------------------------------------");
                System.out.println("File successfully created");
                System.out.println(getFilesDir());


//                PrintWriter ratingHistory = new PrintWriter("ratingHistory.txt", "UTF-8");
//                ratingHistory.println(mScore);
//                ratingHistory.close();

            }
            catch (Exception e)
            {
                System.out.println("--------------------------------------------");
                System.out.println("File not found");
                System.out.println(getFilesDir());
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
