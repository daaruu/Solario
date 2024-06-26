package com.example.solario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class customAdapter extends ArrayAdapter<Planet> {

    private ArrayList<Planet> planetArrayList;
    Context context;

    public customAdapter(ArrayList<Planet> planetArrayList, Context context1) {
        super(context1, R.layout.item_list, planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context1;
    }

    private static class MyViewHolder{
        TextView planetName;
        TextView moonCount;
        ImageView planetImg;
    }

    // Override the getView method.
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Planet planet = getItem(position);  // Return the object at that position.

        // Inflate the Layout
        MyViewHolder myViewHolder;
        final View result;

        if(convertView == null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list,
                    parent,
                    false
            );

            // Finding Views

            myViewHolder.moonCount = (TextView)convertView.findViewById(R.id.moonCount);
            myViewHolder.planetName = (TextView)convertView.findViewById(R.id.planet_name);
            myViewHolder.planetImg = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;

            //Set Tag and get tag
            convertView.setTag(myViewHolder);
        }else { // when the convertview exists and we will recycle
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }

        myViewHolder.planetName.setText(planet.getPlanetName());
        myViewHolder.moonCount.setText(planet.getMoonCount());
        myViewHolder.planetImg.setImageResource(planet.getPlanetImage());

        return result;
    }
}

