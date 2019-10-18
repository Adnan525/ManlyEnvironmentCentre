package com.muntasir.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.muntasir.myapplication.UsageHistory.*;

import java.util.ArrayList;

public class graph extends AppCompatActivity {

    DataPoint[] plotArr;

    public DataPoint[] getPlots(String[] arr)
    {
        int startPosition = 1;

        if(arr.length > 19) //more than 10
        {
            startPosition = arr.length - 19;
        }
        int tracker = 1;
        ArrayList<DataPoint> temp = new ArrayList<>();
        for(int i = startPosition; i <= arr.length - 2; i+=2)
        {
            temp.add(new DataPoint(tracker, Integer.parseInt(arr[i+1])));
            tracker++;
        }

        DataPoint[] plotArr = temp.toArray(new DataPoint[temp.size()]);

        return plotArr;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        GraphView graph = (GraphView) findViewById(R.id.graph);

        //scrolling
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(1);
        graph.getViewport().setMaxX(5);

        //y bound
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMaxY(50);

        graph.getViewport().setScrollable(true);


        Intent check = getIntent();
        if(check.hasExtra("usage"))
        {
            System.out.println("Plots found");
            String[] usageFromText = check.getStringArrayExtra("usage");
            plotArr = getPlots(usageFromText);
        }

        LineGraphSeries<DataPoint> plots = new LineGraphSeries<>(plotArr);
        graph.addSeries(plots);
        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter()
        {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if(isValueX)
                    return "A " + super.formatLabel(value, isValueX);
                return super.formatLabel(value, isValueX);
            }
        });
    }
}
