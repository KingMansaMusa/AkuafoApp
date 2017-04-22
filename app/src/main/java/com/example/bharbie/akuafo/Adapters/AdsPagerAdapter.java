package com.example.bharbie.akuafo.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.bharbie.akuafo.Fragments.FragmentProfile;
import com.example.bharbie.akuafo.TabFragments.FragmentAds;
import com.example.bharbie.akuafo.TabFragments.FragmentExtension;
import com.example.bharbie.akuafo.TabFragments.FragmentTrucks;

/**
 * Created by BHARBIE on 4/20/2017.
 */

public class AdsPagerAdapter extends FragmentPagerAdapter {

    public AdsPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FragmentAds();
        } else if (position == 1) {
            return new FragmentTrucks();
        } else {
            return new FragmentExtension();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Ads";
        } else if (position == 1) {
            return "Trucks";
        } else {
            return "ExtensionInfo";
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

}

