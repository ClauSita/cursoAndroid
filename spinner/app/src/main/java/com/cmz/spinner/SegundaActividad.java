package com.cmz.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaActividad extends AppCompatActivity {

    private TextView tv2;
    private EditText mail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        tv2 = (TextView)findViewById(R.id.txtv2);
        mail = (EditText)findViewById(R.id.et_mail);


        String dato = getIntent().getStringExtra("dato");

        tv2.setText("Hola " + dato);

        SharedPreferences preferences = getSharedPreferences("userData", Context.MODE_PRIVATE);
        mail.setText(preferences.getString("mail", ""));


    }


    //Metodo para guardar preferencias
    public void Guardar(View view){
        SharedPreferences preferencias = getSharedPreferences("userData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("mail", mail.getText().toString());
        editor.commit();
        finish();


    }


    // Metodo para regresar a la actividad anterior
    public void anterior (View view) {
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }


}
