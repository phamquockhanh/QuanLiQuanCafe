package com.example.ribon.quanliquancafe.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.adapter.OrderAdapter;
import com.example.ribon.quanliquancafe.model.CartItem;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderActivity extends AppCompatActivity /*implements ProductAdapter.OnIdSetListener*/ {
   /* ViewPager pager;
    TabLayout tabLayout;*/
    @Bind(R.id.rv_order)RecyclerView mRecyclerView;
    OrderAdapter adapter;
    static final int PICK_PRODUCT_REQUEST = 999;
    int idTable;
    ArrayList<CartItem>cartItems=new ArrayList<>();
    private static final String TAG = OrderActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_order);
        setSupportActionBar(toolbar);*/

        /*getSupportFragmentManager().beginTransaction().replace(R.id.activity_order, new LoadProductFragment()).commit();*/

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            idTable=bundle.getInt("TABLE");
            Toast.makeText(this, ""+idTable, Toast.LENGTH_SHORT).show();
        }
        /*sendTableId(idTable);*/
        adapter = new OrderAdapter(this,cartItems);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);



    }

    @OnClick(R.id.btnOrder)
    public void insert(){
        Intent i=new Intent(OrderActivity.this,ProductActivity.class);
        startActivityForResult(i,PICK_PRODUCT_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==PICK_PRODUCT_REQUEST){
            if(resultCode==RESULT_OK){
                Bundle bundle = data.getExtras();
                cartItems= (ArrayList<CartItem>) bundle.getSerializable("Key_Array");
                adapter.setData(cartItems);
                adapter.notifyDataSetChanged();
                StringBuffer sb=new StringBuffer();
                StringBuffer sb1=new StringBuffer();
                for(CartItem p : cartItems)
                {
                    sb.append(p.getProduct().getName());
                    sb.append("\n");
                    /*sb1.append(p.getQuantity());
                    sb.append("\n");*/

                }
                Toast.makeText(OrderActivity.this,sb.toString()+"-----"+sb1.toString(),Toast.LENGTH_SHORT).show();
            }
        }
    }

    /*private void sendTableId(int id) {
        Bundle bundle=new Bundle();
        bundle.putInt("KEY_TABLE",id);
        LoadProductFragment loadProductFragment=new LoadProductFragment();
        loadProductFragment.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_order, loadProductFragment);
        transaction.commit();
    }


   /* @Override
    public void setId(int id) {
        Log.d(TAG, id +"");
        OrderingFragment orderingFragment= (OrderingFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_ordering);
        if(orderingFragment!=null){
            orderingFragment.update(id);
        }else {
            OrderingFragment newOrderingFragment=new OrderingFragment();
            Bundle bundle=new Bundle();
            bundle.putInt("KEY_ID", id);
            bundle.putInt("KEY_TABLE",idTable);
            newOrderingFragment.setArguments(bundle);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.activity_order, newOrderingFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }*/
}
