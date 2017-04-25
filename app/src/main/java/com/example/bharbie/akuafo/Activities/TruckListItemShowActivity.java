package com.example.bharbie.akuafo.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bharbie.akuafo.R;
import com.squareup.picasso.Picasso;

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

        Intent intent = getIntent();

        final String image = intent.getStringExtra("image");

        final String model = intent.getStringExtra("model");
        final String regNo = intent.getStringExtra("regNo");
        final String phone = intent.getStringExtra("phone");
        final String name = intent.getStringExtra("name");
        final String size = intent.getStringExtra("size");
        final String date = intent.getStringExtra("date");


        ImageView imageView = (ImageView)findViewById(R.id.truck_list_item_image);
        Picasso.with(TruckListItemShowActivity.this).load(image).into(imageView);


        TextView textViewModel = (TextView)findViewById(R.id.list_item_truck_model);
        textViewModel.setText(model);

        TextView textViewSize = (TextView)findViewById(R.id.list_item_truck_size);
        textViewSize.setText(size);

        TextView textViewRegNo = (TextView)findViewById(R.id.list_item_truck_reg_no);
        textViewRegNo.setText(regNo);

        TextView textViewName = (TextView)findViewById(R.id.list_item_truck_sender);
        textViewName.setText(name);

        TextView textViewDate = (TextView)findViewById(R.id.list_item_truck_date);
        textViewDate.setText(date);


        Button buttonCallTruckDriver = (Button)findViewById(R.id.button_call_truck_driver);

        buttonCallTruckDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent("android.intent.action.DIAL");
                callIntent.setData(Uri.parse(phone));
                startActivity(callIntent);
            }
        });

    }
}
