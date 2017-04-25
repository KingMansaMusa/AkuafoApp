package com.example.bharbie.akuafo.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bharbie.akuafo.ExtensionInfo;
import com.example.bharbie.akuafo.R;
import com.example.bharbie.akuafo.Truck;

import java.util.List;

/**
 * Created by BHARBIE on 4/22/2017.
 */

public class ExtensionListAdapter extends ArrayAdapter {

    private Activity context;
    private int resource;
    private List<ExtensionInfo> extensionInfoList;

    @Override
    public int getCount() {return extensionInfoList.size();}

    @Override
    public View getView(int position, View convertView, ViewGroup parent){


        if(convertView==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            convertView= layoutInflater.inflate(resource,parent,false);
        }
        ExtensionInfo extensionInfo = extensionInfoList.get(position);
        TextView textViewExtensionHeaderList = (TextView)convertView.findViewById(R.id.list_item_extension_heading);
        TextView textViewExtensionOfficerList = (TextView)convertView.findViewById(R.id.list_view_extension_sender);
        TextView textViewExtensionInfoList = (TextView)convertView.findViewById(R.id.list_view_extension_info);


        textViewExtensionHeaderList.setText(extensionInfo.getHeading());
        textViewExtensionOfficerList.setText(extensionInfo.getUseFiler().getName());
        textViewExtensionInfoList.setText(extensionInfo.getInfo());

        return convertView;

    }


    public ExtensionListAdapter(Activity context,int resource,List<ExtensionInfo> ads) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.extensionInfoList = ads;
    }


}
