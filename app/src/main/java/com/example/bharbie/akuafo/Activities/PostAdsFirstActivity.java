package com.example.bharbie.akuafo.Activities;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bharbie.akuafo.R;

public class PostAdsFirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_ads_first);


        Toolbar toolbar = (Toolbar) findViewById(R.id.post_ads_toolbar1);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Ads and Info");
        toolbar.setTitleTextColor(ContextCompat.getColor(PostAdsFirstActivity.this, R.color.back_color));

        final EditText   editTextPrice = (EditText)findViewById(R.id.post_ads_price);
        final EditText editTextCaption = (EditText) findViewById(R.id.post_ads_caption);
        final EditText editTextDescription = (EditText) findViewById(R.id.post_ads_description);
        Button buttonNext = (Button) findViewById(R.id.button_post_ads_next);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String price = editTextPrice.getText().toString();
                String caption = editTextCaption.getText().toString();
                String description = editTextDescription.getText().toString();

                if (price.isEmpty()){
                    Toast.makeText(PostAdsFirstActivity.this,"Please input the price of your ad",Toast.LENGTH_LONG);
                }else if (caption.isEmpty()){
                    Toast.makeText(PostAdsFirstActivity.this,"Please input the caption for your ad",Toast.LENGTH_LONG);
                }else {
                    Intent intent = new Intent(PostAdsFirstActivity.this,PostAdsSecondActivity.class);
                    startActivity(intent);
                }

            }
        });



    }
}
