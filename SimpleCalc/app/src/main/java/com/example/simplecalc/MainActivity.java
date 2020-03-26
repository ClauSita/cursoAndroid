package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText v1,v2;
    TextView res;
    Integer int_v1, int_v2, int_res;
    String str_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v1 = (EditText)findViewById(R.id.et_v1);
        v2 = (EditText)findViewById(R.id.et_v2);
        res = (TextView)findViewById(R.id.tv_res);

        String str_v1, str_v2;

        str_v1 = v1.getText().toString();
        str_v2 = v2.getText().toString();


        int_v1 = Integer.parseInt(str_v1);
        int_v2 = Integer.parseInt(str_v2);

    }

    public void btnSuma(View view) {
        int_res = int_v1 + int_v2;

        str_res = String.valueOf(int_res);
        res.setText(str_res);

    }

    public void btnMult(View view) {
        int_res = int_v1 * int_v2;

        str_res = String.valueOf(int_res);
        res.setText(str_res);
    }

    public void btnResta(View view) {
        int_res = int_v1 - int_v2;

        str_res = String.valueOf(int_res);
        res.setText(str_res);
    }

    public void btnDiv(View view) {
        int_res = int_v1 / int_v2;

        str_res = String.valueOf(int_res);
        res.setText(str_res);
    }
}
