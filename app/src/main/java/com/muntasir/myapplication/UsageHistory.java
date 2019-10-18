package com.muntasir.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UsageHistory extends AppCompatActivity {

    public TextView mRatingHistory;
    public TextView mApplianceHistory;
    public Button graphButton;
    String rating = "";
    String date = this.getDate();

    //data
    String[] usageArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usage_history);
        try
        {
            File path = getApplicationContext().getFilesDir();
            File ratingHistory = new File(path, "ratingHistory.txt");

            System.out.println("Printing usage history");
            System.out.println("--------------------------------------------");
            int length = (int)ratingHistory.length();
            byte[] usageInBytes = new byte[length];
            //File readRatingHistory = new File ("ratingHistory.txt");
            FileInputStream read = new FileInputStream(ratingHistory);
            //BufferedReader bReader = new BufferedReader(new InputStreamReader(read));
            //StringBuilder sb = new StringBuilder();
            read.read(usageInBytes);
            rating += new String(usageInBytes);
            System.out.println(rating);
            read.close();
        }
        catch (Exception e)
        {
            System.out.println("--------------------------------------------");
            System.out.println("Opeinig file not working");
            System.out.println("--------------------------------------------");
        }
        mRatingHistory = (TextView) findViewById(R.id.ratingHistory);
        mRatingHistory.setText(this.getUsage());

        graphButton = (Button) findViewById(R.id.graphButton);
        graphButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getGraph();
            }
        });
    }

    public String getUsage()
    {
        int startPosition = 1;
        String str = "";
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("Text file contains : "+ rating);
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        usageArr = rating.split(" ");
        if(usageArr.length > 21) //more than 10 //strated with empty string
        {
            startPosition = usageArr.length - 19;
        }
        for(int i = startPosition; i <= usageArr.length - 2; i+=2)
        {
           str += "Audit performed on " + usageArr[i] + ", Score : " + usageArr[i + 1] + "\n";   //have to check what's wromg
        }
        return str;
    }

    public String getDate()
    {
        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MMM-yyyy");
        return dFormat.format(currentDate);
    }

    public void getGraph()
    {
        Intent graph = new Intent(this, Graph.class);
        graph.putExtra("usage", usageArr);
        startActivity(graph);
    }
}
