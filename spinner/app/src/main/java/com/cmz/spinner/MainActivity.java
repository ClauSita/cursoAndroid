package com.cmz.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2, et3;
    private TextView tv1;
    private Spinner sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.ed1);
        et2 = (EditText)findViewById(R.id.ed2);
        et3 = (EditText)findViewById(R.id.et_nombre);

        tv1 = (TextView)findViewById(R.id.textView);
        sp1 = (Spinner)findViewById(R.id.spinner);


        String [] opciones = {"sumar","resta","multiplicar","dividir"};

        ArrayAdapter<String> adap = new ArrayAdapter<String>(this,R.layout.spinner_item_list, opciones);
        sp1.setAdapter(adap);

    }
    public void Calcular(View view){
        String v1_str = et1.getText().toString();
        String v2_str =et2.getText().toString();
        String res_str;
        String seleccion = sp1.getSelectedItem().toString();

        int v1 = Integer.parseInt(v1_str);
        int v2 = Integer.parseInt(v2_str);
        int res;

        if(seleccion.equals("sumar")){
            res = v1 + v2;
            res_str = String.valueOf(res);
            tv1.setText(res_str);

        }else if(seleccion.equals("resta")){
            res = v1 - v2;
            res_str = String.valueOf(res);
            tv1.setText(res_str);
        }else if(seleccion.equals("multiplicar")){
            res = v1 * v2;
            res_str = String.valueOf(res);
            tv1.setText(res_str);
        }else if(seleccion.equals("dividir")){
            res = v1 / v2;
            res_str = String.valueOf(res);
            tv1.setText(res_str);
        }



    }

    public void Siguiente(View view){
        Intent siguiente = new Intent(this, SegundaActividad.class);
        siguiente.putExtra("dato", et3.getText().toString());
        startActivity(siguiente);
    }

}
