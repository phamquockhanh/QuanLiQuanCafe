package com.example.ribon.quanliquancafe.adapter;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.fragment.LoadProductFragment;
import com.example.ribon.quanliquancafe.fragment.OrderingFragment;
import com.example.ribon.quanliquancafe.model.Product;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ribon on 17/03/2017.
 */

public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.ItemViewHolder> {
    LayoutInflater inflater;
    List<Product>products=new ArrayList<>();
    private Context context;
    EditText mEdtQuaritity;
    ProductRecyclerAdapterOnClickHandler mClickHandler;

    public interface ProductRecyclerAdapterOnClickHandler
    {
        void onClick(Product pos,String name,float price);
    }
    public ProductRecyclerAdapter(Context context, List<Product> products, ProductRecyclerAdapterOnClickHandler mClickHandler) {
        this.context=context;
        this.products=products;
        this.mClickHandler=mClickHandler;
    }

    @Override
    public ProductRecyclerAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_view, parent, false);
        ProductRecyclerAdapter.ItemViewHolder itemViewHolder = new ProductRecyclerAdapter.ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        Product product=products.get(position);
        holder.txtProductName.setText(product.getName());
        float price=product.getPrice();
        holder.txtPrice.setText(Float.toString(price));
        if(product.getPath() != null){
            Picasso.with(context).load(new File(product.getPath())).into(holder.imgProduct);
        }
        /*holder.imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "sss", Toast.LENGTH_SHORT).show();
            }
        });*/


    }

    @Override
    public int getItemCount() {
        return  products.size();
    }
    public void addProduct(Product product){
        this.products.add(product);
    }

    public List<Product> getProducts(){
        return products;
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgProduct;
        TextView txtPrice;
        TextView txtProductName;
        public ItemViewHolder(View itemView) {
            super(itemView);
            imgProduct= (ImageView) itemView.findViewById(R.id.img_products);
            txtProductName= (TextView) itemView.findViewById(R.id.tv_product_name);
            txtPrice= (TextView) itemView.findViewById(R.id.tv_price);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(final View v) {
            int adapterPosition=getAdapterPosition();
            Product item = products.get(adapterPosition);
            showPopup(itemView,item);
            /*Toast.makeText(context, "Chọn:"+item.getId() , Toast.LENGTH_SHORT).show();*/
        }




        private void showPopup(View v, final Product pos) {
            View menuItemView = v.findViewById(R.id.layout_item);
            PopupMenu popup = new PopupMenu(context, menuItemView);
            MenuInflater inflate = popup.getMenuInflater();
            inflate.inflate(R.menu.option_product, popup.getMenu());
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    int id = item.getItemId();
                    final Dialog dialog=new Dialog(context);
                    switch (id) {
                        case R.id.action_order_product:
                            dialog.setContentView(R.layout.quaritity_customdialog_layout);
                            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                            mEdtQuaritity= (EditText) dialog.findViewById(R.id.edt_quaritity);
                            Button mBtnOK = (Button) dialog.findViewById(R.id.btn_ok);
                            Button mBtnCancel= (Button) dialog.findViewById(R.id.btn_cancel);
                            mBtnCancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.cancel();
                                }
                            });
                            mBtnOK.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    String quaritity=mEdtQuaritity.getText().toString();
                                    if (TextUtils.isEmpty(quaritity)) {
                                        Toast.makeText(context, "Vui lòng nhập số lượng", Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                        /*Toast.makeText(context, quaritity+"", Toast.LENGTH_SHORT).show();*/
                                        putData(pos);
                                        Toast.makeText(context, ""+pos.getId(), Toast.LENGTH_SHORT).show();
                                        dialog.cancel();
                                }
                            });
                            dialog.show();

                            break;
                    }
                    return false;
                }
            });
            popup.show();
        }
    }

    void putData(Product pos){
        LoadProductFragment fragment=new LoadProductFragment();
        Bundle bundle=new Bundle();
        bundle.putString("ProductName",pos.getName());
        bundle.putFloat("ProductPrice",pos.getPrice());
        bundle.putInt("ProductQuaritity", Integer.parseInt(mEdtQuaritity.getText().toString()));
        fragment.setArguments(bundle);

    }
}

