package com.example.and1project.Connection;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.and1project.Connection.Apis.CountryApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ServiceGenerator {

    private static OkHttpClient client = new OkHttpClient.Builder().build();
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder().
            baseUrl("https://restcountries.eu/rest/v2/").addConverterFactory(GsonConverterFactory.create()).client(client);
    private static Retrofit retrofit = retrofitBuilder.build();

    private static CountryApi countryApi = retrofit.create(CountryApi.class);

    public static CountryApi getCountryApi() {
        return countryApi;
    }


}
