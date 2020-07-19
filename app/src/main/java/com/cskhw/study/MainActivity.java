package com.cskhw.study;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.cskhw.study.navigation.BottomNavigationActivity;
import com.cskhw.study.recycler.RecyclerActivity;
import com.cskhw.study.viewpager.ViewPagerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.activity_main_button1);
        Button button2 = findViewById(R.id.activity_main_button2);
        Button button3 = findViewById(R.id.activity_main_button3);
        final Intent viewPagerIntent = new Intent(this, ViewPagerActivity.class);
        final Intent bottomNavigationIntent = new Intent(this, BottomNavigationActivity.class);
        final Intent recyclerIntent = new Intent(this, RecyclerActivity.class);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(viewPagerIntent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(bottomNavigationIntent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(recyclerIntent);
            }
        });
    }
}
