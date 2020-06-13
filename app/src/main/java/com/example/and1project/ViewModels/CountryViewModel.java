package com.example.and1project.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.and1project.Entities.Country;
import com.example.and1project.Repositories.CountryRepository;

public class CountryViewModel extends AndroidViewModel {
private CountryRepository repository;


    public CountryViewModel(@NonNull Application application) {
        super(application);
        repository = CountryRepository.getInstance();
    }

    public void updateCountry(String name){

        repository.updateCountry(name);
    }

    public LiveData<Country> getCountry(){

        return repository.getCountry();
    }
}
