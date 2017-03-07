package com.example.ribon.quanliquancafe.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ribon.quanliquancafe.fragment.OrderedFragment;
import com.example.ribon.quanliquancafe.fragment.OrderingFragment;

/**
 * Created by Ribon on 05/03/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag=new OrderingFragment();
                break;
            case 1:
                frag=new OrderedFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title="Đang Order";
                break;
            case 1:
                title="Đã Order";
                break;
        }

        return title;
    }
}
