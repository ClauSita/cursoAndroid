package com.example.codelabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class recibir extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.codelabs.extra.REPLAY";
    TextView txtMostrar;
    EditText txtRespuesta;
    String resp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibir);
        Intent inttento = getIntent();
        String mensaje = inttento.getStringExtra(Enviar.EXTRA_MESSAGE);

        txtMostrar = (TextView)findViewById(R.id.msn_mostrar);
        txtRespuesta = (EditText)findViewById(R.id.ed_m_respuesta);

        resp = txtRespuesta.getText().toString();


        txtMostrar.setText(mensaje);

    }

    public void irToast(View view) {
        Intent irToas = new Intent(this, MainActivity.class);
        startActivity(irToas);
    }

    public void respuesta(View view) {
        Intent respu  = new Intent();
        respu.putExtra(EXTRA_REPLY, resp);
        setResult(RESULT_OK,respu);
        setResult(RESULT_CANCELED, respu);
        finish();
    }
}
