package com.example.ribon.quanliquancafe.model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Ribon on 15/03/2017.
 */
@DatabaseTable(tableName = "Product")
public class Product implements Serializable{
    @DatabaseField(generatedId = true,columnName = "ID")
    private int id;
    @DatabaseField(columnName = "NAME")
    private String mName;
    @DatabaseField(columnName = "PRICE")
    private float mPrice;
    @DatabaseField(columnName = "URL_IMG")
    private String mPath;
    @DatabaseField(columnName = "DESCRIPTION")
    private String mDescription;
    @DatabaseField(foreign=true,foreignAutoRefresh=true, foreignColumnName = "ID")
    private Category categories;

    public Product(Category categories, String url, int quantity, float price, String name) {
        this.categories = categories;
        mPath = url;
        /*this.quantity = quantity;*/
        mPrice = price;
        mName = name;
    }

    public Product() {
    }

    public Product(String name, float price,String path, Category categories) {
        mName = name;
        mPrice = price;
        mPath = path;
        this.categories = categories;
    }

    public Product(String name, float price, int quantity) {
        mName = name;
        mPrice = price;
       /* this.quantity = quantity;*/
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public float getPrice() {
        return mPrice;
    }

    public void setPrice(float price) {
        mPrice = price;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        mPath = path;
    }


    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

}
