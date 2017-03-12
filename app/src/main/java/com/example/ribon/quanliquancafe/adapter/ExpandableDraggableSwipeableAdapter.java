package com.example.ribon.quanliquancafe.adapter;

import android.support.annotation.IntRange;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.ribon.quanliquancafe.common.MyBaseViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;

/**
 * Created by Ribon on 12/03/2017.
 */

public class ExpandableDraggableSwipeableAdapter extends AbstractExpandableItemAdapter<ExpandableDraggableSwipeableAdapter.MyGroupViewHolder
        ,ExpandableDraggableSwipeableAdapter.MyChildViewHolder> {

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public int getChildCount(int groupPosition) {
        return 0;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public MyGroupViewHolder onCreateGroupViewHolder(ViewGroup parent, @IntRange(from = -8388608L, to = 8388607L) int viewType) {
        return null;
    }

    @Override
    public MyChildViewHolder onCreateChildViewHolder(ViewGroup parent, @IntRange(from = -8388608L, to = 8388607L) int viewType) {
        return null;
    }

    @Override
    public void onBindGroupViewHolder(MyGroupViewHolder holder, int groupPosition, @IntRange(from = -8388608L, to = 8388607L) int viewType) {

    }

    @Override
    public void onBindChildViewHolder(MyChildViewHolder holder, int groupPosition, int childPosition, @IntRange(from = -8388608L, to = 8388607L) int viewType) {

    }

    @Override
    public boolean onCheckCanExpandOrCollapseGroup(MyGroupViewHolder holder, int groupPosition, int x, int y, boolean expand) {
        return false;
    }

    public class MyChildViewHolder extends MyBaseViewHolder {
        public MyChildViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class MyGroupViewHolder extends RecyclerView.ViewHolder {
        public MyGroupViewHolder(View itemView) {
            super(itemView);
        }
    }
}
