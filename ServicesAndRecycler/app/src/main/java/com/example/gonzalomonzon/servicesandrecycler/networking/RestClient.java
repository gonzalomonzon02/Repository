package com.example.gonzalomonzon.servicesandrecycler.networking;

import com.example.gonzalomonzon.servicesandrecycler.networking.services.PeopleService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private String BASE_URL="http://www.mocky.io/v2/";
    private static RestClient instance;
    private PeopleService peopleService;

    private RestClient(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        peopleService=retrofit.create(PeopleService.class);
    }
    public static RestClient getInstance(){
        if (instance==null){
            instance=new RestClient();
        }
        return instance;
    }
    public PeopleService getPeopleService(){
        return peopleService;
    }


}
