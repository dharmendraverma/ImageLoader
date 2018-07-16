package com.example.dharmendraverma.imageloader.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;

import com.example.dharmendraverma.imageloader.R;
import com.example.dharmendraverma.imageloader.adapters.ImageRenderAdapter;
import com.example.dharmendraverma.imageloader.dataobject.ApiSearchData;
import com.example.dharmendraverma.imageloader.dataobject.Feed;
import com.example.dharmendraverma.imageloader.dataobject.Photo;
import com.example.dharmendraverma.imageloader.dataobject.Photos;
import com.example.dharmendraverma.imageloader.interfaces.ApiResponseListener;
import com.example.dharmendraverma.imageloader.network.RequestManager;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dharmendraverma on 16/07/18.
 */

public class LoaderFragment extends Fragment {

    private SearchView searchView;
    private RecyclerView recyclerView;
    private ImageView searchIv;
    private View progress;
    private int mSpanCount = 2;

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
        recyclerView = rootView.findViewById(R.id.recyclerView);
        searchIv = rootView.findViewById(R.id.go);
        progress = rootView.findViewById(R.id.progress);
        searchIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setQuery(searchView.getQuery(), true);
            }
        });
        setLayoutManger();
        return rootView;
    }

    void setLayoutManger(){
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), mSpanCount));
    }

    public void setSpanCount(int spanCount){
        mSpanCount = spanCount;
        setLayoutManger();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageRenderAdapter = new ImageRenderAdapter(null, getActivity());
        recyclerView.setAdapter(imageRenderAdapter);
        initSearchView();
    }

    void initSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                toggleLoader(true);
                RequestManager.getInstance().submitQuery(query.trim().toLowerCase(), getActivity(), listener);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //    adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    private ApiResponseListener listener = new ApiResponseListener() {
        @Override
        public void onSuccess(String key, String jsonObject) {
            toggleLoader(false);
            ApiSearchData apiSearchData = new Gson().fromJson(jsonObject, ApiSearchData.class);
            ArrayList<Feed> list = new ArrayList<>();
            Photos photos = apiSearchData.getPhotos();
            for (Photo photo : photos.getPhoto()) {
                Feed feed = new Feed();
                feed.setPhoto(photo);
                list.add(feed);
            }
            addItemsFromApi(list);
        }

        @Override
        public void onFailure() {
            toggleLoader(false);
        }
    };

    void toggleLoader(boolean showLoader) {
        progress.setVisibility(showLoader ? View.VISIBLE : View.GONE);
    }

    private void addItemsFromApi(final List<Feed> feeds) {
        refreshAdapter(feeds);

    }

    private void refreshAdapter(List<Feed> feeds) {
        if (imageRenderAdapter != null) {
            imageRenderAdapter.setList(feeds);
        }
    }
}
