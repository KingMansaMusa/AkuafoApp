package com.example.bharbie.akuafo.Activities;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.bharbie.akuafo.R;

public class ExtensionListItemShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extension_list_item_show);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setTitleTextColor(ContextCompat.getColor(ExtensionListItemShowActivity.this, R.color.back_color));
        //toolbar.setTitle("Akuafo");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();

        final String info = intent.getStringExtra("info");
        final String heading = intent.getStringExtra("heading");
        final String name = intent.getStringExtra("name");
        final String date = intent.getStringExtra("date");



        TextView textViewInfo = (TextView)findViewById(R.id.list_item_extension_info);
        textViewInfo.setText(info);

        TextView textViewHeading = (TextView)findViewById(R.id.list_item_extension_heading);
        textViewHeading.setText(heading);

        TextView textViewName = (TextView)findViewById(R.id.list_view_extension_sender);
       // textViewName.setText(info);

        TextView textViewDate = (TextView)findViewById(R.id.list_item_extension_date);
        textViewDate.setText(info);

    }
}
