package com.example.gonzalomonzon.servicesandrecycler.networking.services;

import com.example.gonzalomonzon.servicesandrecycler.Model.Person;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PeopleService
{
    @GET("5c0565e93300005f00e8126b")
    Call<ArrayList<Person>> getPersons();

}
