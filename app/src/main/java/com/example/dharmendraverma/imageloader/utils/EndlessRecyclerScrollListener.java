package com.example.dharmendraverma.imageloader.utils;


import android.support.v7.widget.RecyclerView;

import static android.support.v7.widget.RecyclerView.OnScrollListener;

public abstract class EndlessRecyclerScrollListener extends OnScrollListener
{
    private ILayoutManager mLinearLayoutManager;
    private RecyclerView.LayoutManager mLayoutManager;

    private int beforeEndCount = 3;

    public EndlessRecyclerScrollListener(ILayoutManager layoutManager)
    {
        mLinearLayoutManager = layoutManager;
        mLayoutManager = mLinearLayoutManager.getLayoutManager();
    }

    public EndlessRecyclerScrollListener(ILayoutManager layoutManager, int beforeEndCount) {
        this(layoutManager);
        this.beforeEndCount = beforeEndCount;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy)
    {
        super.onScrolled(recyclerView, dx, dy);
        int visibleItemCount = mLayoutManager.getChildCount();
        int totalItemCount = mLayoutManager.getItemCount();
        int pastVisiblesItems = mLinearLayoutManager.findFirstVisibleItemPosition();

        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount - beforeEndCount) {
            onReachEnd();
        }
    }

    public abstract void onReachEnd();
}
