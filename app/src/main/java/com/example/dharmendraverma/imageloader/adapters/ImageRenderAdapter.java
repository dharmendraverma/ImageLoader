package com.example.dharmendraverma.imageloader.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dharmendraverma.imageloader.R;
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
    private Context mContext;

    public ImageRenderAdapter(List<Feed> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PhotoItemHolder(LayoutInflater.from(mContext).inflate(R.layout.item_photo, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Feed feed = mList.get(position);
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

    public void setList(List<Feed> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public class PhotoItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        public PhotoItemHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
        }

        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        super.onViewRecycled(holder);
    }
}
