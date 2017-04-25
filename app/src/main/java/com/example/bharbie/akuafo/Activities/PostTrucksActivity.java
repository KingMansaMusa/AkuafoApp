package com.example.bharbie.akuafo.Activities;

import android.app.Activity;
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
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;

import in.myinnos.awesomeimagepicker.activities.AlbumSelectActivity;
import in.myinnos.awesomeimagepicker.helpers.ConstantsCustomGallery;
import in.myinnos.awesomeimagepicker.models.Image;

public class PostTrucksActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    StorageReference storageRef;
    private String fileUrl = "";
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_trucks);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setTitleTextColor(ContextCompat.getColor(PostTrucksActivity.this, R.color.back_color));
        //toolbar.setTitle("Akuafo");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("TrucksTable");
        String name = String.valueOf(Calendar.getInstance().getTimeInMillis());
        storageRef = FirebaseStorage.getInstance().getReference().child(name + ".jpeg");
        imageView = (ImageView) findViewById(R.id.image_view_post_truck);
        final EditText editTextPhone = (EditText) findViewById(R.id.post_ads_phone_number);
        final EditText editTextModel = (EditText) findViewById(R.id.post_trucks_model);
        final EditText editTextRegNo = (EditText) findViewById(R.id.post_trucks_reg_no);
        Button buttonPost = (Button) findViewById(R.id.button_post_truck);

        final Spinner spinnerTruckSize = (android.widget.Spinner) findViewById(R.id.spinner_truck_size);
        ArrayAdapter<CharSequence> adapterTruckSize = ArrayAdapter.createFromResource(PostTrucksActivity.this,
                R.array.spinner_truck_size, android.R.layout.simple_spinner_item);
        adapterTruckSize.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTruckSize.setAdapter(adapterTruckSize);

        final User userRealm = new User();
        userRealm.getUser();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostTrucksActivity.this, AlbumSelectActivity.class);
                intent.putExtra(ConstantsCustomGallery.INTENT_EXTRA_LIMIT, 1); // set limit for image selection
                startActivityForResult(intent, ConstantsCustomGallery.REQUEST_CODE);
            }
        });

        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserFire userFire = new UserFire(userRealm.getId(), userRealm.getName(), userRealm.getEmail(), userRealm.getPassword(), userRealm.getType());
                String date = String.valueOf(Calendar.getInstance().get(Calendar.DATE));


                String idTruck = String.valueOf(Calendar.getInstance().getTimeInMillis());
                String model = editTextModel.getText().toString();
                String regNo = editTextRegNo.getText().toString();
                String size = spinnerTruckSize.getSelectedItem().toString();
                String phone = editTextPhone.getText().toString();

                Truck truck = new Truck(idTruck, userFire, fileUrl, model, size, regNo, date, phone);

                if (model.isEmpty()) {
                    Toast.makeText(PostTrucksActivity.this, "Please specify the model of your truck", Toast.LENGTH_LONG).show();
                } else if (regNo.isEmpty()) {
                    Toast.makeText(PostTrucksActivity.this, "Please input yout vehicle registration number", Toast.LENGTH_LONG).show();
                } else {

                    DatabaseReference currentUser = mDatabase.child(idTruck);
                    currentUser.child("UserTable").setValue(truck, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                            if (databaseError != null) {
                                Log.e("ERROR", databaseError.toString());
                            }
                        }
                    });

                    Intent intent = new Intent(PostTrucksActivity.this, HomeActivity.class);
                    intent.putExtra("Check", 1);
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

                // Get the data from an ImageView as bytes
                imageView.setDrawingCacheEnabled(true);
                imageView.buildDrawingCache();
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
                });
            }
        }
    }

}