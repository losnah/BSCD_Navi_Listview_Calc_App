package com.gkskfhdlstmapk.hanpinetree.bcsd_navi_listview_calc;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener {

    private StringBuilder mUpdateText;
    private TextView mUpdateTextview;

    private Button mButton0;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    private Button mButtonResult;
    private Button mButtonCE;

    private Button mButtonPlus;
    private Button mButtonMinus;
    private Button mButtonMulti;
    private Button mButtonDiv;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        init();

    }

    private void init(){
        mContext = getApplicationContext();
        mButton0 = (Button)findViewById(R.id.activity_calc_0_button);
        mButton1 = (Button)findViewById(R.id.activity_calc_1_button);
        mButton2 = (Button)findViewById(R.id.activity_calc_2_button);
        mButton3 = (Button)findViewById(R.id.activity_calc_3_button);
        mButton4 = (Button)findViewById(R.id.activity_calc_4_button);
        mButton5 = (Button)findViewById(R.id.activity_calc_5_button);
        mButton6 = (Button)findViewById(R.id.activity_calc_6_button);
        mButton7 = (Button)findViewById(R.id.activity_calc_7_button);
        mButton8 = (Button)findViewById(R.id.activity_calc_8_button);
        mButton9 = (Button)findViewById(R.id.activity_calc_9_button);
        mButtonResult = (Button)findViewById(R.id.activity_calc_result_button);
        mButtonCE = (Button)findViewById(R.id.activity_calc_CE_button);

        mButtonPlus = (Button)findViewById(R.id.activity_calc_plus_button);
        mButtonMinus = (Button)findViewById(R.id.activity_calc_minus_button);
        mButtonMulti = (Button)findViewById(R.id.activity_calc_multi_button);
        mButtonDiv = (Button)findViewById(R.id.activity_calc_div_button);

        mUpdateText = new StringBuilder("");
        mUpdateTextview = (TextView)findViewById(R.id.activity_calc_result_textview);
        mUpdateTextview.setText(mUpdateText);

        mButton0.setOnClickListener(this);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);
        mButton7.setOnClickListener(this);
        mButton8.setOnClickListener(this);
        mButton9.setOnClickListener(this);
        mButtonResult.setOnClickListener(this);
        mButtonCE.setOnClickListener(this);

        mButtonPlus.setOnClickListener(this);
        mButtonMinus.setOnClickListener(this);
        mButtonMulti.setOnClickListener(this);
        mButtonDiv.setOnClickListener(this);

    }

    public int calculaeResult(StringBuilder str){

        StringTokenizer st = new StringTokenizer(str.toString());
        int result = 0;
        int count = 0;
        int a = 0; int b; char op;
        while(st.hasMoreTokens()) {
                if(count == 0) a = Integer.parseInt(st.nextToken());
                else a = result;

                op = st.nextToken().charAt(0);
                if(op == '=') break;
                b = Integer.parseInt(st.nextToken());
                result = calc(a,op,b);
                count++;
        }
        return result;


    }
    public static int calc(int a, char op, int b) {
        switch(op) {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
        }
        return -1;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_calc_0_button:
                mUpdateText.append("0");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_1_button:
                mUpdateText.append("1");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_2_button:
                mUpdateText.append("2");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_3_button:
                mUpdateText.append("3");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_4_button:
                mUpdateText.append("4");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_5_button:
                mUpdateText.append("5");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_6_button:
                mUpdateText.append("6");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_7_button:
                mUpdateText.append("7");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_8_button:
                mUpdateText.append("8");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_9_button:
                mUpdateText.append("9");
                mUpdateTextview.setText(mUpdateText);
                break;
                //activity_calc_plus_button
            case R.id.activity_calc_plus_button:
                mUpdateText.append(" + ");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_minus_button:
                mUpdateText.append(" - ");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_multi_button:
                mUpdateText.append(" x ");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_div_button:
                mUpdateText.append(" / ");
                mUpdateTextview.setText(mUpdateText);
                break;

            case R.id.activity_calc_CE_button:
               mUpdateText.setLength(0);
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_result_button:
                int calResult = calculaeResult(mUpdateText);
                mUpdateTextview.setText(calResult+"");
                break;

        }
    }
}
