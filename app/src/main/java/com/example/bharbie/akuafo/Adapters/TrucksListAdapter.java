package com.example.bharbie.akuafo.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bharbie.akuafo.Ads;
import com.example.bharbie.akuafo.R;
import com.example.bharbie.akuafo.Truck;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by BHARBIE on 4/22/2017.
 */

public class TrucksListAdapter extends ArrayAdapter<Truck> {

    private Activity context;
    private int resource;
    private List<Truck> trucksList;

    @Override
    public int getCount() {return trucksList.size();}

    @Override
    public View getView(int position, View convertView, ViewGroup parent){


        if(convertView==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            convertView= layoutInflater.inflate(resource,parent,false);
        }
        Truck truck = trucksList.get(position);
        ImageView imageViewTrucksList = (ImageView) convertView.findViewById(R.id.list_view_trucks_image);
        TextView textViewTruckDriveList = (TextView)convertView.findViewById(R.id.list_item_trucks_sender);
        TextView textViewSizeList = (TextView)convertView.findViewById(R.id.list_view_trucks_size);
        TextView textViewModelList = (TextView)convertView.findViewById(R.id.list_view_trucks_model);
        TextView textViewTrucksDateList = (TextView)convertView.findViewById(R.id.list_view_trucks_date);

        textViewModelList.setText(truck.getModel());
        Picasso.with(context).load(truck.image).into(imageViewTrucksList);
        textViewSizeList.setText(truck.getSize());
        textViewTruckDriveList.setText(truck.getUserFire().getName());
        textViewTrucksDateList.setText(truck.getDate());

        return convertView;

    }


    public TrucksListAdapter(Activity context,int resource,List<Truck> ads) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.trucksList = ads;
    }

}
