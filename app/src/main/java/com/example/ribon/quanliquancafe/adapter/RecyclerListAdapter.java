package com.example.ribon.quanliquancafe.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.interfaces.ItemTouchHelperAdapter;
import com.example.ribon.quanliquancafe.interfaces.ItemTouchHelperViewHolder;
import com.example.ribon.quanliquancafe.util.ColorUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ribon on 08/03/2017.
 */

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ItemViewHolder>
        implements ItemTouchHelperAdapter {
    private final List<String> mItems = new ArrayList<>();
    private static int viewHolderCount;

    public RecyclerListAdapter(Context context) {
        mItems.addAll(Arrays.asList(context.getResources().getStringArray(R.array.dummy_items)));
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sell, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        int backgroundColorForViewHolder = ColorUtils.getViewHolderBackgroundColorFromInstance(parent.getContext(),viewHolderCount);
        itemViewHolder.itemView.setBackgroundColor(backgroundColorForViewHolder);

        viewHolderCount++;
        return itemViewHolder;
    }


    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        holder.mTextViewTable.setText(mItems.get(position));

    }

    @Override
    public void onItemDismiss(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder implements
            ItemTouchHelperViewHolder {

        public final TextView mTextViewTable;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTextViewTable = (TextView) itemView.findViewById(R.id.tv_table);
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);

        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }
    }
}