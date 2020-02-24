package com.cmz.appradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //saber que objetos hay en la pantalla para recivir o enviar informacion.

    private EditText et1,et2;
    private TextView tv_res;

    private RadioButton rb1, rb2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //emparejar variables con componentes

        et1 = (EditText)findViewById(R.id.txt_v1);
        et2 = (EditText)findViewById(R.id.txt_v2);
        tv_res = (TextView)findViewById(R.id.txtV1);
        rb1 = (RadioButton)findViewById(R.id.rBtn1);
        rb2 = (RadioButton)findViewById(R.id.rBtn2);
    }


    public void Calcular(View view){
        String valor1_String = et1.getText().toString();
        String valor2_string = et2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_string);

        if(rb1.isChecked() == true ){
            int suma = valor1_int + valor2_int;

            String resultado = String.valueOf(suma);

            tv_res.setText(resultado);
        }else if(rb2.isChecked() == true) {
            int resta = valor1_int - valor2_int;

            String resultado = String.valueOf(resta);

            tv_res.setText(resultado);
        }


    }
}
