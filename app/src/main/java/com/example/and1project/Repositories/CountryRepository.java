package com.example.and1project.Repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.and1project.Connection.Apis.CountryApi;
import com.example.and1project.Connection.Responses.CountryResponse;
import com.example.and1project.Connection.ServiceGenerator;
import com.example.and1project.Entities.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryRepository {

    private static CountryRepository instance;

    private MutableLiveData<Country> country;

    private CountryRepository() {

        country = new MutableLiveData<>();


    }

    public static synchronized CountryRepository getInstance() {
        if (instance == null) {
            instance = new CountryRepository();
        }
        return instance;
    }

    public void updateCountry(String name) {

        CountryApi reportApi = ServiceGenerator.getCountryApi();
        Call<List<CountryResponse>> call = reportApi.getCountry(name);
        call.enqueue(new Callback<List<CountryResponse>>() {
            @Override
            public void onResponse(Call<List<CountryResponse>> call, Response<List<CountryResponse>> response) {
                if (response.code() == 200) {
                    country.setValue(response.body().get(0).getCountry());
                }
            }
            @Override
            public void onFailure(Call<List<CountryResponse>> call, Throwable t) {
                Log.i("Country", "Something went wrong " + t.getMessage());
            }
        });
    }

    public LiveData<Country> getCountry() {
        return country;
    }



}
