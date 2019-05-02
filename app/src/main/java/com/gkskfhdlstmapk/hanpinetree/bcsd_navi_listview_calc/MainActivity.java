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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.activity_main_open_button)
    Button mOpenButton;
    @BindView(R.id.activity_main_close_button)
    Button mCloseButton;
    @BindView(R.id.activity_main_lock_checkbox)
    CheckBox mLockCheckbox;
    @BindView(R.id.activity_main_drawer)
    DrawerLayout drawerLayout;
    @BindView(R.id.activity_main_drawer_listview)
    ListView mDrawerListView;

    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();

        final String[] items = {"SimpleListView","Calculator","Timer"};
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
