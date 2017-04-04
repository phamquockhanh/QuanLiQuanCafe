package com.example.ribon.quanliquancafe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ribon.quanliquancafe.R;

import com.example.ribon.quanliquancafe.model.CartItem;
import com.example.ribon.quanliquancafe.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ribon on 22/03/2017.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ItemViewHolder> {
    private Context mContext;
    List<CartItem> mCartItems;

    public interface ItemClickListener {
        void onItemClick(int pos);
    }

    public OrderAdapter(Context context, List<CartItem> cartItems) {
        mContext=context;
        mCartItems=cartItems;
    }
    @Override
    public OrderAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_view, parent, false);
        OrderAdapter.ItemViewHolder itemViewHolder = new OrderAdapter.ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(OrderAdapter.ItemViewHolder holder, int position) {
        TextView productNameTxt=holder.txtProductName;

        final CartItem cartItem=mCartItems.get(position);
            final String productName = cartItem.getProduct().getName();
            productNameTxt.setText(productName);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Toast.makeText(mContext, ""+productName, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mCartItems.size();
    }
    public void setData(List<CartItem> cartItems)
    {
        mCartItems = cartItems;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtProductName;
        ItemClickListener itemClickListener;
        public ItemViewHolder(View itemView) {
            super(itemView);
            txtProductName= (TextView) itemView.findViewById(R.id.txtLoadProductName);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener=itemClickListener;
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());
        }
    }
}
