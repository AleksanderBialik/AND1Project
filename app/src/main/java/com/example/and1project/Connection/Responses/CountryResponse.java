package com.example.and1project.Connection.Responses;

import com.example.and1project.Entities.Country;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CountryResponse implements Serializable {

    @SerializedName("name")
    private String name;
    @SerializedName("capital")
    private String capital;
    @SerializedName("region")
    private String region;
    @SerializedName("population")
    private int population;
    @SerializedName("flag")
    private String flag;

    public Country getCountry() {

        return new Country(name,capital,region,population,flag);

    }
}
