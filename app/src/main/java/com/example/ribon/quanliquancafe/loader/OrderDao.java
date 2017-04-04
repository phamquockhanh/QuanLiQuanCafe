package com.example.ribon.quanliquancafe.loader;

import android.content.Context;

import com.example.ribon.quanliquancafe.model.Order;
import com.example.ribon.quanliquancafe.model.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ribon on 02/04/2017.
 */

public class OrderDao extends DatabaseManager {
    public OrderDao(Context context) {
        super(context);
    }
    public void create(Order obj){
        try {
            this.getHelper().getOrderDao().create(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Order obj){
        try {
            this.getHelper().getOrderDao().update(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(Order obj){
        try {
            this.getHelper().getOrderDao().delete(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Order> getAll(){
        List<Order>orders=new ArrayList<>();
        try {
            orders=this.getHelper().getOrderDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public Order getOrder(int id){
        Order order=new Order();
        try {
            order=this.getHelper().getOrderDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
}
