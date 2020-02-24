package com.cmz.cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private EditText et3;

    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.mat);
        et2 = (EditText)findViewById(R.id.esp);
        et3 = (EditText)findViewById(R.id.quim);

        tv1 = (TextView)findViewById(R.id.estado);
    }

        public void Calcular(View view) {
            String mate_s = et1.getText().toString();
            String esp_s = et2.getText().toString();
            String qui_s = et3.getText().toString();

            String res;

            Integer mate_i = Integer.parseInt(mate_s);
            Integer esp_i = Integer.parseInt(esp_s);
            Integer qui_i = Integer.parseInt(qui_s);

            Integer prom;

            prom = (mate_i + esp_i +qui_i)/3;

            if(prom >6){
                tv1.setText("Aprobado con " + prom);
            }else if(prom<6){
                tv1.setText("Reprobado con " + prom);
            }

        }


}
