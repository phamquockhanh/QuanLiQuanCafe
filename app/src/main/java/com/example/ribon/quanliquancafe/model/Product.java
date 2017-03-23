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
    private String name;
    @DatabaseField(columnName = "PRICE")
    private float price;
    @DatabaseField(columnName = "QUANTITY")
    private int quantity;
    @DatabaseField(columnName = "URL_IMG")
    private String path;
    @DatabaseField(foreign=true,foreignAutoRefresh=true, foreignColumnName = "ID")
    private Category categories;

    public Product(Category categories, String url, int quantity, float price, String name) {
        this.categories = categories;
        this.path = url;
        /*this.quantity = quantity;*/
        this.price = price;
        this.name = name;
    }

    public Product() {
    }

    public Product(String name, float price, int quantity, String path, Category categories) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.path = path;
        this.categories = categories;
    }

    public Product(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
       /* this.quantity = quantity;*/
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
