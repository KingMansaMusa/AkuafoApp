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

import java.util.List;

/**
 * Created by BHARBIE on 4/22/2017.
 */

public class AdsListAdapter extends ArrayAdapter<Ads> {

    private Activity context;
    private int resource;
    private List<Ads> adsList;

    @Override
    public int getCount() {return adsList.size();}

    @Override
    public View getView(int position, View convertView, ViewGroup parent){


        if(convertView==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            convertView= layoutInflater.inflate(resource,parent,false);
        }
        Ads ads = adsList.get(position);
        ImageView imageViewAdsList = (ImageView) convertView.findViewById(R.id.list_view_ads_image);
        TextView textViewAdsCaptionList = (TextView)convertView.findViewById(R.id.list_item_ads_caption);
        TextView textViewAdsPriceList = (TextView)convertView.findViewById(R.id.list_view_ads_price);
        TextView textViewAdsSenderList = (TextView)convertView.findViewById(R.id.list_view_ads_sender);
        TextView textViewAdsDateList = (TextView)convertView.findViewById(R.id.list_view_ads_date);

        textViewAdsCaptionList.setText(ads.getCaption());
        imageViewAdsList.setImageResource(ads.getImage());
        textViewAdsPriceList.setText(ads.getPrice());
        textViewAdsSenderList.setText(ads.getUser().getName());
        textViewAdsDateList.setText(ads.getDate());

        return convertView;

    }


    public AdsListAdapter(Activity context,int resource,List<Ads> ads) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.adsList = ads;
    }
}
