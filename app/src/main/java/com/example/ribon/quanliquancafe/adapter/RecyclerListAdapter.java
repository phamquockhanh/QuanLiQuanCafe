package com.example.ribon.quanliquancafe.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.activity.OrderActivity;
import com.example.ribon.quanliquancafe.interfaces.ItemTouchHelperAdapter;
import com.example.ribon.quanliquancafe.interfaces.ItemTouchHelperViewHolder;
import com.example.ribon.quanliquancafe.model.Table;

import java.util.Collections;
import java.util.List;

import butterknife.OnClick;

/**
 * Created by Ribon on 08/03/2017.
 */

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ItemViewHolder>
        implements ItemTouchHelperAdapter {
    private List<Table> mItems;
    private static int viewHolderCount;
    private final RecyclerListAdapterOnClickHandler mClickHandler;
    Context context;

    public interface RecyclerListAdapterOnClickHandler {
        void onClick(Table item);
    }

    public RecyclerListAdapter(Context context, List<Table> mItems, RecyclerListAdapterOnClickHandler mClickHandler) {
        this.context=context;
        this.mItems=mItems;
        this.mClickHandler = mClickHandler;
    }
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType)  {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_view, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
       /* int backgroundColorForViewHolder = ColorUtils.getViewHolderBackgroundColorFromInstance(parent.getContext(),viewHolderCount);
        itemViewHolder.itemView.setBackgroundColor(backgroundColorForViewHolder);

        viewHolderCount++;*/
        return itemViewHolder;
    }


    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        Table item = mItems.get(position);
        holder.mTableTextView.setText(item.getTitle());
        /*holder.mTableTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, OrderActivity.class);
                v.getContext().startActivity(intent);
            }
        });*/
    }

    @Override
    public void onItemDismiss(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        /*Collections.swap(mItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);

        return true;*/
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mItems, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mItems, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements
            ItemTouchHelperViewHolder, View.OnClickListener {

        public final TextView mTableTextView;
        /*@Bind(R.id.tv_table) TextView mTableTextView;*/

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTableTextView = (TextView) itemView.findViewById(R.id.tv_table);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onItemSelected() {
           /* itemView.setBackgroundColor(Color.LTGRAY);*/

        }

        @Override
        public void onItemClear() {
            /*itemView.setBackgroundColor(0);*/
        }

        @Override
        public void onClick(View v) {
            int adapterPosition=getAdapterPosition();
            Table item = mItems.get(adapterPosition);
            mClickHandler.onClick(item);
            showPopup(mTableTextView,item);
        }
    }
    public void addTable(Table table){
        this.mItems.add(table);
    }

    public List<Table> getmItems(){
        return mItems;
    }

    private void showPopup(final View view, final Table position){
        View menuItemView = view.findViewById(R.id.tv_table);
        PopupMenu popup = new PopupMenu(context, menuItemView);
        MenuInflater inflate = popup.getMenuInflater();
        inflate.inflate(R.menu.option, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id=item.getItemId();
                switch (id){
                    case R.id.action_insert_dish:
                        Toast.makeText(context, "thêm món", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(context,OrderActivity.class);
                        view.getContext().startActivity(intent);
                        break;
                    case R.id.action_change_dish:
                        Toast.makeText(context, "đổi món", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_pay:
                        Toast.makeText(context, "thanh toán", Toast.LENGTH_SHORT).show();
                        break;


                }
                return false;
            }
        });
        popup.show();
    }
}