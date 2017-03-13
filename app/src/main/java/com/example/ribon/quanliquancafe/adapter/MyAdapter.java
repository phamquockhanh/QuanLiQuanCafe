package com.example.ribon.quanliquancafe.adapter;

/*
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.interfaces.ItemTouchHelperAdapter;
import com.example.ribon.quanliquancafe.model.Table;
import com.example.ribon.quanliquancafe.model.Option;
import com.example.ribon.quanliquancafe.viewholder.TitleChildViewHolder;
import com.example.ribon.quanliquancafe.viewholder.TitleParentViewHolder;

import java.util.Collections;
import java.util.List;

*/
/**
 * Created by Ribon on 12/03/2017.
 *//*


public class MyAdapter extends ExpandableRecyclerAdapter<TitleParentViewHolder,TitleChildViewHolder> implements ItemTouchHelperAdapter {
    LayoutInflater inflater;
    private List<ParentObject> mItems;

    public MyAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        mItems=parentItemList;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public TitleParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.table_view,viewGroup,false);
        return new TitleParentViewHolder(view);
    }

    @Override
    public TitleChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.option_view,viewGroup,false);
        return new TitleChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(TitleParentViewHolder titleParentViewHolder, int i, Object o) {
        Table table=(Table) o;
        titleParentViewHolder._textView.setText(table.getTableName());
    }

    @Override
    public void onBindChildViewHolder(TitleChildViewHolder titleChildViewHolder, int i, Object o) {
        Option title = (Option)o;
        titleChildViewHolder.option1.setText(title.getOption1());
        titleChildViewHolder.option2.setText(title.getOption2());
        titleChildViewHolder.option3.setText(title.getOption3());
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }

}
*/
