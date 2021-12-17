package com.example.retrofit_sullivana6;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://ghibliapi.herokuapp.com/vehicles/";
    @GET("https://ghibliapi.herokuapp.com/vehicles/")
    Call<List<Results>> getVehicle();
}
