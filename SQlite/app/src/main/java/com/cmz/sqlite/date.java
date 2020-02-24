package com.cmz.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class date extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private TextView txt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        txt = (TextView)findViewById(R.id.textDate);

        //Asigna el boton
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //abre el dialogo de calendairo
                DialogFragment datePicker = new DatePickUpFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });




    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        //esta es la fecha elegida
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String currentDateString = DateFormat.getDateInstance().format(c.getTime());



        txt.setText(currentDateString);



    }
}
