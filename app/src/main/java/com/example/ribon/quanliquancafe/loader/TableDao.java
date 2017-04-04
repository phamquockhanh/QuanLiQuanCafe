package com.example.ribon.quanliquancafe.loader;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.Log;

import com.example.ribon.quanliquancafe.model.Product;
import com.example.ribon.quanliquancafe.model.Table;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
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

    public boolean update(int tableId,int pos){
        try {
            UpdateBuilder<Table, Integer> updateBuilder = this.getHelper().getTableDao().updateBuilder();
            updateBuilder.updateColumnValue("sort", pos).where().eq("id", tableId);
            if(updateBuilder.update() > 0){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Log.d("test", e.getMessage());
        }
        return false;
    }

    public List<Table> getAll(){
        List<Table>tables = new ArrayList<>();
        try {
            tables=this.getHelper().getTableDao().queryBuilder().orderBy("sort",true).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tables;
    }

   /* public Table getTableByName(String name){
        try {
            return getHelper().getTableDao().queryBuilder().where().eq("title",name).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    public int sortMax(){
        int i = 0;
        try {
            Table table = getHelper().getTableDao().queryBuilder().orderBy("ID", true).queryForFirst();
            i = table.getId()+1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    public Table getTable(int id){
        Table table=new Table();
        try {
            table=this.getHelper().getTableDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return table;
    }

}
