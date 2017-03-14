package com.example.ribon.quanliquancafe.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.interfaces.ItemTouchHelperAdapter;
import com.example.ribon.quanliquancafe.model.Option;
import com.example.ribon.quanliquancafe.model.Table;
import com.example.ribon.quanliquancafe.viewholder.OptionViewHolder;
import com.example.ribon.quanliquancafe.viewholder.TableViewHolder;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ribon on 13/03/2017.
 */

public class TableAdapter extends ExpandableRecyclerAdapter<Table,Option,TableViewHolder,OptionViewHolder> implements ItemTouchHelperAdapter {
    private LayoutInflater inflater;
    private List<Table> mItems;

    /**
     * Primary constructor. Sets up {@link #mParentList} and {@link #mFlatItemList}.
     * <p>
     * Any changes to {@link #mParentList} should be made on the original instance, and notified via
     * {@link #notifyParentInserted(int)}
     * {@link #notifyParentRemoved(int)}
     * {@link #notifyParentChanged(int)}
     * {@link #notifyParentRangeInserted(int, int)}
     * {@link #notifyChildInserted(int, int)}
     * {@link #notifyChildRemoved(int, int)}
     * {@link #notifyChildChanged(int, int)}
     * methods and not the notify methods of RecyclerView.Adapter.
     *
     * @param parentList List of all parents to be displayed in the RecyclerView that this
     *                   adapter is linked to
     */
    public TableAdapter(Context context,@NonNull List<Table> parentList) {
        super(parentList);
        inflater = LayoutInflater.from(context);
        mItems=parentList;
    }


    @NonNull
    @Override
    public TableViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        View tableView = inflater.inflate(R.layout.table_view,parentViewGroup,false);
        return new TableViewHolder(tableView);
    }

    @NonNull
    @Override
    public OptionViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        View optionView=inflater.inflate((R.layout.option_view),childViewGroup,false);
        return new OptionViewHolder(optionView);
    }

    @Override
    public void onBindParentViewHolder(@NonNull TableViewHolder tableViewHolder, int parentPosition, @NonNull Table table) {
        tableViewHolder.bind(table);
    }

    @Override
    public void onBindChildViewHolder(@NonNull OptionViewHolder optionViewHolder, int parentPosition, int childPosition, @NonNull Option option) {
        optionViewHolder.bind(option);
    }


    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mItems, fromPosition, toPosition);
        notifyParentMoved(fromPosition,toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        mItems.remove(position);
        notifyParentRemoved(position);
    }
    /*public void updateData(List<Table> viewModels) {
        mItems.clear();
        mItems.addAll(viewModels);
        notifyParentDataSetChanged(true);
    }*/
}
