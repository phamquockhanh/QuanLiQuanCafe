package com.example.ribon.quanliquancafe.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.adapter.ProductRecyclerAdapter;
import com.example.ribon.quanliquancafe.common.BaseFragment;
import com.example.ribon.quanliquancafe.interfaces.OnFragmentManager;
import com.example.ribon.quanliquancafe.loader.ProductDao;
import com.example.ribon.quanliquancafe.model.Product;

import butterknife.Bind;

/**
 * Created by Ribon on 19/03/2017.
 */

public class LoadProductFragment extends BaseFragment implements ProductRecyclerAdapter.ProductRecyclerAdapterOnClickHandler,OnFragmentManager {
    @Bind(R.id.rv_product)RecyclerView mRecyclerView;
    ProductRecyclerAdapter adapter;
    OnFragmentManager listener;
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
        adapter = new ProductRecyclerAdapter(getActivity(),productDao.getAll(),this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mRecyclerView.setHasFixedSize(true);
        adapter.notifyDataSetChanged();

    }

   /* @Override
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
    }*/



   /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentManager){
            listener= (OnFragmentManager ) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement onViewSelected");
        }
    }*/

    @Override
    public void onDataSelected(String data) {

    }

    @Override
    public void onClick(Product pos, String name, float price) {
        LoadProductFragment fragment=new LoadProductFragment();
        Bundle bundle=new Bundle();
        bundle.putString("ProductName",pos.getName());
        bundle.putFloat("ProductPrice",pos.getPrice());
        fragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.activity_order, new OrderingFragment()).addToBackStack(null).commit();
    }



}
