package com.example.bharbie.akuafo.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.bharbie.akuafo.R;

public class TruckListItemShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck_list_item_show);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setTitleTextColor(ContextCompat.getColor(TruckListItemShowActivity.this, R.color.back_color));
        //toolbar.setTitle("Ads and Info");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button buttonCallTruckDriver = (Button)findViewById(R.id.button_call_truck_driver);

        buttonCallTruckDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent("android.intent.action.DIAL");
                callIntent.setData(Uri.parse("0207969269"));
                startActivity(callIntent);
            }
        });

    }
}
