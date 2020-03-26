package com.example.codelabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtCount;
    Toast tst;
    private int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCount = (TextView)findViewById(R.id.txtV_count);
        tst = Toast.makeText(this,R.string.tst_holis, Toast.LENGTH_SHORT);

    }

    public void showToast(View view) {
        tst.show();
    }

    public void countUp(View view) {
        ++count;
        if(txtCount != null)
            txtCount.setText(Integer.toString(count));

    }
}
