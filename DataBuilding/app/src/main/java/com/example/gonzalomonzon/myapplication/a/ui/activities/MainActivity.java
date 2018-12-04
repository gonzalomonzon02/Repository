package com.example.gonzalomonzon.myapplication.a.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.gonzalomonzon.myapplication.R;
import com.example.gonzalomonzon.myapplication.a.ui.activities.Activity_Recycler;
import com.example.gonzalomonzon.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding mainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainBinding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Activity_Recycler.class);
                startActivity(intent);

            }
        });
    }

}
