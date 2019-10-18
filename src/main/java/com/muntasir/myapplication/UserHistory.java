package com.muntasir.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UserHistory extends AppCompatActivity {

    private Button applianceHistory;


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
    }

    private void openApplianceHistory() {
        Intent userApplianceHistory = new Intent(this, ApplianceAnswers.class );
        startActivity(userApplianceHistory);
    }
}
