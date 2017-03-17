package com.example.ribon.quanliquancafe.loader;

import android.content.Context;

import com.example.ribon.quanliquancafe.loader.DatabaseManager;
import com.example.ribon.quanliquancafe.model.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ribon on 17/03/2017.
 */

public class CategoryDao extends DatabaseManager {
    public CategoryDao(Context context) {
        super(context);
    }

    public void create(Category obj){
        try {
            this.getHelper().getCategoryDao().create(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Category obj){
        try {
            this.getHelper().getCategoryDao().update(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Category obj){
        try {
            this.getHelper().getCategoryDao().delete(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Category> getAll(){
        List<Category>categories=null;
        try {
            categories=this.getHelper().getCategoryDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
