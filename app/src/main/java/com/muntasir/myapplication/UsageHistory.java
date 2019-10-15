package com.muntasir.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UsageHistory extends AppCompatActivity {

    public TextView mRatingHistory;
    public TextView mApplianceHistory;
    String rating = "";
    String date = this.getDate();
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
    }

    public String getUsage()
    {
        int startPosition = 0;
        String str = "";
        String[] usageArr = rating.split(" ");
        if(usageArr.length > 10)
        {
            startPosition = usageArr.length - 11;
        }
        for(int i = startPosition; i <= usageArr.length -1; i++)
        {
           str += "Audit performed on " + date + ", Score : " + usageArr[i] + "\n";
        }
        return str;
    }

    public String getDate()
    {
        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MMM-yyyy");
        return dFormat.format(currentDate);
    }

}
