package com.example.ribon.quanliquancafe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.model.Category;
import com.example.ribon.quanliquancafe.model.Table;

import java.util.List;

/**
 * Created by Ribon on 17/03/2017.
 */

public class OrderRecyclerAdapter extends RecyclerView.Adapter<OrderRecyclerAdapter.ItemViewHolder> {
    LayoutInflater inflater;
    List<Category>categories;
    private Context context;
    OrderRecyclerAdapterOnClickHandler onClickHandler;

    public interface OrderRecyclerAdapterOnClickHandler
    {
        void onClick(Category category);
    }
    public OrderRecyclerAdapter(Context context,List<Category> categories,OrderRecyclerAdapterOnClickHandler onClickHandler) {
        this.context=context;
        this.categories=categories;
        this.onClickHandler=onClickHandler;
    }

    @Override
    public OrderRecyclerAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View orderView=inflater.inflate(R.layout.item_order_view,parent,false);
        return new ItemViewHolder(orderView);
    }

    @Override
    public void onBindViewHolder(OrderRecyclerAdapter.ItemViewHolder holder, int position) {
        Category category=categories.get(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }



    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView txtPrice;
        TextView txtProductName;
        public ItemViewHolder(View itemView) {
            super(itemView);
            imgProduct= (ImageView) itemView.findViewById(R.id.img_products);
            txtProductName= (TextView) itemView.findViewById(R.id.tv_product_name);
            txtPrice= (TextView) itemView.findViewById(R.id.tv_price);
        }
    }
}
