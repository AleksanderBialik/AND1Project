package com.example.and1project.Fragments;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.example.and1project.Entities.Country;
import com.example.and1project.R;

import java.util.ArrayList;
import java.util.List;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder> {

    List<Country> countryList = new ArrayList<>();
    Context context;


    public CountryListAdapter (Context context){

        this.context = context;
    }

    @NonNull
    @Override
    public CountryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.country_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            holder.name.setText(countryList.get(position).getName());
            holder.region.setText(countryList.get(position).getRegion());
            holder.capital.setText(countryList.get(position).getCapital());
            holder.population.setText(String.valueOf(countryList.get(position).getPopulation()));

            SvgLoader.pluck()
                .with((Activity) context)
                .load(countryList.get(position).getFlag(), holder.flag);

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public void addToList(Country country){

        countryList.add(country);
    }
    public void removeFromList(int index){

        countryList.remove(index);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, capital, population,region;
        ImageView flag;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            capital = itemView.findViewById(R.id.capital);
            population = itemView.findViewById(R.id.population);
            region = itemView.findViewById(R.id.region);
            flag = itemView.findViewById(R.id.flag);
        }
    }



}



