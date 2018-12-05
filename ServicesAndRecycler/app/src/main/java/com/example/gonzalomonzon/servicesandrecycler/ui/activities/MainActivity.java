package com.example.gonzalomonzon.servicesandrecycler.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gonzalomonzon.servicesandrecycler.R;
import com.example.gonzalomonzon.servicesandrecycler.databinding.ActivityMainBinding;
import com.example.gonzalomonzon.servicesandrecycler.ui.dialogs.LayoutDialog;

public class MainActivity extends AppCompatActivity {

    private Button btnOk,btnCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding  mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        btnOk=mBinding.mainBtnOk;
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ListPeople.class);
                startActivity(intent);
            }
        });

        btnCalendar=mBinding.mainBtnDate;
        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LayoutDialog(v.getContext());
            }
        });
    }
}
