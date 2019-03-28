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
//        LinkedList<Integer> numList = new LinkedList<Integer>(); //숫자관련
//        LinkedList<Character> opList = new LinkedList<Character>(); //연산자 관련
//
//        String s =str.toString();
//
//        String num = ""; //연사자 외에 숫자들을 임시 저장할 곳
//
//        for(int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i); //string을 char 타입 단위로 나눔
//
//            if(ch == '+' || ch =='-' || ch == '*' || ch == '/') {
//                numList.add(Integer.parseInt(num)); //숫자로 바꿔서 숫자배열에 추가
//                opList.add(ch); //연산자를 연산자배열에 추가
//                num = ""; //임시로 저장된 숫자를 비워준다
//                continue; //제일 가까운 명령문으로 이동
//            }
//            num += ch; //연산자 앞까지의 숫자를 임시로 넣어 놓음
//        }
//        numList.add(Integer.parseInt(num)); //마지막 숫자
//
//        while(!opList.isEmpty()) { //연산자배열이 빌 때까지
//            int prevNum = numList.poll(); //poll : 앞부터 완전히 뺀다
//            int nextNum = numList.poll();
//            char op = opList.poll();
//
//            if(op == '+') {
//                numList.addFirst(prevNum + nextNum); //addFirst 배열 제일 앞에 넣는다
//            } else if(op == '-') {
//                numList.addFirst(prevNum - nextNum);
//            } else if(op == '*') {
//                numList.addFirst(prevNum * nextNum);
//            } else if(op == '/') {
//                numList.addFirst(prevNum / nextNum);
//            }
//        }
//        return numList.poll();

/*
        int result = 0;
        int intBuffer = 0;

        StringTokenizer st = new StringTokenizer(str.toString());
        String stringBuffer = st.nextToken();

       while (st.hasMoreTokens()){
            switch (stringBuffer){
                case "+":
                    intBuffer = intBuffer + Integer.parseInt(st.nextToken());
                    break;
                case "-":
                    break;
                case "x":
                    break;
                case "/":
                    break;

                    default:
                        intBuffer = Integer.parseInt(stringBuffer);
                        break;
            }
        }

*/
        return 1;


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
                calculaeResult(mUpdateText);
                mUpdateTextview.setText(mUpdateText);
                break;

        }
    }
}
