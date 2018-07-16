package com.example.dharmendraverma.imageloader.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.dharmendraverma.imageloader.dataobject.Feed;

import java.util.ArrayList;
import java.util.List;

import static com.example.dharmendraverma.imageloader.dataobject.Feed.LOAD_MORE_OBJ_TYPE;

/**
 * Created by dharmendraverma on 16/07/18.
 */

public class ImageRenderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOAD_MORE = 2;
    private List<Feed> mList = new ArrayList<>();
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position).getObjType().equalsIgnoreCase(LOAD_MORE_OBJ_TYPE)) {
            return VIEW_TYPE_LOAD_MORE;
        } else {
            return VIEW_TYPE_ITEM;
        }
    }
}
