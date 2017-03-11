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
    public Table(String tableName, int sort) {
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

    public String setTableName(String tableName) {
        this.tableName = tableName;
        return tableName;
    }

    public int getSort() {
        return sort;
    }

    public int setSort(int sort) {
        this.sort = sort;
        return sort;
    }
}
