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
    String dating = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance_answers);
        try
        {
            File path = getApplicationContext().getFilesDir();
            File ratingHistory = new File(path, "applianceRating.txt");

            File path2 = getApplicationContext().getFilesDir();
            File dateThing = new File(path2, "date.txt");

            System.out.println("Printing usage history");
            System.out.println("--------------------------------------------");
            int length = (int)ratingHistory.length();
            byte[] usageInBytes = new byte[length];
            FileInputStream read = new FileInputStream(ratingHistory);
            read.read(usageInBytes);
            rating += new String(usageInBytes);
            System.out.println(rating);
            read.close();

            int length2 = (int)dateThing.length();
            byte[] usageInBytes2 = new byte[length2];
            FileInputStream read2 = new FileInputStream(dateThing);
            read2.read(usageInBytes2);
            dating += new String(usageInBytes2);
            System.out.println(dating);
            read2.close();
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
        String[] dateList = dating.split(" ");
        int prev = usageArray.length - 18;
        int last = usageArray.length - 9;
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
            auditDate.setText(this.getDate(0));
            usageData.setText((this.getUsage(1)));
            applianceName2.setVisibility(View.GONE);
            auditDate2.setVisibility(View.GONE);
            usageData2.setVisibility(View.GONE);
        }
        else{
            auditDate.setText(this.getDate(prev));
            auditDate2.setText((this.getDate(last)));
            applianceName.setText(this.getName());
            applianceName2.setText(this.getName());
            usageData.setText(this.getUsage(prev));
            usageData2.setText(this.getUsage(last));
            System.out.println(usageArray.length);
            System.out.println(dateList.length);
        }

    }

    public String getUsage(int a)
    {

        String usageStr = "";
        String[] usageArr = rating.split(" ");


        for(int i = a; i < a + 9; i++){
            usageStr += usageArr[i] + " minutes" + "\n";
        }


        return usageStr;
    }

    public String getName()
    {
        String nameStr = "Car" + "\n" + "Microwave" + "\n" + "Oven" + "\n" + "Electronic stove" + "\n" + "Kettle" + "\n" + "TV" + "\n" + "Iron" + "\n" + "Hair dyer" + "\n" + "Air con/heater" + "\n";
        return nameStr;
    }



    public String getDate(int a){

        String[] dateList = dating.split(" ");
        String ret;
        if(a == 0){
             ret = dateList[2] + " " + "Attempt: " + ((a / 9) + 1);
        }
        else{
            ret = dateList[a] + " " + "Attempt: " + ((a / 9) + 1);
        }
        return ret;


    }

}
