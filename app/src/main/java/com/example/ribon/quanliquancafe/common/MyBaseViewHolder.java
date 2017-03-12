package com.example.ribon.quanliquancafe.common;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.ribon.quanliquancafe.R;
import com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractDraggableSwipeableItemViewHolder;

/**
 * Created by Ribon on 12/03/2017.
 */
public class MyBaseViewHolder extends AbstractDraggableSwipeableItemViewHolder implements ExpandableItemViewHolder {
    public FrameLayout mContainer;
    public View mDragHandle;
    public TextView mTextView;
    private int mExpandStateFlags;

    public MyBaseViewHolder(View v) {
        super(v);
        mContainer = (FrameLayout) v.findViewById(R.id.fragment_sell);
        mDragHandle = v.findViewById(R.id.drag_handle);
        mTextView = (TextView) v.findViewById(android.R.id.text1);

    }

    @Override
    public View getSwipeableContainerView() {
        return null;
    }

    @Override
    public void setExpandStateFlags(int flags) {

    }

    @Override
    public int getExpandStateFlags() {
        return 0;
    }
}
