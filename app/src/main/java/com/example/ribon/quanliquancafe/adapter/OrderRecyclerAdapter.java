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
import com.example.ribon.quanliquancafe.model.Product;
import com.example.ribon.quanliquancafe.model.Table;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ribon on 17/03/2017.
 */

public class OrderRecyclerAdapter extends RecyclerView.Adapter<OrderRecyclerAdapter.ItemViewHolder> {
    LayoutInflater inflater;
    List<Product>products;
    private Context context;
    OrderRecyclerAdapterOnClickHandler onClickHandler;

    public interface OrderRecyclerAdapterOnClickHandler
    {
        void onClick(Category category);
    }
    public OrderRecyclerAdapter(Context context,List<Product> products,OrderRecyclerAdapterOnClickHandler onClickHandler) {
        this.context=context;
        this.products=products;
        this.onClickHandler=onClickHandler;
    }

    @Override
    public OrderRecyclerAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_view, parent, false);
        OrderRecyclerAdapter.ItemViewHolder itemViewHolder = new OrderRecyclerAdapter.ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(OrderRecyclerAdapter.ItemViewHolder holder, int position) {
        Product product=products.get(position);
        holder.txtProductName.setText(product.getName());
        float price=product.getPrice();
        holder.txtPrice.setText(Float.toString(price));
        Picasso.with(context).load(product.getPath()).into(holder.imgProduct);

    }

    @Override
    public int getItemCount() {
        if (products == null)
            return 0;
        else
            return  products.size();    }



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
