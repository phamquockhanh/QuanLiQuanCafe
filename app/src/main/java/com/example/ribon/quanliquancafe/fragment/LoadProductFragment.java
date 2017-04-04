package com.example.ribon.quanliquancafe.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.adapter.ProductAdapter;
import com.example.ribon.quanliquancafe.common.BaseFragment;
import com.example.ribon.quanliquancafe.loader.ProductDao;

import butterknife.Bind;

/**
 * Created by Ribon on 19/03/2017.
 */

public class LoadProductFragment extends BaseFragment /*implements ProductAdapter.OnIdSetListener*/ {
    @Bind(R.id.rv_product)
    RecyclerView mRecyclerView;
    ProductAdapter adapter;
    int tableId;

    @Override
    public int getResId() {
        return R.layout.fragment_load_product;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        ProductDao productDao = new ProductDao(getActivity());
        adapter = new ProductAdapter(getActivity(), productDao.getAll());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyclerView.setHasFixedSize(true);
        /*ProductAdapter.OnIdSetListener listener = (ProductAdapter.OnIdSetListener) getActivity();
        adapter.setOnIdSetListener(listener);*/



    }


    private void getData() {
        Bundle argument=getArguments();
        if(argument != null) {
            tableId=argument.getInt("KEY_TABLE");
            Toast.makeText(getActivity(), "Table: " + tableId, Toast.LENGTH_SHORT).show();
            /*Log.d("KEY_ID", "" + productId);*/
        }

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

   /* @Override
    public void setId(int id) {
        Toast.makeText(getActivity(), "" + id, Toast.LENGTH_SHORT).show();
    }*/
}
