package com.example.dharmendraverma.imageloader.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.dharmendraverma.imageloader.R;
import com.example.dharmendraverma.imageloader.adapters.ImageRenderAdapter;

/**
 * Created by dharmendraverma on 16/07/18.
 */

public class LoaderFragment extends Fragment {

    SearchView searchView;
    private RecyclerView recyclerView;

    private ImageRenderAdapter imageRenderAdapter;

    public static LoaderFragment newInstance(@Nullable Bundle argBundle) {
        LoaderFragment fragmentInstance = new LoaderFragment();

        if (argBundle != null) {
            fragmentInstance.setArguments(argBundle);
        }
        return fragmentInstance;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_image_loader, null);
        searchView = rootView.findViewById(R.id.searchView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initSearchView();
    }

    void initSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                //                if (list.contains(query)) {
                //                    adapter.getFilter().filter(query);
                //                } else {
                //                    Toast.makeText(MainActivity.this, "No Match found", Toast.LENGTH_LONG).show();
                //                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //    adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
