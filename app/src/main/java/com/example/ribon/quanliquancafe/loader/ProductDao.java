package com.example.ribon.quanliquancafe.loader;

import android.content.Context;

import com.example.ribon.quanliquancafe.model.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ribon on 17/03/2017.
 */

public class ProductDao extends DatabaseManager {
    public ProductDao(Context context) {
        super(context);
    }
    public void create(Product obj){
        try {
            this.getHelper().getProductDao().create(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Product obj){
        try {
            this.getHelper().getProductDao().update(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(Product obj){
        try {
            this.getHelper().getProductDao().delete(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Product>getAll(){
        List<Product>products=new ArrayList<>();
        try {
            products=this.getHelper().getProductDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getProduct(int id){
        Product product=new Product();
        try {
            product=this.getHelper().getProductDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
