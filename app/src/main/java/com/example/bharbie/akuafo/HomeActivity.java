package com.example.bharbie.akuafo;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.bharbie.akuafo.Fragments.FragmentAboutUs;
import com.example.bharbie.akuafo.Fragments.FragmentAdsAndInfo;
import com.example.bharbie.akuafo.Fragments.FragmentCategories;
import com.example.bharbie.akuafo.Fragments.FragmentLogin;
import com.example.bharbie.akuafo.Fragments.FragmentProfile;
import com.example.bharbie.akuafo.Fragments.FragmentSignUp;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.nav_drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(HomeActivity.this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                drawerLayout.closeDrawers();
                if (item.getItemId() == R.id.nav_about_us) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.place_holder, new FragmentAboutUs());
                    fragmentTransaction.commit();
                } else if (item.getItemId() == R.id.nav_ads_and_info) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.place_holder, new FragmentAdsAndInfo());
                    fragmentTransaction.commit();
                } else if (item.getItemId() == R.id.nav_categories) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.place_holder, new FragmentCategories());
                    fragmentTransaction.commit();
                } else if (item.getItemId() == R.id.nav_location) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.place_holder, new FragmentCategories());
                    fragmentTransaction.commit();
                } else if (item.getItemId() == R.id.nav_login) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.place_holder, new FragmentLogin());
                    fragmentTransaction.commit();
                } else if (item.getItemId() == R.id.nav_profile) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.place_holder, new FragmentProfile());
                    fragmentTransaction.commit();
                } else {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.place_holder, new FragmentSignUp());
                    fragmentTransaction.commit();
                }
return false;
            }
        });
        navigationView.getMenu().performIdentifierAction(R.id.nav_categories,0);
}
}
