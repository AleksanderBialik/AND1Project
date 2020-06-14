package com.example.and1project.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and1project.R;
import com.example.and1project.ViewModels.CountryListViewModel;



public class CountryListFragment extends Fragment {
    CountryListAdapter adapter;
    RecyclerView recyclerView;
    CountryListViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        viewModel = new ViewModelProvider(this).get(CountryListViewModel.class);

        adapter = new CountryListAdapter(getActivity());

        viewModel.getCountry().observe(getViewLifecycleOwner(), country -> {

            adapter.addToList(country);

        });


        recyclerView.setAdapter(adapter);

        return view;
    }


}
