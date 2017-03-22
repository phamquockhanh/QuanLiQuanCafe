package com.example.ribon.quanliquancafe.activity;


import android.app.Dialog;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.fragment.FastPaymentFragment;
import com.example.ribon.quanliquancafe.fragment.GuideFragment;
import com.example.ribon.quanliquancafe.fragment.InsertProductFragment;
import com.example.ribon.quanliquancafe.fragment.KitchenManagerFragment;
import com.example.ribon.quanliquancafe.fragment.ReportFragment;
import com.example.ribon.quanliquancafe.fragment.RepositoryFragment;
import com.example.ribon.quanliquancafe.fragment.RevenueAndExpenditureFragment;
import com.example.ribon.quanliquancafe.fragment.SellFragment;
import com.example.ribon.quanliquancafe.util.FragmentUtils;

import butterknife.ButterKnife;
import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    /*@Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Dialog dialog=new Dialog(MainActivity.this);
        dialog.setTitle("Thêm bàn");

        dialog.setContentView(R.layout.insert_customdialog_layout);
        dialog.show();*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ButterKnife.bind(this);

        SQLiteStudioService.instance().start(this);
        SQLiteStudioService.instance().setPort(9999);




        getSupportFragmentManager().beginTransaction().replace(R.id.content_main,new SellFragment()).commit();
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer,menu);
        return super.onCreateOptionsMenu(menu);
    }*/
    @Override
    protected void onDestroy() {
        SQLiteStudioService.instance().stop();
        super.onDestroy();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify table_view parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment=null;

        int id = item.getItemId();

        if (id == R.id.nav_sell) {
            fragment = new SellFragment();

        } else if (id == R.id.insert_product) {
            fragment = new InsertProductFragment();
        } else if (id == R.id.nav_report) {
            fragment = new ReportFragment();
        } else if (id == R.id.nav_fast_payment) {
            fragment = new FastPaymentFragment();
        } else if (id == R.id.nav_repository) {
            fragment = new RepositoryFragment();
        } else if (id == R.id.ic_revenue_and_expenditure) {
            fragment = new RevenueAndExpenditureFragment();
        }
        FragmentUtils.replaceFragment(this.getSupportFragmentManager(), fragment, true);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}




