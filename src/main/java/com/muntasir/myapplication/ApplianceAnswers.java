package com.muntasir.myapplication;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ApplianceAnswers extends AppCompatActivity {

    public TextView usageData;
    public TextView applianceName;
    public TextView auditDate;
    public TextView usageData2;
    public TextView applianceName2;
    public TextView auditDate2;
    String rating = "";
    String date = this.getDate();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance_answers);
        try
        {
            File path = getApplicationContext().getFilesDir();
            File ratingHistory = new File(path, "applianceRating.txt");

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
        usageData = (TextView) findViewById(R.id.usage);
        applianceName = (TextView) findViewById(R.id.name);
        auditDate = (TextView) findViewById(R.id.date);

        usageData2 = (TextView) findViewById(R.id.usage2);
        applianceName2 = (TextView) findViewById(R.id.name2);
        auditDate2 = (TextView) findViewById(R.id.date2);
        String[] usageArray = rating.split(" ");
        if(usageArray.length == 1){
            applianceName.setVisibility(View.GONE);
            auditDate.setText("You have not answered any appliance usage questions yet");
            usageData.setVisibility(View.GONE);
            applianceName2.setVisibility(View.GONE);
            auditDate2.setVisibility(View.GONE);
            usageData2.setVisibility(View.GONE);
        }
        else if(usageArray.length == 10){
            applianceName.setText(this.getName());
            auditDate.setText(this.getDate());
            usageData.setText((this.getUsage()));
        }

    }

    public String getUsage()
    {

        String usageStr = "";
        String[] usageArr = rating.split(" ");


        for(int i = 1; i < 10; i++){
            usageStr += usageArr[i] + " minutes" + "\n";
        }


        return usageStr;
    }

    public String getName()
    {
        String nameStr = "Car" + "\n" + "Microwave" + "\n" + "Oven" + "\n" + "Electronic stove" + "\n" + "Kettle" + "\n" + "TV" + "\n" + "Iron" + "\n" + "Hair dyer" + "\n" + "Air con/heater" + "\n";
        return nameStr;
    }



    public String getDate()
    {
        String[] usageArr = rating.split(" ");
        if (usageArr.length == 1) {
            String dateStr = "You have not answered any appliance usage questions yet";
            return dateStr;
        }
        else {
            Date currentDate = Calendar.getInstance().getTime();
            SimpleDateFormat dFormat = new SimpleDateFormat("dd-MMM-yyyy");
            return dFormat.format(currentDate);
        }
    }

}
