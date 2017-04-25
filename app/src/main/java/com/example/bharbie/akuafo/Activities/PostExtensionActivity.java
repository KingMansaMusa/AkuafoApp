package com.example.bharbie.akuafo.Activities;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bharbie.akuafo.ExtensionInfo;
import com.example.bharbie.akuafo.R;
import com.example.bharbie.akuafo.User;
import com.example.bharbie.akuafo.UserFire;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class PostExtensionActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_extension);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setTitleTextColor(ContextCompat.getColor(PostExtensionActivity.this, R.color.back_color));
        //toolbar.setTitle("Akuafo");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //----------------getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("ExtensionTable");

        final EditText editTextHeading = (EditText)findViewById(R.id.post_extension_heading);
        final EditText editTextInfo = (EditText)findViewById(R.id.post_extension_info);
        Button buttonPost = (Button)findViewById(R.id.post_extension_button);

        final User userRealm = new User();
        userRealm.getUser();

        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserFire userFire = new UserFire(userRealm.getId(),userRealm.getName(),userRealm.getEmail(),userRealm.getPassword(),userRealm.getType());

                String id  = String.valueOf(Calendar.getInstance().getTimeInMillis());
                String date = String.valueOf(Calendar.getInstance().get(Calendar.DATE));
               String heading = editTextHeading.getText().toString();
                String info = editTextInfo.getText().toString();

                ExtensionInfo extensionInfo = new ExtensionInfo(id,heading,userFire,info,date);

                if (heading.isEmpty()){
                    Toast.makeText(PostExtensionActivity.this,"Please give a heading to your post",Toast.LENGTH_LONG).show();
                }else if (info.isEmpty()){
                    Toast.makeText(PostExtensionActivity.this,"Please input your extension information",Toast.LENGTH_LONG).show();
                }else{
                    DatabaseReference currentUser =mDatabase.child(id);
                    currentUser.child("UserTable").setValue(extensionInfo, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                            if (databaseError != null){
                                Log.e("ERROR",databaseError.toString());
                            }
                        }
                    });


                    Intent intent = new Intent(PostExtensionActivity.this,HomeActivity.class);
                    startActivity(intent);
                }

            }
        });


    }
}
