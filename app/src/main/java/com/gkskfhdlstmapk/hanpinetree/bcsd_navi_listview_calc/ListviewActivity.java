package com.gkskfhdlstmapk.hanpinetree.bcsd_navi_listview_calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class ListviewActivity extends AppCompatActivity {
    private EditText mInputEdittext;
    private Button mPlusButton;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        init();


    }

    private void init(){
        mInputEdittext = (EditText)findViewById(R.id.activity_listview_edittext);
        mPlusButton = (Button)findViewById(R.id.activity_listview_plus_button);
        mListView = (ListView)findViewById(R.id.activity_listview_listview);

    }

}
