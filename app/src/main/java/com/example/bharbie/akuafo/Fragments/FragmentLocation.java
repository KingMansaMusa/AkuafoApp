package com.example.bharbie.akuafo.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bharbie.akuafo.R;
import com.example.bharbie.akuafo.TabFragments.FragmentAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

/**
 * Created by BHARBIE on 4/16/2017.
 */

public class FragmentLocation extends Fragment {

    public FragmentLocation(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_location,container,false);


        /**final TextView textView = (TextView)view.findViewById(R.id.text_view_login);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = textView.getText().toString();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                Bundle bundle = new Bundle();
                bundle.putString("location",text);
                bundle.putBoolean("isLocation",true);
                FragmentAds fragmentSignUp = new FragmentAds();
                fragmentSignUp.setArguments(bundle);
                fragmentTransaction.replace(R.id.place_holder, fragmentSignUp);
                fragmentTransaction.commit();
            }
        });**/



        final TextView textViewAccra = (TextView) view.findViewById(R.id.accra);
        textViewAccra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                String text = textViewAccra.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("location",text);
                bundle.putBoolean("isLocation",true);
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentProfile.setArguments(bundle);
                fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                fragmentTransaction.commit();

            }
        });

        final TextView textViewAll = (TextView) view.findViewById(R.id.all);
        textViewAccra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                fragmentTransaction.commit();

            }
        });

        final TextView textViewVolta = (TextView) view.findViewById(R.id.volta);
        textViewVolta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                String text = textViewAccra.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("location",text);
                bundle.putBoolean("isLocation",true);
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentProfile.setArguments(bundle);
                fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                fragmentTransaction.commit();

            }
        });

        final TextView textViewCentral = (TextView) view.findViewById(R.id.central);
        textViewCentral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                String text = textViewAccra.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("location",text);
                bundle.putBoolean("isLocation",true);
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentProfile.setArguments(bundle);
                fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                fragmentTransaction.commit();

            }
        });

        final TextView textViewEastern = (TextView) view.findViewById(R.id.eastern);
        textViewEastern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                String text = textViewEastern.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("location",text);
                bundle.putBoolean("isLocation",true);
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentProfile.setArguments(bundle);
                fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                fragmentTransaction.commit();

            }
        });

        final TextView textViewWestern = (TextView) view.findViewById(R.id.western);
        textViewAccra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                String text = textViewAccra.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("location",text);
                bundle.putBoolean("isLocation",true);
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentProfile.setArguments(bundle);
                fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                fragmentTransaction.commit();

            }
        });

        final TextView textViewBrong= (TextView) view.findViewById(R.id.brong);
        textViewAccra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                String text = textViewAccra.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("location",text);
                bundle.putBoolean("isLocation",true);
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentProfile.setArguments(bundle);
                fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                fragmentTransaction.commit();

            }
        });

        final TextView textViewUpperEast = (TextView) view.findViewById(R.id.upper_east);
        textViewAccra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                String text = textViewAccra.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("location",text);
                bundle.putBoolean("isLocation",true);
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentProfile.setArguments(bundle);
                fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                fragmentTransaction.commit();

            }
        });

        final TextView textViewUpperWest = (TextView) view.findViewById(R.id.upper_west);
        textViewAccra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                String text = textViewAccra.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("location",text);
                bundle.putBoolean("isLocation",true);
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentProfile.setArguments(bundle);
                fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                fragmentTransaction.commit();

            }
        });

        final TextView textViewAshanti = (TextView) view.findViewById(R.id.ashanti);
        textViewAccra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                String text = textViewAccra.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("location",text);
                bundle.putBoolean("isLocation",true);
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentProfile.setArguments(bundle);
                fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                fragmentTransaction.commit();

            }
        });

        final TextView textViewNorthern = (TextView) view.findViewById(R.id.north);
        textViewAccra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                String text = textViewAccra.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("location",text);
                bundle.putBoolean("isLocation",true);
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentProfile.setArguments(bundle);
                fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                fragmentTransaction.commit();

            }
        });

        return view;
    }
}
