package com.example.ribon.quanliquancafe.adapter;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.fragment.OrderingFragment;
import com.example.ribon.quanliquancafe.model.CartItem;
import com.example.ribon.quanliquancafe.model.Product;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Ribon on 17/03/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ItemViewHolder> {
    LayoutInflater inflater;
    List<Product>products;
    /*public ArrayList<Product>checkProducts=new ArrayList<>();*/
    public ArrayList<CartItem>checkProducts=new ArrayList<>();
    private Context context;
    EditText mEdtQuaritity;
    int number =1;
    int quantity;
    CartItem cartItem;
   /* public ArrayList<Integer> quaritity=new ArrayList<>();*/

    /*OnIdSetListener onIdSetListener;*/
    int tableId;


    public interface ItemClickListener {
        void onItemClick(View v,int pos);
    }

    /*public interface OnIdSetListener{
        public void setId(int id);
    }*/

    public ProductAdapter(Context context, List<Product> products/*,int tableId*/) {
        this.context=context;
        this.products=products;
        /*this.tableId=tableId;*/
    }

    /*public void setOnIdSetListener(OnIdSetListener listener){
        this.onIdSetListener = listener;
    }*/

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_view, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        TextView tvNameProduct=holder.tvNameProduct;
        TextView tvPriceProduct=holder.tvPriceProduct;
        final TextView tvQuaritity=holder.tvQuaritity;
        final Product product=products.get(position);

        final String productName=product.getName();
        final Float productPrice=product.getPrice();

        tvNameProduct.setText(productName);
        tvPriceProduct.setText(Float.toString(productPrice));
        if(product.getPath() != null){
            Picasso.with(context).load(new File(product.getPath())).into(holder.imgProduct);
        }

        holder.setItemClickListener(new ItemClickListener() {

            @Override
            public void onItemClick(View v, int pos) {
                CheckBox chk= (CheckBox) v;
                //CKE IF ITS CHECKED OR NOT
                if(chk.isChecked())
                {
                    cartItem=new CartItem(products.get(position),quantity);
                    checkProducts.add(cartItem);
                }else  if(!chk.isChecked())
                {
                    cartItem=new CartItem(products.get(position),quantity);
                    checkProducts.remove(cartItem);
                }
            }
        });
        holder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                tvQuaritity.setText(number +"");
                quantity= Integer.parseInt(tvQuaritity.getText().toString());
            }
        });

        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number--;
                tvQuaritity.setText(number +"");
                quantity= Integer.parseInt(tvQuaritity.getText().toString());
            }
        });

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
        CircleImageView imgProduct;
        TextView tvNameProduct;
        TextView tvPriceProduct;
        CheckBox chk;
        ImageButton btnPlus;
        ImageButton btnMinus;
        TextView tvQuaritity;
        ItemClickListener itemClickListener;



        public ItemViewHolder(View itemView) {
            super(itemView);
            imgProduct= (CircleImageView) itemView.findViewById(R.id.imgProduct);
            tvNameProduct= (TextView) itemView.findViewById(R.id.tvNameProduct);
            tvPriceProduct= (TextView) itemView.findViewById(R.id.tvPriceProduct);
            tvQuaritity= (TextView) itemView.findViewById(R.id.tvQuaritity);
            chk= (CheckBox) itemView.findViewById(R.id.chk);
            btnPlus= (ImageButton) itemView.findViewById(R.id.btnPlus);
            btnMinus= (ImageButton) itemView.findViewById(R.id.btnMinus);
            chk.setOnClickListener(this);
            btnPlus.setOnClickListener(this);
            btnMinus.setOnClickListener(this);

        }

        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener=itemClickListener;
        }

        @Override
        public void onClick(final View v) {
            /*int adapterPosition=getAdapterPosition();
            Product item = products.get(adapterPosition);
            showPopup(itemView,item);
            Toast.makeText(context, "Chọn:"+item.getId() , Toast.LENGTH_SHORT).show();*/
            this.itemClickListener.onItemClick(v,this.getLayoutPosition());
        }

        private void showPopup(View v, final Product pos) {
            View menuItemView = v.findViewById(R.id.item);
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
                                        /*Toast.makeText(context, number+"", Toast.LENGTH_SHORT).show();*/
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
        OrderingFragment fragment=new OrderingFragment();
        Bundle bundle=new Bundle();
        bundle.putString("ProductName",pos.getName());
        bundle.putFloat("ProductPrice",pos.getPrice());
        bundle.putInt("ProductQuaritity", Integer.parseInt(mEdtQuaritity.getText().toString()));
        fragment.setArguments(bundle);

    }


    void getid(int id){
        Bundle bundle=new Bundle();
        bundle.putInt("KEY_ID",id);

        OrderingFragment orderingFragment=new OrderingFragment();
        orderingFragment.setArguments(bundle);
        ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.activity_order, orderingFragment).commit();

    }
}


