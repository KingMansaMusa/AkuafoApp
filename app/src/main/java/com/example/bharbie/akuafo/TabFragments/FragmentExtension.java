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

import com.example.bharbie.akuafo.Activities.ExtensionListItemShowActivity;
import com.example.bharbie.akuafo.Activities.PostExtensionActivity;
import com.example.bharbie.akuafo.Activities.TruckListItemShowActivity;
import com.example.bharbie.akuafo.Adapters.AdsListAdapter;
import com.example.bharbie.akuafo.Adapters.ExtensionListAdapter;
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

public class FragmentExtension extends Fragment {

    private DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_extension,container,false);

        final ProgressBar progressBar = (ProgressBar)view.findViewById(R.id.progressBar);

        FloatingActionButton floatingActionButton = (FloatingActionButton)view.findViewById(R.id.extension_floating_add_item);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();
                user.getUser();

                if (user == null){

                    Toast.makeText(getActivity(),"Please Login before you can post an add",Toast.LENGTH_LONG).show();
                } else if (user.getType() != "Extension"){
                Toast.makeText(getActivity(), "Please Login as an Extension Officer and try again ", Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(getActivity(), PostExtensionActivity.class);
                    startActivity(intent);
                }

            }
        });

        ListView listViewExtensionInfo = (ListView) view.findViewById(R.id.list_view_extension);
        final List<ExtensionInfo> extensionInfos= new ArrayList<>();

progressBar.setVisibility(View.VISIBLE);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("ExtensionTable");
        Query adsQuery = databaseReference;
        adsQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    ExtensionInfo extensionInfo1 = dataSnapshot1.getValue(ExtensionInfo.class);


                    ExtensionInfo extensionInfo = new ExtensionInfo(extensionInfo1.getId(),extensionInfo1.getHeading(),extensionInfo1.getUseFiler(),extensionInfo1.getInfo(),extensionInfo1.getDate());
                    extensionInfos.add(extensionInfo);
                }
                progressBar.setVisibility(View.GONE);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        ExtensionListAdapter extensionListAdapter = new ExtensionListAdapter(getActivity(),R.layout.extension_list_item, extensionInfos);
        listViewExtensionInfo.setAdapter(extensionListAdapter);

        listViewExtensionInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ExtensionInfo extensionInfo = extensionInfos.get(position);

                String name = extensionInfo.getUseFiler().getName();
                String heading = extensionInfo.getHeading();
                String info = extensionInfo.getInfo();
                String date = extensionInfo.getDate();

                Intent intent = new Intent(getActivity(),ExtensionListItemShowActivity.class);
                intent.putExtra("heading",heading);
                intent.putExtra("date",date);
                intent.putExtra("name",name);
                intent.putExtra("info",info);
                startActivity(intent);
            }
        });


        return view;
    }
}
