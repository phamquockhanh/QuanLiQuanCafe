package com.example.ribon.quanliquancafe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.common.BaseFragment;
import com.example.ribon.quanliquancafe.util.FragmentUtils;

/**
 * Created by Ribon on 19/03/2017.
 */

public class LoadProductFragment extends BaseFragment {
    @Override
    public int getResId() {
        return R.layout.fragment_load_product;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
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
}
