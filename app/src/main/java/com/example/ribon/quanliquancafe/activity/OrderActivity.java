package com.example.ribon.quanliquancafe.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.loader.CategoryDao;
import com.example.ribon.quanliquancafe.loader.TableDao;
import com.example.ribon.quanliquancafe.model.Category;
import com.example.ribon.quanliquancafe.model.Table;

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
       /* pager= (ViewPager) findViewById(R.id.view_pager);
        tabLayout= (TabLayout) findViewById(R.id.tab_layout);

        FragmentManager manager = getSupportFragmentManager();
        PagerAdapter adapter = new PagerAdapter(manager);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);*/
        createCategory();




    }
    /*@OnClick(R.id.btntest)
    public void test(){
        Category categories=new Category("Món ăn");
        Category categories1=new Category("Thức uống");
    }*/

    private void createCategory() {
        Log.i("OrmLite","######");

        CategoryDao categoryDao=new CategoryDao(this);
        /*int i=categoryDao.getAll().size();
        Toast.makeText(this, ""+i, Toast.LENGTH_LONG).show();*/

            Category category=new Category() ;
            category.setName("Món ăn");
            categoryDao.create(category);
            Log.i("OrmLite","Id"+category.getId());
        Toast.makeText(this, ""+category.getId(), Toast.LENGTH_SHORT).show();

            Category category1=new Category() ;
            category1.setName("Thức uống");
            categoryDao.create(category1);
            Log.i("OrmLite","Id"+category.getId());
        Toast.makeText(this, ""+category.getId(), Toast.LENGTH_SHORT).show();

    }
}
