package com.example.droidcaffe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayToast(String messager){
        Toast.makeText(getApplicationContext(), messager, Toast.LENGTH_SHORT).show();
    }

    public void showDonut(View view){
        displayToast(getString(R.string.tst_donut));
    }

    public void showIce (View view){
        displayToast(getString(R.string.tst_ice));
    }

    public void showMor (View view){
        displayToast(getString(R.string.tst_mor));
    }

}
