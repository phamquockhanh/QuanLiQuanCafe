package com.example.ribon.quanliquancafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import org.askerov.dynamicgrid.DynamicGridView;

import java.util.ArrayList;
import java.util.Arrays;

public class BanHangActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private DynamicGridView gridView;
    private String[] someTable= {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
            "12","13","14","15","16","17","18"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.
                activity_ban_hang);
        gridView = (DynamicGridView) findViewById(R.id.dynamic_grid);
        ArrayList arrayList = new ArrayList<>(Arrays.asList(someTable));

        GridViewAdapter gridViewAdpter = new GridViewAdapter(this, arrayList, 3);
        gridView.setAdapter(gridViewAdpter);
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView parent, View view, int position, long id) {
                gridView.startEditMode(position);

                return true;
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                /*new AlertDialog.Builder(BanHangActivity.this)
                        .setTitle("Item information")
                        .setMessage("You clicked at position: " + position +"\n"
                                + "The letter is: " + parent.getItemAtPosition(position).toString())
                        .setPositiveButton(android.R.string.yes, null)

                        .setIcon(android.R.drawable.ic_dialog_info)
                        .show();*/
                Intent intent=new Intent(BanHangActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {
        if (gridView.isEditMode()) {
            gridView.stopEditMode();
        } else {
            super.onBackPressed();
        }
    }
}
