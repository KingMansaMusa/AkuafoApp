package com.example.bharbie.akuafo.Activities;

import android.content.Intent;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bharbie.akuafo.R;

public class SplashscreenActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);


        final boolean isLoggedIn = PreferenceManager.getDefaultSharedPreferences(SplashscreenActivity.this).getBoolean("isLoggedIn",false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent = new Intent(SplashscreenActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);














      /**  SharedPreferences sharedPreferences = getSharedPreferences("My_SharedPreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        boolean checker = sharedPreferences.getBoolean("key1", true);

        if (checker){

           editor.putBoolean("key1", false);


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
            me.start();
            editor.apply();

        } else {

            Intent intent = new Intent(SplashscreenActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }**/
    }
}
