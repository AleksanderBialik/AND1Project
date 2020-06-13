package com.example.and1project.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.and1project.R;
import com.example.and1project.ViewModels.AddCountryViewModel;


import java.util.HashSet;
import java.util.Set;


public class AddCountryFragment extends Fragment {

    Button button;
    EditText country;
    AddCountryViewModel viewModel;
    SharedPreferences preferences;
    Set<String> countrySet;
    Set<String> newSet;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_country, container, false);

        viewModel = new ViewModelProvider(this).get(AddCountryViewModel.class);
        button = view.findViewById(R.id.button);
        country = view.findViewById(R.id.country);
        preferences = getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);
        countrySet = new HashSet<>();


        if (preferences.getStringSet("countryList", null) != null) {
            newSet = preferences.getStringSet("countryList", null);
            for (String country : newSet) {
                viewModel.updateCountry(country);
                countrySet.add(country);
            }
        }



        button.setOnClickListener(v -> {
            String name = country.getText().toString();
            viewModel.updateCountry(name);
            country.setText("");
            countrySet.add(name);

        });

        return view;
    }


    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putStringSet("countryList", countrySet);
        editor.apply();
    }
}
