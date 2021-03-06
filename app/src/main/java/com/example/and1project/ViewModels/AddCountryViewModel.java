package com.example.and1project.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.and1project.Entities.Country;
import com.example.and1project.Repositories.CountryRepository;

public class AddCountryViewModel extends AndroidViewModel {
private CountryRepository repository;


    public AddCountryViewModel(@NonNull Application application) {
        super(application);
        repository = CountryRepository.getInstance();
    }

    public void updateCountry(String name){

        repository.updateCountry(name);
    }
}
