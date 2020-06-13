package com.example.and1project.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.ahmadrosid.svgloader.SvgLoader;
import com.example.and1project.R;
import com.example.and1project.ViewModels.CountryViewModel;



public class AddCountryFragment extends Fragment {

    Button button;
    EditText country;
    TextView name, capital, population,region;
    ImageView flag;
    CountryViewModel viewModel;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_country, container, false);

        viewModel = new ViewModelProvider(this).get(CountryViewModel.class);
        button = view.findViewById(R.id.button);
        country = view.findViewById(R.id.country);
        name = view.findViewById(R.id.name);
        capital = view.findViewById(R.id.capital);
        population = view.findViewById(R.id.population);
        region = view.findViewById(R.id.region);
        flag = view.findViewById(R.id.flag);




        button.setOnClickListener(v -> {
            String name = country.getText().toString();
            viewModel.updateCountry(name);
            country.setText("");

        });

        viewModel.getCountry().observe(getViewLifecycleOwner(), country -> {

            name.setText(country.getName());
            capital.setText(country.getCapital());
            population.setText(String.valueOf(country.getPopulation()));
            region.setText(country.getRegion());


            SvgLoader.pluck()
                    .with(getActivity())
                    .load(country.getFlag(), flag);

        });



        return view;
    }



}
