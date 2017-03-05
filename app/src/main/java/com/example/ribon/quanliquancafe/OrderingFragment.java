package com.example.ribon.quanliquancafe;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ribon on 05/03/2017.
 */

public class OrderingFragment extends android.support.v4.app.Fragment {
    public OrderingFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ordering, container, false);
    }


}
