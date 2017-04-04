package com.example.ribon.quanliquancafe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.model.Product;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Ribon on 31/03/2017.
 */

public class ProductManagerAdapter extends RecyclerView.Adapter<ProductManagerAdapter.ItemViewHolder> {
    Context mContext;
    List<Product> products=new ArrayList<>();
    ItemClickListener mListener;

    public interface ItemClickListener {
        void onItemClick(int pos);
    }

    public ProductManagerAdapter(Context context, List<Product> products) {
        mContext = context;
        this.products = products;
    }

    @Override
    public ProductManagerAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_manager_products,parent,false);
        ProductManagerAdapter.ItemViewHolder itemViewHolder = new ProductManagerAdapter.ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ProductManagerAdapter.ItemViewHolder holder, int position) {
        TextView tvNameProduct=holder.tvNameProduct;
        TextView tvPriceProduct=holder.tvPriceProduct;
        final Product product=products.get(position);

        final String productName=product.getName();
        final Float productPrice=product.getPrice();

        tvPriceProduct.setText(productName);
        tvNameProduct.setText(Float.toString(productPrice));
        if(product.getPath() != null){
            Picasso.with(mContext).load(new File(product.getPath())).into(holder.imgProduct);
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CircleImageView imgProduct;
        TextView tvNameProduct;
        TextView tvPriceProduct;
        Button btnInsert;
        Button btnDelete;
        Button btnUpdate;
        public ItemViewHolder(View itemView) {
            super(itemView);
            imgProduct= (CircleImageView) itemView.findViewById(R.id.imgProduct);
            tvNameProduct= (TextView) itemView.findViewById(R.id.tvNameProduct);
            tvPriceProduct= (TextView) itemView.findViewById(R.id.tvPriceProduct);
            btnInsert= (Button) itemView.findViewById(R.id.btnInsert);
            btnUpdate= (Button) itemView.findViewById(R.id.btnUpdate);
            btnDelete= (Button) itemView.findViewById(R.id.btnDelete);
           /* btnInsert.setOnClickListener(this);
            btnDelete.setOnClickListener(this);
            btnUpdate.setOnClickListener(this);*/

        }
        public void setItemClickListener(ItemClickListener itemClickListener){
            mListener=itemClickListener;
        }
        @Override
        public void onClick(View v) {
            mListener.onItemClick(this.getLayoutPosition());
        }
    }
}
