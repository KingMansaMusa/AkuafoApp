package com.example.bharbie.akuafo.TabFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bharbie.akuafo.Activities.PostTrucksActivity;
import com.example.bharbie.akuafo.Adapters.AdsListAdapter;
import com.example.bharbie.akuafo.Adapters.TrucksListAdapter;
import com.example.bharbie.akuafo.Ads;
import com.example.bharbie.akuafo.ExtensionInfo;
import com.example.bharbie.akuafo.R;
import com.example.bharbie.akuafo.Truck;
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

public class FragmentTrucks extends Fragment {


    private DatabaseReference databaseReference;
    private ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trucks,container,false);

       // Bundle bundle = getArguments();
        //String name = bundle.getString("");


        databaseReference = FirebaseDatabase.getInstance().getReference().child("TruckTable");

        FloatingActionButton floatingActionButton = (FloatingActionButton)view.findViewById(R.id.trucks_floating_add_item);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();
                user.getUser();

                if (user == null){

                    Toast.makeText(getActivity(),"Please Login before you can post an add",Toast.LENGTH_LONG).show();


                }

                Intent intent = new Intent(getActivity(), PostTrucksActivity.class);
                startActivity(intent);
            }
        });


        ListView listViewTrucks = (ListView) view.findViewById(R.id.list_view_trucks);
        final List<Truck> trucks= new ArrayList<>();



        databaseReference = FirebaseDatabase.getInstance().getReference().child("ExtensionTable");
        Query adsQuery = databaseReference;
        adsQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Truck truck = dataSnapshot1.getValue(Truck.class);

                    Truck truck1 = new Truck(truck.getId(),truck.getUserFire(),truck.getImage(),truck.getModel(),truck.getSize(),truck.getRegNo(),truck.getDate(),truck.getPhone());
                    trucks.add(truck1);
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        TrucksListAdapter trucksListAdapter = new TrucksListAdapter(getActivity(),R.layout.trucks_list_item, trucks);
        listViewTrucks.setAdapter(trucksListAdapter);

        return  view;
    }
}
