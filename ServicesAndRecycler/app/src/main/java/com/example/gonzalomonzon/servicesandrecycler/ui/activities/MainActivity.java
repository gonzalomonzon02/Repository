package com.example.gonzalomonzon.servicesandrecycler.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gonzalomonzon.servicesandrecycler.R;
import com.example.gonzalomonzon.servicesandrecycler.ui.dialogs.LayoutDialog;

public class MainActivity extends AppCompatActivity {

    private Button btnOk,btnCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOk=findViewById(R.id.main_btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ListPeople.class);
                startActivity(intent);
            }
        });

        btnCalendar=findViewById(R.id.main_btnDate);
        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LayoutDialog(v.getContext());
            }
        });
    }
}
