package com.example.ribon.quanliquancafe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.adapter.OrderAdapter;
import com.example.ribon.quanliquancafe.common.BaseFragment;
import com.example.ribon.quanliquancafe.loader.OrderDao;
import com.example.ribon.quanliquancafe.loader.ProductDao;
import com.example.ribon.quanliquancafe.loader.TableDao;
import com.example.ribon.quanliquancafe.model.CartItem;
import com.example.ribon.quanliquancafe.model.Order;
import com.example.ribon.quanliquancafe.model.Product;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Ribon on 05/03/2017.
 */

public class OrderingFragment extends BaseFragment{
    String productName;
    float productPrice;
    int productId;
    int tableId;
    int productQuaritity;
    List<CartItem> cartItems;
    List<Product>products;
    Product product;
    @Bind(R.id.rv_order)RecyclerView mRecyclerView;
    OrderAdapter adapter;
    int Total=0;
    Order order;

    @Override
    public int getResId() {
        return R.layout.fragment_ordering;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
        products=new ArrayList<>();
        ProductDao productDao=new ProductDao(getActivity());
        product=productDao.getProduct(productId);

        if (products.size()==0){
            products.add(product);
            order=new Order();
            order.setTotalCostOrder(Total);
            TableDao tableDao=new TableDao(getActivity());
            order.setTables(tableDao.getTable(tableId));
            Date today=new Date(System.currentTimeMillis());
            SimpleDateFormat timeFormat= new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
            String s=timeFormat.format(today.getTime());
            order.setDateOrder(s);
            OrderDao orderDao=new OrderDao(getActivity());
            orderDao.create(order);
        }


       /* CartItem cartItem=new CartItem();
        cartItem.setProduct(product);
        SessionUser sessionUser=SessionUser.getInstance();
        sessionUser.setItemsCart(cartItem);
        cartItems=sessionUser.getItemsCart();*/


        adapter = new OrderAdapter(getActivity(),cartItems);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        adapter.notifyDataSetChanged();
        /*Toast.makeText(getActivity(), ""+product.getName(), Toast.LENGTH_SHORT).show();*/

    }

    @OnClick(R.id.btnOrder)
        public void Order(){
        getFragmentManager().beginTransaction().replace(R.id.activity_order, new LoadProductFragment()).addToBackStack(null).commit();
        }
    @OnClick(R.id.btnSave)
        public void save() {
    }



    private void getData() {
        Bundle argument=getArguments();
        if(argument != null) {
            productId = argument.getInt("KEY_ID");
            tableId=argument.getInt("KEY_TABLE");
            Toast.makeText(getActivity(), "product: " + productId, Toast.LENGTH_SHORT).show();
            Toast.makeText(getActivity(), "Table: " + tableId, Toast.LENGTH_SHORT).show();
            /*Log.d("KEY_ID", "" + productId);*/
        }

    }
    public void update(int id){

    }




}


