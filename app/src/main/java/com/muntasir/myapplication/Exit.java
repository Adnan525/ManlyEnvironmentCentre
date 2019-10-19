package com.muntasir.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Exit extends AppCompatActivity {
    private Button exitButton;
    private Button exitButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);

        exitButton = (Button) findViewById(R.id.exitOne);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //killActivity();
                finish();
            }
        });

        exitButton2 = (Button) findViewById(R.id.exitTwo);
        exitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                openMain();

            }
        });
    }

    private void openMain(){
        Intent userMain = new Intent(this, MainActivity.class);
        startActivity(userMain);
    }

    private void killActivity() {
//        finish();
//        System.exit(0);
        final AlertDialog.Builder builder = new AlertDialog.Builder(Exit.this);
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
