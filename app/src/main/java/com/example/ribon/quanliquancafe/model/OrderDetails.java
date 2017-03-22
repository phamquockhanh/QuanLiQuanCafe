package com.example.ribon.quanliquancafe.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Ribon on 22/03/2017.
 */
@DatabaseTable(tableName = "OrderDetail")
public class OrderDetails implements Serializable {
    @DatabaseField(generatedId = true,columnName = "ID")
    int id;
    @DatabaseField(columnName = "QUANTITYDETAIL")
    int quantityDetail;
    @DatabaseField(columnName = "PRICEDETAIL")
    float priceDetail;
    @DatabaseField(foreign=true,foreignAutoRefresh=true, foreignColumnName = "ID")
    Product products;
    @DatabaseField(foreign=true,foreignAutoRefresh=true, foreignColumnName = "ID")
    Order orders;

    public OrderDetails(int id, int quantityDetail, float priceDetail, Product products, Order orders) {
        this.id = id;
        this.quantityDetail = quantityDetail;
        this.priceDetail = priceDetail;
        this.products = products;
        this.orders = orders;
    }

    public OrderDetails() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantityDetail() {
        return quantityDetail;
    }

    public void setQuantityDetail(int quantityDetail) {
        this.quantityDetail = quantityDetail;
    }

    public float getPriceDetail() {
        return priceDetail;
    }

    public void setPriceDetail(float priceDetail) {
        this.priceDetail = priceDetail;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }
}
