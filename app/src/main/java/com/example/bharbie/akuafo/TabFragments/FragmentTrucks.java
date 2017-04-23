package com.example.bharbie.akuafo.TabFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.bharbie.akuafo.Adapters.AdsListAdapter;
import com.example.bharbie.akuafo.Adapters.TrucksListAdapter;
import com.example.bharbie.akuafo.Ads;
import com.example.bharbie.akuafo.R;
import com.example.bharbie.akuafo.Truck;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BHARBIE on 4/20/2017.
 */

public class FragmentTrucks extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trucks,container,false);

        ListView listViewTrucks = (ListView) view.findViewById(R.id.list_view_trucks);
        List<Truck> trucks= new ArrayList<>();



        TrucksListAdapter trucksListAdapter = new TrucksListAdapter(getActivity(),R.layout.trucks_list_item, trucks);
        listViewTrucks.setAdapter(trucksListAdapter);

        return  view;
    }
}
