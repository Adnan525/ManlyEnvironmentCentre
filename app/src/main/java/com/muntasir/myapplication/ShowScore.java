package com.muntasir.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;



public class ShowScore extends AppCompatActivity {

    private Button quitButton;
    private TextView mScoreView;
    private TextView mRatingScreen;
    private RatingBar mRating;

    public int numStar = 0;


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
            mRatingScreen = (TextView) findViewById(R.id.ratingScreen);
            mRatingScreen.setText(provideRating(score));
        }

        //rating colour
        mRating = (RatingBar) findViewById(R.id.ratingBar);
        LayerDrawable stars = (LayerDrawable) mRating.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.parseColor("#FFA500"), PorterDuff.Mode.SRC_ATOP); //red
        stars.getDrawable(0).setColorFilter(Color.parseColor("#FFA500"), PorterDuff.Mode.SRC_ATOP); //orange
        stars.getDrawable(0).setColorFilter(Color.parseColor("#FFA500"), PorterDuff.Mode.SRC_ATOP); //yellow

        if(numStar == 0)
        {
            mRating.setVisibility(View.GONE);
        }
        mRating.setNumStars(numStar);

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


    public String provideRating(int i)
    {
        if(i >= 40)
        {
            numStar = 5;
            return "You have a 5 star energy rating!";
        }
        else if (i>=25)
        {
            numStar = 3;
            return "You are doing OK - a 3 star rating!";
        }
        else
        {
            numStar = 0;
            return "You could be an energy drain, try again.";
        }
    }


}