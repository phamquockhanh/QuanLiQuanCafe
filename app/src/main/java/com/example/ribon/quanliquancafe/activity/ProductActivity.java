package com.example.ribon.quanliquancafe.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.adapter.ProductAdapter;
import com.example.ribon.quanliquancafe.loader.ProductDao;
import com.example.ribon.quanliquancafe.model.CartItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductActivity extends AppCompatActivity {
    @Bind(R.id.rv_product)
    RecyclerView mRecyclerView;
    ProductAdapter adapter;
    StringBuffer sb=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ProductDao productDao = new ProductDao(this);
        adapter = new ProductAdapter(this, productDao.getAll());
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    @OnClick(R.id.fab)
    public void resultCode(){
        sb=new StringBuffer();

        for(CartItem p : adapter.checkProducts)
        {
            sb.append(p.getProduct().getName());
            sb.append("\n");
        }

        if(adapter.checkProducts.size()>0)
        {
            /*Toast.makeText(ProductActivity.this,sb.toString(),Toast.LENGTH_SHORT).show();*/
            Intent intent=new Intent();
            intent.putExtra("Key_Array",adapter.checkProducts);
            setResult(RESULT_OK,intent);
            finish();
        }else
        {
            Toast.makeText(ProductActivity.this,"Please Check Players",Toast.LENGTH_SHORT).show();
        }
    }
}
