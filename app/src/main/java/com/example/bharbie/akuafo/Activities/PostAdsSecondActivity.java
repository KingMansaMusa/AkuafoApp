package com.example.bharbie.akuafo.Activities;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bharbie.akuafo.R;

public class PostAdsSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_ads_second);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Ads and Info");
        toolbar.setTitleTextColor(ContextCompat.getColor(PostAdsSecondActivity.this, R.color.back_color));

        Intent intent= getIntent();
        intent.getStringExtra("price");

        final Spinner spinnerLocation = (Spinner)findViewById(R.id.spinner_location);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterLocation = ArrayAdapter.createFromResource(PostAdsSecondActivity.this,
                R.array.spinner_location, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapterLocation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerLocation.setAdapter(adapterLocation);


        final Spinner spinnerCategory = (Spinner)findViewById(R.id.spinner_login_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(PostAdsSecondActivity.this,
                R.array.spinner_category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);

        final Spinner spinnerVerifiedBy = (Spinner)findViewById(R.id.spinner_verified_by);
        ArrayAdapter<CharSequence> adapterVerifiedBy = ArrayAdapter.createFromResource(PostAdsSecondActivity.this,
                R.array.spinner_verified_by, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVerifiedBy.setAdapter(adapter);


        final EditText editTextQuantity = (EditText)findViewById(R.id.post_ads_quantity);
        final EditText editTextPhone = (EditText)findViewById(R.id.post_ads_phone_number);
        Button buttonPost = (Button) findViewById(R.id.post_ads_button_post);

        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = spinnerCategory.getSelectedItem().toString();
               String location = spinnerLocation.getSelectedItem().toString();
                String verifiedBy = spinnerVerifiedBy.getSelectedItem().toString();
                String quantity = editTextQuantity.getText().toString();
                String phone = editTextPhone.getText().toString();
                if (quantity.isEmpty()){
                    Toast.makeText(PostAdsSecondActivity.this,"Please specify the quantity", Toast.LENGTH_LONG).show();
                }else if (phone.isEmpty()){
                    Toast.makeText(PostAdsSecondActivity.this,"Please input the phone number to buy",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(PostAdsSecondActivity.this,HomeActivity.class);
                    intent.putExtra("Check",1);
                    startActivity(intent);
                }
            }
        });

    }
}
