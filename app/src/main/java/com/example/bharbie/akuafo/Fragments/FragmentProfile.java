package com.example.bharbie.akuafo.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.bharbie.akuafo.Adapters.AdsListAdapter;
import com.example.bharbie.akuafo.Ads;
import com.example.bharbie.akuafo.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BHARBIE on 4/16/2017.
 */

public class FragmentProfile extends Fragment {
    private DatabaseReference databaseReference;

    public  FragmentProfile(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile,container,false);

        final ProgressBar progressBar = (ProgressBar)view.findViewById(R.id.progressBar);

        Bundle bundle = getArguments();
//        boolean isLocation = bundle.getBoolean("isLocation",false);
        ListView listViewAds = (ListView) view.findViewById(R.id.list_view_profile);
        final List<Ads> ads = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("AdsTable");
        Query adsQuery = databaseReference;
       /**
        if (isLocation) {
            String text = bundle.getString("location");
            adsQuery.equalTo("location",text);
        }
        **/
        adsQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Ads ads1 = dataSnapshot1.getValue(Ads.class);


                    Ads ad = new Ads(ads1.getId(), ads1.getUser(), ads1.getImage(), ads1.getCaption(), ads1.getPrice(), ads1.getDescription(), ads1.getLocation(), ads1.getCategory(), ads1.getQuantity(), ads1.getDate(), ads1.getVerifiedBy(), ads1.getPhone());
                    ads.add(ad);
                }
                progressBar.setVisibility(View.GONE);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        AdsListAdapter adsListAdapter = new AdsListAdapter(getActivity(), R.layout.ads_list_item, ads);
        listViewAds.setAdapter(adsListAdapter);

        return view;
    }
}
