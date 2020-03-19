package com.example.codelabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class textoInfinito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto_infinito);
    }

    public void Okey(View view) {
        Toast.makeText(this, "Okey", Toast.LENGTH_SHORT).show();
    }
}
