package com.example.gonzalomonzon.servicesandrecycler.controllers;


import com.example.gonzalomonzon.servicesandrecycler.Model.Person;
import com.example.gonzalomonzon.servicesandrecycler.networking.RestClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class ApiController {

    public static Call<ArrayList<Person>> getPersons(Callback<ArrayList<Person>> callback){
        Call<ArrayList<Person>> getPersonsCall=RestClient.getInstance().getPeopleService().getPersons();

        getPersonsCall.enqueue(callback);
        return getPersonsCall;
    }
}
