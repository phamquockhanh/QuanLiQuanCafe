package com.example.ribon.quanliquancafe.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.fragment.HomeFragment;

import butterknife.ButterKnife;
import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;
import pl.com.salsoft.sqlitestudioremote.internal.SQLiteStudioDbService;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SQLiteStudioService.instance().start(this);
        SQLiteStudioService.instance().setPort(9999);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main,new HomeFragment()).commit();
    }

    @Override
    protected void onDestroy() {
        SQLiteStudioService.instance().stop();
        super.onDestroy();
    }
}




