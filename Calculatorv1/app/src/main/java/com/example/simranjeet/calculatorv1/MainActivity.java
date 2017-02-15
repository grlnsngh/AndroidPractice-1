package com.example.simranjeet.calculatorv1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int arrId[] = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8,
            R.id.btn9, R.id.btn10, R.id.btn11, R.id.btn12, R.id.btn13, R.id.btn14, R.id.btn15, R.id.btn16,
            R.id.btn17, R.id.btn18};
    TextView textView;
    Button arrButtons[];
    double a, b, total;
    boolean example=false,example2=true;
    String operator;
    String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrButtons = new Button[arrId.length];
        textView = (TextView) findViewById(R.id.textView);
        for (int i = 0; i < arrId.length; i++) {
            arrButtons[i] = (Button) findViewById(arrId[i]);
            arrButtons[i].setOnClickListener(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        textView.setText("BYE! BYE! BYE! !!!");
    }

    @Override
    public void onClick(View view) {
        String str1, str2;
        textView.setHint("");
        switch (view.getId()) {
            case R.id.btn1:   //+
                if (example==false) {
                    str+= "+";
                    textView.setText(str);
                } else {
                    operator = "+";
                    str1 = textView.getText().toString();   //converting value of textView into string
                    a = Double.parseDouble(str1);             //converting string into double
                    str = "";
                    textView.setText(str);
                    example=false;
                }
                break;
            case R.id.btn2:    //-
                if (example==false) {
                    str+= "-";
                    textView.setText(str);
                } else {
                    operator = arrButtons[1].getText().toString();
                    str1 = textView.getText().toString();
                    a = Double.parseDouble(str1);
                    str = "";
                    textView.setText(str);
                    example=false;
                }
                break;
            case R.id.btn3:    //*
                operator = arrButtons[2].getText().toString();
                str1 = textView.getText().toString();
                a = Double.parseDouble(str1);
                str = "";
                textView.setText(str);
                example=false;
                break;
            case R.id.btn4:    //divide
                operator = arrButtons[3].getText().toString();
                str1 = textView.getText().toString();
                a = Double.parseDouble(str1);
                str = "";
                textView.setText(str);
                example=false;
                break;
            case R.id.btn5:
                example=true;
                str += "7";
                textView.setText(str);
                break;
            case R.id.btn6:
                example=true;
                str += "8";
                textView.setText(str);
                break;
            case R.id.btn7:
                example=true;
                str += "9";
                textView.setText(str);
                break;
            case R.id.btn8:
                str = "";
                textView.setText(str);
                break;
            case R.id.btn9:
                example=true;
                str += "4";
                textView.setText(str);
                break;
            case R.id.btn10:
                example=true;
                str += "5";
                textView.setText(str);
                break;
            case R.id.btn11:
                example=true;
                str += "6";
                textView.setText(str);
                break;
            case R.id.btn12:                                        //DEL
                str = textView.getText().toString();
                String temp1 = "";
                for (int i = 0; i < str.length() - 1; i++) {
                    temp1 += str.charAt(i);
                }
                str = temp1;
                textView.setText(str);
                break;
            case R.id.btn13:
                example=true;
                str += "1";
                textView.setText(str);
                break;
            case R.id.btn14:
                example=true;
                str += "2";
                textView.setText(str);
                break;
            case R.id.btn15:
                example=true;
                str += "3";
                textView.setText(str);
                break;
            case R.id.btn16:
                str += ".";
                textView.setText(str);
                break;
            case R.id.btn17:
                str += "0";
                textView.setText(str);
                break;
            case R.id.btn18:
                switch (operator) {
                    case "+":
                        str2 = textView.getText().toString();       //converting value of textView into string
                        b = Double.parseDouble(str2);           //converting string into double
                        total = a + b;
                        str2 = Double.toString(total);             //converting double value into string
                        textView.setText(str2);
                        str = "";
//                temp=total;
                        //Toast.makeText(this, str2, Toast.LENGTH_SHORT).show();   (for checking purpose)
                        //textView.setText(sum);
                        break;
                    case "-":
                        str2 = textView.getText().toString();
                        b = Double.parseDouble(str2);
                        total = a - b;
                        str2 = Double.toString(total);
                        textView.setText(str2);
                        str = "";
//                temp=total;
                        break;
                    case "X":
                        str2 = textView.getText().toString();
                        b = Double.parseDouble(str2);
                        total = a * b;
                        str2 = Double.toString(total);
                        textView.setText(str2);
                        str = "";
//                temp=total;
                        break;
                    case "/":
                        str2 = textView.getText().toString();
                        b = Double.parseDouble(str2);
                        total = a / b;
                        str2 = Double.toString(total);
                        textView.setText(str2);
                        str = "";
//                temp=total;
                        break;
                }
                //break;
        }
    }
}
