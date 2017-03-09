package com.example.ribon.quanliquancafe.model;

/**
 * Created by Ribon on 09/03/2017.
 */

public class Table {
    private int id;
    private String tableName;
    private int sort;

    public Table(int id, String tableName, int sort) {
        this.id = id;
        this.tableName = tableName;
        this.sort = sort;
    }

    public Table() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
