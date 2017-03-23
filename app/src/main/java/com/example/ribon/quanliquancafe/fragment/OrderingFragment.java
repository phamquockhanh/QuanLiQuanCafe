package com.example.ribon.quanliquancafe.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.common.BaseFragment;
import com.example.ribon.quanliquancafe.util.FragmentUtils;

import java.security.PublicKey;

import butterknife.OnClick;

/**
 * Created by Ribon on 05/03/2017.
 */

public class OrderingFragment extends BaseFragment {
    String productName;
    float productPrice;
    int productQuaritity;

    @Override
    public int getResId() {
        return R.layout.fragment_ordering;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @OnClick(R.id.btnOrder)
        public void Order(){
        getFragmentManager().beginTransaction().replace(R.id.activity_order, new LoadProductFragment()).addToBackStack(null).commit();
        }
    @OnClick(R.id.btnSave)
        public void save(){
        getData();
        Toast.makeText(getActivity(), ""+productName, Toast.LENGTH_SHORT).show();
        }



    private void getData() {
        productName=getArguments().getString("ProductName");
        productPrice=getArguments().getFloat("ProductPrice");
        productQuaritity=getArguments().getInt("ProductQuaritity");
    }

}


