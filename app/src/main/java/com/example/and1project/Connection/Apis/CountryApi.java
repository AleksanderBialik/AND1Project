package com.example.and1project.Connection.Apis;

import com.example.and1project.Connection.Responses.CountryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CountryApi {

    @GET("name/{country}")
    Call<List<CountryResponse>> getCountry(@Path("country") String country);
}
