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

public class AdsListItemShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads_list_item_show);
        Intent intent = getIntent();

        final String price= intent.getStringExtra("price");
        final String image = intent.getStringExtra("image");

        final String description = intent.getStringExtra("description");
        final String caption = intent.getStringExtra("caption");
        final String verified = intent.getStringExtra("verified");
        final String phone = intent.getStringExtra("phone");
        final String quantity = intent.getStringExtra("quantity");
        final String name = intent.getStringExtra("name");
        final String category = intent.getStringExtra("category");
        final String location = intent.getStringExtra("location");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setTitleTextColor(ContextCompat.getColor(AdsListItemShowActivity.this, R.color.back_color));
        //toolbar.setTitle("Akuafo");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView imageView = (ImageView) findViewById(R.id.ads_list_item_image);
        Picasso.with(AdsListItemShowActivity.this).load(image).into(imageView);



        TextView textViewCategory = (TextView)findViewById(R.id.list_item_ads_show_category);
        textViewCategory.setText(category);

        TextView textViewLocation = (TextView)findViewById(R.id.list_item_ads_show_location);
        textViewLocation.setText(location);

        TextView textViewCaption = (TextView)findViewById(R.id.list_item_ads_show_caption);
        textViewCaption.setText(caption);

        TextView textViewDescription = (TextView)findViewById(R.id.list_item_ads_show_description);
        textViewDescription.setText(description);

        TextView textViewQuantity = (TextView)findViewById(R.id.list_item_ads_show_quantity);
        textViewQuantity.setText(quantity);

        TextView textViewName = (TextView)findViewById(R.id.list_item_ads_show_name);
        textViewName.setText(name);

        TextView textViewPrice = (TextView)findViewById(R.id.list_item_ads_show_price);
        textViewPrice.setText(price);

        TextView textViewVerified = (TextView)findViewById(R.id.list_item_ads_show_verified_by);
        textViewVerified.setText(verified);

        Button buttonCallTruckDriver = (Button)findViewById(R.id.button_call_farmer);

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
