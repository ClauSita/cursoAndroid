package com.example.tabled;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

//        Crear una instancia te la tabla en el view
        TabLayout tabLayout = findViewById(R.id.tab_layout);
//        Colocar los nombres a cada tabla
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tb1_title));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tb2_title));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tb3_titile));
//        Set the tab to fill the entire layout.
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//
    }
}
