package com.example.dharmendraverma.imageloader.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public interface ILayoutManager {

    RecyclerView.LayoutManager getLayoutManager();
    int findFirstVisibleItemPosition();
    int findLastVisibleItemPosition();
    void setSpan(View itemView);

}
