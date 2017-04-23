package com.example.bharbie.akuafo.TabFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.bharbie.akuafo.Adapters.AdsListAdapter;
import com.example.bharbie.akuafo.Adapters.ExtensionListAdapter;
import com.example.bharbie.akuafo.Ads;
import com.example.bharbie.akuafo.ExtensionInfo;
import com.example.bharbie.akuafo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BHARBIE on 4/20/2017.
 */

public class FragmentExtension extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_extension,container,false);

        ListView listViewExtensionInfo = (ListView) view.findViewById(R.id.list_view_extension);
        List<ExtensionInfo> extensionInfos= new ArrayList<>();



        ExtensionListAdapter extensionListAdapter = new ExtensionListAdapter(getActivity(),R.layout.extension_list_item, extensionInfos);
        listViewExtensionInfo.setAdapter(extensionListAdapter);

        return view;
    }
}
