package com.example.ribon.quanliquancafe.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.fragment.OrderingFragment;

public class TextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        /*getSupportFragmentManager().beginTransaction().replace(R.id.activity_text, new OrderingFragment()).commit();*/
    }
}
