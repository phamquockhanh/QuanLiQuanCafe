package com.example.ribon.quanliquancafe.loader;

import android.content.Context;
import android.support.design.widget.TabLayout;

import com.example.ribon.quanliquancafe.model.Table;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ribon on 16/03/2017.
 */

public class TableDao extends DatabaseManager {

    public TableDao(Context context) {
        super(context);
    }

    public void create(Table obj){
        try {
            this.getHelper().getTableDao().create(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try {
            this.getHelper().getTableDao().deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Table obj,int pos){
        try {
            this.getHelper().getTableDao().queryBuilder();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Table> getAll(){
        List<Table>tables=null;
        try {
            tables=this.getHelper().getTableDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tables;
    }

    public long sortMax(){
        long i=0;
        try {
            i=this.getHelper().getTableDao().queryRawValue("SELECT MAX(SORT) FROM Table");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

}
