package com.gkskfhdlstmapk.hanpinetree.bcsd_navi_listview_calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListviewActivity extends AppCompatActivity {
    private EditText mInputEdittext;
    private Button mPlusButton;
    private ListView mListView;
    private String editStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        init();
        mListView = (ListView)findViewById(R.id.activity_listview_listview);

        final ListAdapter adapter = new ListAdapter();
        adapter.addItem(new ListItem("김이름"));

        mListView.setAdapter(adapter);

        mPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editStr = mInputEdittext.getText().toString();
                adapter.addItem(new ListItem(editStr));
                adapter.notifyDataSetChanged();
            }
        });


    }

    private void init(){
        mInputEdittext = (EditText)findViewById(R.id.activity_listview_edittext);
        mPlusButton = (Button)findViewById(R.id.activity_listview_plus_button);



    }

    class ListAdapter extends BaseAdapter{
        ArrayList<ListItem> items = new ArrayList<ListItem>();

        public void addItem(ListItem item){
            items.add(item);
        }
        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           ListItemView listItemView = new ListItemView(getApplicationContext());
           ListItem item = items.get(position);

           listItemView.setName(item.getName());
            return listItemView;
        }
    }

}
