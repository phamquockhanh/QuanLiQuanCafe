package com.example.ribon.quanliquancafe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.common.BaseFragment;

/**
 * Created by Ribon on 07/03/2017.
 */

public class ReportFragment extends BaseFragment {
   int productId;
    @Override
    public int getResId() {
        return R.layout.fragment_report;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    private void getData() {
        /*productName=getArguments().getString("ProductName");
        productPrice=getArguments().getFloat("ProductPrice");
        productQuaritity=getArguments().getInt("ProductQuaritity");*/
        Bundle argument=getArguments();
            /*productName=this.getArguments().getString("NAME_KEY");
            productPrice=this.getArguments().getFloat("PRICE_KEY");*/
        productId=argument.getInt("KEY_ID");
        Toast.makeText(getActivity(), ""+productId, Toast.LENGTH_SHORT).show();
        Log.d("loi",""+productId);

    }

}
