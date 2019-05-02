package com.gkskfhdlstmapk.hanpinetree.bcsd_navi_listview_calc;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimerActivity extends AppCompatActivity {

    private TextView mTextView ;
    private Button mStart, mPause, mReset ;
    private long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L ;
    private Handler handler;
    private int Seconds, Minutes, MilliSeconds ;
    private ListView listView ;
    private String[] ListElements = new String[] {  };
    private List<String> ListElementsArrayList ;
    private ArrayAdapter<String> adapter ;
    private int once = 0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        mTextView = (TextView)findViewById(R.id.activity_timer_time_textview);
        mStart = (Button)findViewById(R.id.activity_timer_start_button);
        mPause = (Button)findViewById(R.id.activity_timer_pause_button);
        mReset = (Button)findViewById(R.id.activity_timer_reset_button);
        listView = (ListView)findViewById(R.id.activity_timer_listview);

        handler = new Handler() ;

        ListElementsArrayList = new ArrayList<String>(Arrays.asList(ListElements));

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                ListElementsArrayList
        );

        listView.setAdapter(adapter);

        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable,0);

                mReset.setEnabled(false);

            }
        });

        mPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimeBuff += MillisecondTime;

                handler.removeCallbacks(runnable);

                mReset.setEnabled(true);

            }
        });

        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MillisecondTime = 0L ;
                StartTime = 0L ;
                TimeBuff = 0L ;
                UpdateTime = 0L ;
                Seconds = 0 ;
                Minutes = 0 ;
                MilliSeconds = 0 ;

                mTextView.setText("00:00:00");

                ListElementsArrayList.clear();

                adapter.notifyDataSetChanged();
            }
        });

    }

    public Runnable runnable = new Runnable() {

        public void run() {

            MillisecondTime = SystemClock.uptimeMillis() - StartTime;

            UpdateTime = TimeBuff + MillisecondTime;

            Seconds = (int) (UpdateTime / 1000);

            Minutes = Seconds / 60;

            Seconds = Seconds % 60;

            MilliSeconds = (int) (UpdateTime % 1000);

            mTextView.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%02d", MilliSeconds));

            if((int)(UpdateTime / 1000) % 10 == 0 && (int)(UpdateTime / 1000) / 10 > once){
                ListElementsArrayList.add(Minutes+":"+String.format("%02d", Seconds)+":000");
                once++;
            }

            handler.postDelayed(this, 0);
        }

    };

}