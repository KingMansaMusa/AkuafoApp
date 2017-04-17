package com.example.bharbie.akuafo.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bharbie.akuafo.R;

/**
 * Created by BHARBIE on 4/16/2017.
 */

public class FragmentAdsAndInfo extends Fragment {

    public FragmentAdsAndInfo(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ads_and_info,container,false);

        return view;
    }
}
