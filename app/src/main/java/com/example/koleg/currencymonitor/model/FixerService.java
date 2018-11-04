package com.example.koleg.currencymonitor.model;

import com.example.koleg.currencymonitor.model.Fixer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FixerService {
    @GET("/{date}?access_key=4b479ee6f95af54359b6cb3a434ceb88")
    Call<Fixer> listFixers(@Path("date")String date);
}
