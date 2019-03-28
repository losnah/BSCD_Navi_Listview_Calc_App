package com.gkskfhdlstmapk.hanpinetree.bcsd_navi_listview_calc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListItemView extends LinearLayout {

    TextView mViewText;
    public ListItemView(Context context) {
        super(context);

        init(context);
    }

    public ListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.listview_item, this, true);

        mViewText = (TextView)findViewById(R.id.listview_item_textview);//객체화된 listview_item내의 mViewTextView를 가져오는 것이므로 이를 뒤에 둡니다.

    }

    public void setName(String name){
        mViewText.setText(name);
    }
}
