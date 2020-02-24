package com.cmz.calculadoraCompleta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;
    private RadioButton rb1, rb2, rb3, rb4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        tv1 = (TextView)findViewById(R.id.txtView);
        rb1 = (RadioButton)findViewById(R.id.rB_suma);
        rb2 = (RadioButton)findViewById(R.id.rB_resta);
        rb3 = (RadioButton)findViewById(R.id.rB_div);
        rb4 = (RadioButton)findViewById(R.id.rB_mult);

    }

    public void Calcular(View view){
        String v1_str = et1.getText().toString();
        String v2_str = et2.getText().toString();
        String res_str;

        int v1_int = Integer.parseInt(v1_str);
        int v2_int = Integer.parseInt(v2_str);

        int res_int;


        if(rb1.isChecked()==true){
            res_int = v1_int + v2_int;

            res_str=String.valueOf(res_int);

            tv1.setText(res_str);
        }else if(rb2.isChecked()==true){
            res_int = v1_int - v2_int;

            res_str=String.valueOf(res_int);

            tv1.setText(res_str);
        }else if(rb3.isChecked()==true){
            res_int = v1_int / v2_int;

            res_str=String.valueOf(res_int);

            tv1.setText(res_str);
        }else if (rb4.isChecked()==true){
            res_int = v1_int * v2_int;

            res_str=String.valueOf(res_int);

            tv1.setText(res_str);
        }
    }

}
