package com.example.ribon.quanliquancafe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.adapter.ProductManagerAdapter;
import com.example.ribon.quanliquancafe.common.BaseFragment;
import com.example.ribon.quanliquancafe.loader.ProductDao;

import butterknife.Bind;

/**
 * Created by Ribon on 07/03/2017.
 */

public class FastPaymentFragment extends BaseFragment {
    @Bind(R.id.rvManagerProduct)RecyclerView mRecyclerView;
    ProductManagerAdapter adapter;
    @Override
    public int getResId() {
        return R.layout.fragment_fast_payment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ProductDao productDao = new ProductDao(getActivity());
        adapter = new ProductManagerAdapter(getActivity(), productDao.getAll());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
    }
}
