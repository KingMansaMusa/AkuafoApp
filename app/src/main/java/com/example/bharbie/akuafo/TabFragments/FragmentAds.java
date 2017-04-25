package com.example.bharbie.akuafo.TabFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.bharbie.akuafo.Activities.AdsListItemShowActivity;
import com.example.bharbie.akuafo.Activities.PostAdsFirstActivity;
import com.example.bharbie.akuafo.Activities.PostAdsSecondActivity;
import com.example.bharbie.akuafo.Adapters.AdsListAdapter;
import com.example.bharbie.akuafo.Ads;
import com.example.bharbie.akuafo.R;
import com.example.bharbie.akuafo.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BHARBIE on 4/20/2017.
 */

public class FragmentAds extends Fragment {
    private DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ads, container, false);
        final ProgressBar progressBar = (ProgressBar)view.findViewById(R.id.progressBar);

        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.ads_floating_add_item);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.getUser();

                if (user == null) {

                    Toast.makeText(getActivity(), "Please Login before you can post an add", Toast.LENGTH_LONG).show();


                }else if (user.getType() != "Farmer"){
                    Toast.makeText(getActivity(), "Please Login as a Farmer and try again ", Toast.LENGTH_LONG).show();


                }else { Intent intent = new Intent(getActivity(), PostAdsFirstActivity.class);
                    startActivity(intent);
                }



            }
        });


       // Bundle bundle = getArguments();
        //boolean isLocation = bundle.getBoolean("isLocation");
        ListView listViewAds = (ListView) view.findViewById(R.id.list_view_ads);
        final List<Ads> ads = new ArrayList<>();
        progressBar.setVisibility(View.VISIBLE);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("AdsTable");
        Query adsQuery = databaseReference;
        //if (isLocation) {
         //   String text = bundle.getString("location");
           // adsQuery.equalTo("location",text);
        //}
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


        listViewAds.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Ads adsItem = ads.get(position);

                String caption = adsItem.getCaption();
                String price = adsItem.getPrice();
                String name = adsItem.getUser().getName();
                String description = adsItem.getDescription();
                String location = adsItem.getLocation();
                String category = adsItem.getCategory();
                String quantity = adsItem.getQuantity();
                String verified_by = adsItem.getVerifiedBy();
                String phone = adsItem.getPhone();
                String image = adsItem.getImage();



                Intent intent = new Intent(getActivity(),AdsListItemShowActivity.class);
                intent.putExtra("price",price);
                intent.putExtra("caption",caption);
                intent.putExtra("description",description);
                intent.putExtra("image",image);
                intent.putExtra("name",name);
                intent.putExtra("quantity",quantity);
                intent.putExtra("phone",phone);
                intent.putExtra("location",location);
                intent.putExtra("category",category);
                intent.putExtra("verified",verified_by);
                startActivity(intent);

            }
        });


        return view;
    }
}
