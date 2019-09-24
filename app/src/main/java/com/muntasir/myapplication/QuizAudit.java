package com.muntasir.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizAudit extends AppCompatActivity {

    private PamphletQuestions mQuestionLibrary = new PamphletQuestions();

    //private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;

    //private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_audit);

       // mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);

        updateQuestion();

        //button 1 will get 1 point
        //button 2 will get 2 point
        //button 3 will get 3 point
        //button 4 will get 4 point

        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here
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

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mScore = mScore + 2;
                updateQuestion();
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mScore = mScore + 3;
                updateQuestion();
            }
        });

        //End of Button Listener for Button3





    }

    private void updateQuestion(){

        System.out.println(mScore);

        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
        mQuestionNumber++;

        //mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);

        if(mQuestionNumber == mQuestionLibrary.getQuestions().length)
        {
            //System.out.println(mScore);
            Intent showScore = new Intent(this, ShowScore.class);
            showScore.putExtra("score", mScore);
            startActivity(showScore);
        }
    }


//    private void updateScore(int point) {
//        mScoreView.setText("" + mScore);
//    }
}
