package com.example.ribon.quanliquancafe.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.common.BaseFragment;
import com.example.ribon.quanliquancafe.util.DateUtils;
import com.example.ribon.quanliquancafe.util.FragmentUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.OnClick;

/**
 * Created by Ribon on 07/03/2017.
 */

public class HomeFragment extends BaseFragment {

    @Override
    public int getResId() {
        return R.layout.fragment_home;
    }

    @OnClick({R.id.btn_guide, R.id.btn_sell, R.id.btn_report,
            R.id.btn_fast_payment, R.id.btn_revenue_and_expenditure,
            R.id.btn_kitchen_manager, R.id.btn_repository, R.id.btn_setting})

    public void openFragmentOnClick(View view){
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = null;

        //controller click
        switch (view.getId()){
            case R.id.btn_guide:
                fragment = new GuideFragment();
                break;

            case R.id.btn_sell:
                fragment = new SellFragment();
                break;

            case R.id.btn_report:
                fragment = new ReportFragment();
                break;

            case R.id.btn_fast_payment:
                fragment = new FastPaymentFragment();
                break;

            case R.id.btn_revenue_and_expenditure:
                fragment = new RevenueAndExpenditureFragment();
                break;

            case R.id.btn_kitchen_manager:
                fragment = new KitchenManagerFragment();
                break;

            case R.id.btn_repository:
                fragment = new RepositoryFragment();
                break;

            case R.id.btn_setting:
                fragment = new SettingFragment();
                break;
        }

        //replace fragment
        FragmentUtils.replaceFragment(getActivity().getSupportFragmentManager(), fragment, true);

    }



}
