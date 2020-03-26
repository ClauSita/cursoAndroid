package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner);
        if (spinner!=null){
            spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner !=null){
            spinner.setAdapter(adapter);
        }
    }

    public void onRadio(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.sameday:
                if(checked)
                    displayToast("Mismo día");
                break;
            case R.id.nextday:
                if(checked)
                    displayToast("Siguiente día");
                break;
            case R.id.pickup:
                if(checked)
                    displayToast("Pick up");
                break;
            case R.id.uff:
                if (checked)
                    displayToast("UPSSI");
                break;
            default:
                break;
        }


    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String spinnerLabel = adapterView.getItemAtPosition(i).toString();
            displayToast(spinnerLabel);

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

}
