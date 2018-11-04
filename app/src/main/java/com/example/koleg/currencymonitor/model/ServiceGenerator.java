package com.example.koleg.currencymonitor.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static final String API_URL = "http://data.fixer.io/api/";


    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <S> S createService(Class <S> serviceClass){
        return retrofit.create(serviceClass);
    }
}
