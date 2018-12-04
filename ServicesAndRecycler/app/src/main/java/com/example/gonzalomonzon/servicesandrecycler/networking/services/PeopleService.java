package com.example.gonzalomonzon.servicesandrecycler.networking.services;

import com.example.gonzalomonzon.servicesandrecycler.Model.Person;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PeopleService
{
    @GET("5c06c41d3300004d19ef2bf3")
    Call<ArrayList<Person>> getPersons();

}
