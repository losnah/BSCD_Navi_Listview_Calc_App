package com.gkskfhdlstmapk.hanpinetree.bcsd_navi_listview_calc;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mOpenButton;
    private Button mCloseButton;
    private CheckBox mLockCheckbox;
    private DrawerLayout drawerLayout;
    private ListView mDrawerListView;
    Intent intent;

    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        final String[] items = {"A menu","B menu","Timer"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items) ;
        mDrawerListView.setAdapter(adapter) ;


        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                if(position == 0) {
                    intent = new Intent(mContext, ListviewActivity.class);
                }else if(position == 1){
                    intent = new Intent(mContext, CalcActivity.class);
                }
                else {
                   intent = new Intent(mContext, TimerActivity.class);
                }
                startActivity(intent);
            }
        });

    }
    public void init(){
        mOpenButton = (Button)findViewById(R.id.activity_main_open_button);
        mCloseButton = (Button)findViewById(R.id.activity_main_close_button);
        mLockCheckbox = (CheckBox)findViewById(R.id.activity_main_lock_checkbox);
        drawerLayout = (DrawerLayout)findViewById(R.id.activity_main_drawer);
        mDrawerListView = (ListView)findViewById(R.id.activity_main_drawer_listview);
        mContext = getApplicationContext();


        mOpenButton.setOnClickListener(this);
        mCloseButton.setOnClickListener(this);
        mLockCheckbox.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_main_open_button:
                if(!drawerLayout.isDrawerOpen(Gravity.LEFT)){drawerLayout.openDrawer(Gravity.LEFT);}
                break;
            case R.id.activity_main_close_button:
                if(drawerLayout.isDrawerOpen(Gravity.LEFT)){drawerLayout.closeDrawer(Gravity.LEFT);}
                break;
            case R.id.activity_main_lock_checkbox:
                if(mLockCheckbox.isChecked()){
                    if(drawerLayout.isDrawerOpen(Gravity.LEFT))
                        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
                    else drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                }else
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                break;
        }
    }
}
