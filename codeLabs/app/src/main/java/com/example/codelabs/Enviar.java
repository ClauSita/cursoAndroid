package com.example.codelabs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Enviar extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.codelabs.extra.MESSAGE";
    public static final int TEXT_REQUEST =1;
    private EditText mMessage;
    private TextView mRespuesta, mResEdo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar);

        mMessage = (EditText)findViewById(R.id.msn_enviar);
        mRespuesta = (TextView)findViewById(R.id.txt_resp);
        mResEdo = (TextView)findViewById(R.id.txt_res_edo);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String reply = data.getStringExtra(recibir.EXTRA_REPLY);
                mRespuesta.setText(reply);
                mRespuesta.setVisibility(View.VISIBLE);
                mResEdo.setVisibility(View.VISIBLE);
                Toast.makeText(this, "llegamos dentro del onAct", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void enviarMensaje(View view) {
        Intent intento = new Intent(this, recibir.class);
        String message = mMessage.getText().toString();
        intento.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(
                intento, TEXT_REQUEST
        );



    }
}
