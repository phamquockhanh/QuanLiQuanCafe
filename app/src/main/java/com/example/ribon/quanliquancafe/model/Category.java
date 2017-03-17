package com.example.ribon.quanliquancafe.model;

/*

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.List;

*/

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ribon on 15/03/2017.
 */

@DatabaseTable(tableName = "Category")
public class Category implements Serializable{
    @DatabaseField(generatedId = true,columnName = "ID")
    private int id;
    @DatabaseField(columnName = "NAME")
    private String name;
    @ForeignCollectionField
    private ForeignCollection<Category>categories;

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category>getCategories(){
        List<Category>categories=null;
        for (Category category:categories){
            categories.add(category);
        }
        return categories;
    }

}
