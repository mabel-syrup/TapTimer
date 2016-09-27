package com.surber.matthew.taptimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> times = new ArrayList<>();
        final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Button timeButton = (Button) findViewById(R.id.time_button);
        final ArrayAdapter<String> timeListAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, times);
        final ListView timeList = (ListView) findViewById(R.id.time_list);
        timeList.setAdapter(timeListAdapter);

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new Date() seems to be the only thing that actually gives the current time.  Calendar seems to just keep the initial time.
                times.add(timeFormat.format(new Date()));
                timeListAdapter.notifyDataSetChanged();
            }
        });
    }
}
