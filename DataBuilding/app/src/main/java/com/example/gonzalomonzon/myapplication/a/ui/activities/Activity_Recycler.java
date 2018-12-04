package com.example.gonzalomonzon.myapplication.a.ui.activities;

import android.app.Person;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gonzalomonzon.myapplication.R;
import com.example.gonzalomonzon.myapplication.a.Model.Persona;
import com.example.gonzalomonzon.myapplication.a.ui.adapters.AdapterPersonas;

import java.util.ArrayList;

public class Activity_Recycler extends AppCompatActivity {


    private ArrayList<Persona> listPer;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__recycler);
        listPer=new ArrayList<>();
        crearPer();

        mRecyclerView=findViewById(R.id.recycler);

        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter= new AdapterPersonas(listPer);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void crearPer() {
        Persona p1=new Persona("Diego","398686565");
        Persona p2=new Persona("Pedro","4545545");
        Persona p3=new Persona("Juan","324544");
        Persona p4=new Persona("Julian","656565");
        Persona p5=new Persona("Claudio","213313");
        Persona p6=new Persona("asdasd","21");
        listPer.add(p1);
        listPer.add(p2);
        listPer.add(p3);
        listPer.add(p4);
        listPer.add(p5);
        listPer.add(p6);

    }

}
