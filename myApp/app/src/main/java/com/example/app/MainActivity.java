package com.example.app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS = 600000;
    private TextView mTxtVwCountDown;
    private Button btnStart, btnRestart;

    private CountDownTimer mCountDown;

    private boolean mTimerRunning;

    private long mTimeLeft = START_TIME_IN_MILLIS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtVwCountDown = findViewById(R.id.txt_contdown);

        btnStart = findViewById(R.id.btn_start);
        btnRestart = findViewById(R.id.btn_restart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTimerRunning){
                    pauseTimer();
                }else {
                    startTimer();
                }

            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });

        upCT();



    }

    private void resetTimer() {
        mTimeLeft = START_TIME_IN_MILLIS;
        upCT();
        btnRestart.setVisibility(View.INVISIBLE);
    }

    private void startTimer() {
        mCountDown = new CountDownTimer(mTimeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeft = millisUntilFinished;
                upCT();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                btnStart.setText(R.string.start);
                btnStart.setVisibility(View.INVISIBLE);
            }
        }.start();

        mTimerRunning = true;
        btnStart.setText("Pausa");
        btnRestart.setVisibility(View.INVISIBLE);
        btnRestart.setVisibility(View.VISIBLE);


    }

    private void upCT() {
        int minutes = (int) (mTimeLeft / 1000)/60;
        int seconds = (int) (mTimeLeft/1000)%60;

        String timeLeftStr = String.format("%02d:%02d", minutes, seconds);

        mTxtVwCountDown.setText((timeLeftStr));
    }

    private void pauseTimer() {
        mCountDown.cancel();
        mTimerRunning = false;
        btnStart.setText(R.string.start);
        btnRestart.setVisibility(View.INVISIBLE);

    }

    public void onSalir(View view) {
        /*
        * Con esto puedes cerrar la app
        * System.exit(0);
        *
        */
//        Crear la alerta
        AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
//        Crear el título y el mensaje
        myAlertBuilder.setTitle("Alerta");
        myAlertBuilder.setMessage("Click OK to continue, or CANCEL to stop:");
//        Añadir botones
        myAlertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                Al precionar OK
                Toast.makeText(getApplicationContext(),"Pressed ok", Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
            }
        });
        myAlertBuilder.setNeutralButton("tal vez", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Tal vez presionado", Toast.LENGTH_SHORT).show();
            }
        });

        myAlertBuilder.show();

    }

    public void onShowDate(View view) {
        DialogFragment newFrgamnt = new FragmentDatePicker();
        newFrgamnt.show(getSupportFragmentManager(), "dataPicker");
    }

    public void processDatePickerResult(int year, int month, int day){
        String monthstr = Integer.toString(month+1);
        String daystr = Integer.toString(day);
        String yearstr = Integer.toString(year);

        String dateMessage = (daystr + "/" + monthstr + "/" + yearstr);

        Toast.makeText(this, "Fecha: " + dateMessage, Toast.LENGTH_SHORT).show();


    }

}
