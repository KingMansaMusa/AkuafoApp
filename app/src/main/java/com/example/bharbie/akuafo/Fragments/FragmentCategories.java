package com.example.bharbie.akuafo.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.bharbie.akuafo.R;

/**
 * Created by BHARBIE on 4/16/2017.
 */

public class FragmentCategories extends Fragment {

    public FragmentCategories(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_categories,container,false);

        LinearLayout   fruitsAndVegetables = (LinearLayout)view.findViewById(R.id.fruits_and_vegetable);
        fruitsAndVegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Fruits and Vegetables";
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("category",text);
                bundle.putBoolean("isCategory",true);
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentProfile.setArguments(bundle);
                fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                fragmentTransaction.commit();
            }
        });

        LinearLayout   grainsAndBeans = (LinearLayout)view.findViewById(R.id.grains_and_beans);
        grainsAndBeans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Grains and Beans";
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("category",text);
                bundle.putBoolean("isCategory",true);
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentProfile.setArguments(bundle);
                fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                fragmentTransaction.commit();
            }
        });

        LinearLayout   rootsAndTubers = (LinearLayout)view.findViewById(R.id.roots_and_tubers);
        rootsAndTubers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Roots and Tubers";
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("category",text);
                bundle.putBoolean("isCategory",true);
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentProfile.setArguments(bundle);
                fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                fragmentTransaction.commit();
            }
        });

        LinearLayout   livestock = (LinearLayout)view.findViewById(R.id.livestock);
        livestock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Livestock";
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("category",text);
                bundle.putBoolean("isCategory",true);
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentProfile.setArguments(bundle);
                fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                fragmentTransaction.commit();
            }
        });

        LinearLayout   dairy = (LinearLayout)view.findViewById(R.id.dairy);
        dairy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Dairy";
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("category",text);
                bundle.putBoolean("isCategory",true);
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentProfile.setArguments(bundle);
                fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                fragmentTransaction.commit();
            }
        });

        LinearLayout   oilsAndButter = (LinearLayout)view.findViewById(R.id.oils_and_butter);
        oilsAndButter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Oils and Butter";
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("category",text);
                bundle.putBoolean("isCategory",true);
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentProfile.setArguments(bundle);
                fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                fragmentTransaction.commit();
            }
        });

        LinearLayout   spicesAndHerbs = (LinearLayout)view.findViewById(R.id.spices_and_herbs);
        spicesAndHerbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Spices and Herbs";
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("category",text);
                bundle.putBoolean("isCategory",true);
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentProfile.setArguments(bundle);
                fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
