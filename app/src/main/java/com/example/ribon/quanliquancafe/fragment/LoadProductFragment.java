package com.example.ribon.quanliquancafe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.adapter.OrderRecyclerAdapter;
import com.example.ribon.quanliquancafe.common.BaseFragment;
import com.example.ribon.quanliquancafe.loader.ProductDao;
import com.example.ribon.quanliquancafe.model.Category;
import com.example.ribon.quanliquancafe.util.FragmentUtils;

import butterknife.Bind;

/**
 * Created by Ribon on 19/03/2017.
 */

public class LoadProductFragment extends BaseFragment implements OrderRecyclerAdapter.OrderRecyclerAdapterOnClickHandler {
    @Bind(R.id.rv_order)RecyclerView mRecyclerView;
    OrderRecyclerAdapter adapter;
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
        ProductDao productDao=new ProductDao(getActivity());
        adapter = new OrderRecyclerAdapter(getActivity(),productDao.getAll(),this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.product, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id== R.id.action_insert_product){
            FragmentUtils.replaceFragment(getActivity().getSupportFragmentManager(), new InsertProductFragment(), true);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(Category category) {

    }
}
