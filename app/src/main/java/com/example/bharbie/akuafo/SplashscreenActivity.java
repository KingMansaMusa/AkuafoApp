package com.example.bharbie.akuafo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        SharedPreferences sharedPreferences = getSharedPreferences("My_SharedPreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        boolean checker = sharedPreferences.getBoolean("key1", true);

        if (checker == true){

            checker = false;

            Thread me = new Thread() {
                @Override
                public void run() {

                    try {
                        sleep(3000);
                        Intent intent = new Intent(SplashscreenActivity.this, HomeActivity.class);
                        startActivity(intent);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };

        } else {

            Intent intent = new Intent(SplashscreenActivity.this, HomeActivity.class);
            startActivity(intent);

        }
    }
}
