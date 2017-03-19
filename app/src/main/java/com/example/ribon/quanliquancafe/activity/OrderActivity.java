package com.example.ribon.quanliquancafe.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.fragment.InsertProductFragment;
import com.example.ribon.quanliquancafe.fragment.LoadProductFragment;
import com.example.ribon.quanliquancafe.fragment.SellFragment;
import com.example.ribon.quanliquancafe.loader.CategoryDao;
import com.example.ribon.quanliquancafe.loader.TableDao;
import com.example.ribon.quanliquancafe.model.Category;
import com.example.ribon.quanliquancafe.model.Table;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderActivity extends AppCompatActivity {
   /* ViewPager pager;
    TabLayout tabLayout;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_order);
        setSupportActionBar(toolbar);
        createCategory();
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_order,new LoadProductFragment()).commit();
    }

    private void createCategory() {
        Log.i("OrmLite", "######");

        CategoryDao categoryDao = new CategoryDao(this);

        if (categoryDao.getAll().size()== 0) {
            Category category = new Category();
            category.setName("Món ăn");
            categoryDao.create(category);
            Log.i("OrmLite", "Id" + category.getId());
            Toast.makeText(this, "" + category.getId(), Toast.LENGTH_SHORT).show();

            Category category1 = new Category();
            category1.setName("Thức uống");
            categoryDao.create(category1);
            Log.i("OrmLite", "Id" + category1.getId());
            Toast.makeText(this, "" + category1.getId(), Toast.LENGTH_SHORT).show();

        }
    }

}
