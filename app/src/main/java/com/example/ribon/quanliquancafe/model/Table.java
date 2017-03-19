package com.example.ribon.quanliquancafe.model;





import com.bignerdranch.expandablerecyclerview.model.Parent;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


import java.io.Serializable;
import java.util.List;

/**
 * Created by Ribon on 09/03/2017.
 */
@DatabaseTable(tableName="Table")
public class Table implements Serializable{
    @DatabaseField(generatedId = true,columnName = "ID")
    private int id;
    @DatabaseField(columnName = "TITLE")
    private String title;
    @DatabaseField(columnName="SORT",canBeNull = false)
    private int sort;

    public Table(String title,int sort) {
        this.title = title;
        this.sort=sort;
    }

    public Table(String title) {
        this.title = title;
    }

    public Table(){
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}