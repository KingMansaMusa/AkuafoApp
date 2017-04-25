package com.example.bharbie.akuafo.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bharbie.akuafo.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

import in.myinnos.awesomeimagepicker.activities.AlbumSelectActivity;
import in.myinnos.awesomeimagepicker.helpers.ConstantsCustomGallery;
import in.myinnos.awesomeimagepicker.models.Image;

import static android.R.attr.data;
import static android.R.attr.imageButtonStyle;

public class PostAdsFirstActivity extends AppCompatActivity {
    private ImageView imageView;
    private String fileUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_ads_first);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setTitle("Ads and Info");
        //toolbar.setTitleTextColor(ContextCompat.getColor(PostAdsFirstActivity.this, R.color.back_color));

        final EditText   editTextPrice = (EditText)findViewById(R.id.post_ads_price);
        final EditText editTextCaption = (EditText) findViewById(R.id.post_ads_caption);
        final EditText editTextDescription = (EditText) findViewById(R.id.post_ads_description);
        Button buttonNext = (Button) findViewById(R.id.button_post_ads_next);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostAdsFirstActivity.this, AlbumSelectActivity.class);
                intent.putExtra(ConstantsCustomGallery.INTENT_EXTRA_LIMIT, 1); // set limit for image selection
                startActivityForResult(intent, ConstantsCustomGallery.REQUEST_CODE);
            }
        });


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String image = imageView.toString();

                String price = editTextPrice.getText().toString();
                String caption = editTextCaption.getText().toString();
                String description = editTextDescription.getText().toString();

                if (price.isEmpty()){
                    Toast.makeText(PostAdsFirstActivity.this,"Please input the price of your ad",Toast.LENGTH_LONG).show();
                }else if (caption.isEmpty()){
                    Toast.makeText(PostAdsFirstActivity.this,"Please input the caption for your ad",Toast.LENGTH_LONG).show();
                }else {
                    Intent intent = new Intent(PostAdsFirstActivity.this,PostAdsSecondActivity.class);
                    intent.putExtra("price",price);
                    intent.putExtra("caption",caption);
                    intent.putExtra("description",description);
                    intent.putExtra("image",image);




                    startActivity(intent);
                }

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ConstantsCustomGallery.REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            //The array list has the image paths of the selected images
            ArrayList<Image> images = data.getParcelableArrayListExtra(ConstantsCustomGallery.INTENT_EXTRA_IMAGES);

            for (int i = 0; i < images.size(); i++) {
                Uri uri = Uri.fromFile(new File(images.get(i).path));
                imageView.setImageURI(uri);
                // start play with image uri

            }
        }
    }
}
