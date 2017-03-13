package com.example.ribon.quanliquancafe.model;





import com.bignerdranch.expandablerecyclerview.model.Parent;

import java.util.List;

/**
 * Created by Ribon on 09/03/2017.
 */

public class Table implements Parent<Option> {
    private List<Option> mChildrenList;
    private int id;
    private String tableName;
    private int sort;


    public Table(String tableName){
        this.tableName=tableName;
    }
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

    public Table(List<Option> options) {
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

    @Override
    public List<Option> getChildList() {
        return mChildrenList;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
    public void setChildList(List<Option> childList) {
        mChildrenList = childList;
    }

}
