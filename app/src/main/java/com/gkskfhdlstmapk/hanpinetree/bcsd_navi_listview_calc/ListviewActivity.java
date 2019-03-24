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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        init();
        mListView = (ListView)findViewById(R.id.activity_listview_listview);

        ListAdapter adapter = new ListAdapter();
        adapter.addItem(new ListItem("김이름"));

       // mListView.setAdapter(adapter); Intent로 연결시킨 페이지라 그런건지 뭔지 모르겠으뮤ㅠ 코드는 정상적인데 자꾸 여기서 죽음..
        //혹시 몰라서 다시 철저하게 지켜가며 만들어봤는데도 이러는 거 보면 뭔가 문제가 있는 것 같아 근데 앞에서 쓴 방법으로 넣으면 또 잘들어가는게 함정이야 ㅠㅠ 눈물주륵,,,


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
