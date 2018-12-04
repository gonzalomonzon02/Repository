package com.example.gonzalomonzon.servicesandrecycler.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.gonzalomonzon.servicesandrecycler.Model.Person;
import com.example.gonzalomonzon.servicesandrecycler.R;
import com.example.gonzalomonzon.servicesandrecycler.adapter.adapterPerson;
import com.example.gonzalomonzon.servicesandrecycler.controllers.ApiController;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListPeople extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    ProgressBar progressBar;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_people);

        progressBar=findViewById(R.id.progress);
        mRecyclerView=findViewById(R.id.recyclerListPeople);

        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        ApiController.getPersons(new Callback<ArrayList<Person>>() {
            @Override
            public void onResponse(Call<ArrayList<Person>> call, Response<ArrayList<Person>> response) {
                progressBar.setVisibility(View.GONE);
                if(response.isSuccessful()){
                    ArrayList<Person>persons=response.body();
                    mAdapter= new adapterPerson(persons);
                    mRecyclerView.setAdapter(mAdapter);
                    mRecyclerView.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(ListPeople.this,"ERROR",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Person>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(ListPeople.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
