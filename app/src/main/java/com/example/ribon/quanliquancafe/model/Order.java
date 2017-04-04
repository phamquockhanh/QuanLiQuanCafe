package com.example.ribon.quanliquancafe.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ribon on 22/03/2017.
 */
@DatabaseTable(tableName = "Order")
public class Order implements Serializable {
    @DatabaseField(generatedId = true,columnName = "ID")
    int id;
    @DatabaseField(columnName = "DATEORDER")
    String dateOrder;
    @DatabaseField(columnName = "TOTALCOSTORDER")
    float totalCostOrder;
    @DatabaseField(foreign=true,foreignAutoRefresh=true, foreignColumnName = "ID")
    private Table tables;

    public Order(int id, String dateOrder, float totalCostOrder, Table tables) {
        this.id = id;
        this.dateOrder = dateOrder;
        this.totalCostOrder = totalCostOrder;
        this.tables = tables;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public float getTotalCostOrder() {
        return totalCostOrder;
    }

    public void setTotalCostOrder(float totalCostOrder) {
        this.totalCostOrder = totalCostOrder;
    }

    public Table getTables() {
        return tables;
    }

    public void setTables(Table tables) {
        this.tables = tables;
    }
}
