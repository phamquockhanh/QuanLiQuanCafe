package com.example.ribon.quanliquancafe.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.activity.OrderActivity;
import com.example.ribon.quanliquancafe.interfaces.ItemTouchHelperAdapter;
import com.example.ribon.quanliquancafe.interfaces.ItemTouchHelperViewHolder;
import com.example.ribon.quanliquancafe.model.Table;
import com.example.ribon.quanliquancafe.util.ColorUtils;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ribon on 08/03/2017.
 */

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ItemViewHolder>
        implements ItemTouchHelperAdapter {
    private List<Table> mItems;
    private static int viewHolderCount;
    Context context;

    public RecyclerListAdapter(Context context, List<Table> mItems) {
       // mItems.addAll(Arrays.asList(context.getResources().getStringArray(R.array.dummy_items)));
        this.context=context;
        this.mItems=mItems;
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
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        Table item = mItems.get(position);
        holder.mTableTextView.setText(item.getTableName());
        holder.mTableTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, OrderActivity.class);
                v.getContext().startActivity(intent);
            }
        });
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
//        SharedPreferences pref = context.getSharedPreferences("luuPossition",Context.MODE_PRIVATE);
//        SharedPreferences.Editor edt = pref.edit();
//        List<String> list = new ArrayList<String>();
//        for (int i=0;i<mItems.size();i++){
//            list.add(toPosition+"");
//        }
//            edt.putInt("index", toPosition);
//        Log.d("test",list+"");
//        edt.commit();
        return true;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements
            ItemTouchHelperViewHolder {

        public final TextView mTableTextView;
        /*@Bind(R.id.tv_table) TextView mTableTextView;*/

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTableTextView = (TextView) itemView.findViewById(R.id.tv_table);
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