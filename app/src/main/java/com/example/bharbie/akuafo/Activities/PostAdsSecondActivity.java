package com.example.bharbie.akuafo.Activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bharbie.akuafo.Ads;
import com.example.bharbie.akuafo.R;
import com.example.bharbie.akuafo.Truck;
import com.example.bharbie.akuafo.User;
import com.example.bharbie.akuafo.UserFire;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

import in.myinnos.awesomeimagepicker.helpers.ConstantsCustomGallery;
import in.myinnos.awesomeimagepicker.models.Image;

import static android.R.attr.description;
import static android.R.attr.id;

public class PostAdsSecondActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    StorageReference storageRef;
    private String fileUrl = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_ads_second);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setTitle("Ads and Info");
        //toolbar.setTitleTextColor(ContextCompat.getColor(PostAdsSecondActivity.this, R.color.back_color));



        String name = String.valueOf(Calendar.getInstance().getTimeInMillis());
        storageRef = FirebaseStorage.getInstance().getReference().child(name + ".jpeg");
        mDatabase = FirebaseDatabase.getInstance().getReference().child("AdsTable");
        Intent intent = getIntent();
        final String price = intent.getStringExtra("price");
        final String image = intent.getStringExtra("image");
        final String description = intent.getStringExtra("description");
        final String caption = intent.getStringExtra("caption");

        String imageView = image;
        final Spinner spinnerLocation = (Spinner) findViewById(R.id.spinner_location);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterLocation = ArrayAdapter.createFromResource(PostAdsSecondActivity.this,
                R.array.spinner_location, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapterLocation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerLocation.setAdapter(adapterLocation);


        final Spinner spinnerCategory = (Spinner) findViewById(R.id.spinner_login_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(PostAdsSecondActivity.this,
                R.array.spinner_category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);

        final EditText editTextVerifiedBy = (EditText) findViewById(R.id.post_ads_verified_by);


        final EditText editTextQuantity = (EditText) findViewById(R.id.post_ads_quantity);
        final EditText editTextPhone = (EditText) findViewById(R.id.post_ads_phone_number);
        Button buttonPost = (Button) findViewById(R.id.post_ads_button_post);


        final User userRealm = new User();
        userRealm.getUser();

/**
        // Get the data from an ImageView as bytes
        imageView.setDrawingCacheEnabled(true);
        image.buildDrawingCache();
        Bitmap bitmap = imageView.getDrawingCache();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] dataImage = baos.toByteArray();

        UploadTask uploadTask = storageRef.putBytes(dataImage);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                Uri downloadUrl = taskSnapshot.getMetadata().getDownloadUrl();
                fileUrl = downloadUrl.getPath();
            }
        });**/


        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserFire userFire = new UserFire(userRealm.getId(), userRealm.getName(), userRealm.getEmail(), userRealm.getPassword(), userRealm.getType());


                String date = String.valueOf(Calendar.getInstance().get(Calendar.DATE));
                String id = String.valueOf(Calendar.getInstance().getTimeInMillis());
                String category = spinnerCategory.getSelectedItem().toString();
                String location = spinnerLocation.getSelectedItem().toString();
                String verifiedBy = editTextVerifiedBy.getText().toString();
                String quantity = editTextQuantity.getText().toString();
                String phone = editTextPhone.getText().toString();


                Ads ads = new Ads(id, userFire, image, caption, price, description, location, category, quantity, date, verifiedBy, phone);

                if (quantity.isEmpty()) {
                    Toast.makeText(PostAdsSecondActivity.this, "Please specify the quantity", Toast.LENGTH_LONG).show();
                } else if (phone.isEmpty()) {
                    Toast.makeText(PostAdsSecondActivity.this, "Please input the phone number to buy", Toast.LENGTH_LONG).show();
                } else {

                    ProgressDialog progressDialog = new ProgressDialog(PostAdsSecondActivity.this);
                    progressDialog.setMessage("Processing...");
                    progressDialog.show();
                    DatabaseReference currentUser = mDatabase.child(id);
                    currentUser.child("UserTable").setValue(ads, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                            if (databaseError != null) {
                                Log.e("ERROR", databaseError.toString());
                            }
                        }
                    });progressDialog.hide();

                    Intent intent = new Intent(PostAdsSecondActivity.this, HomeActivity.class);
                    intent.putExtra("Check", 1);
                    startActivity(intent);
                }
            }
        });

    }
}
