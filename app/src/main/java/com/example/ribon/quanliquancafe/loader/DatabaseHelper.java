package com.example.ribon.quanliquancafe.loader;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.ribon.quanliquancafe.R;
import com.example.ribon.quanliquancafe.model.Category;
import com.example.ribon.quanliquancafe.model.Order;
import com.example.ribon.quanliquancafe.model.OrderDetails;
import com.example.ribon.quanliquancafe.model.Product;
import com.example.ribon.quanliquancafe.model.Table;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Ribon on 16/03/2017.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME="coffee_ormlite.db";
    private static final int DATABASE_VERSION=1;

    private Dao<Table,Integer> tableDao=null;
    private RuntimeExceptionDao<Table,Integer> tableRuntimeDao=null;
    private Dao<Category,Integer> categoryDao=null;
    private RuntimeExceptionDao<Category,Integer> categoryRuntimeDao=null;
    private Dao<Product,Integer> productDao=null;
    private RuntimeExceptionDao<Product,Integer> productRuntimeDao=null;
    private Dao<Order,Integer> orderDao=null;
    private RuntimeExceptionDao<Order,Integer> orderRuntimeDao=null;
    private Dao<OrderDetails,Integer> orderDetailsDao=null;
    private RuntimeExceptionDao<OrderDetails,Integer> orderDetailsRuntimeDao=null;

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION,R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getSimpleName(),"onCreate");
            TableUtils.createTable(connectionSource, Table.class);
            TableUtils.createTable(connectionSource, Category.class);
            TableUtils.createTable(connectionSource, Product.class);
            TableUtils.createTable(connectionSource, Order.class);
            TableUtils.createTable(connectionSource, OrderDetails.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getSimpleName(),"Imosible crear la base de datos",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getSimpleName(),"onupgrade()");
            TableUtils.dropTable(connectionSource,Table.class,true);
            TableUtils.dropTable(connectionSource,Category.class,true);
            TableUtils.dropTable(connectionSource,Product.class,true);
            TableUtils.dropTable(connectionSource,Order.class,true);
            TableUtils.dropTable(connectionSource,OrderDetails.class,true);
            onCreate(database,connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getSimpleName(),"Imosible crear la base de datos",e);
            throw new RuntimeException(e);
        }
    }

    public Dao<Table, Integer> getTableDao() throws SQLException {
        if (tableDao==null)
            tableDao=getDao(Table.class);
        return tableDao;
    }

    public RuntimeExceptionDao<Table,Integer>getTableRunTimeExceptionDao(){
        if (tableRuntimeDao==null){
            tableRuntimeDao=getRuntimeExceptionDao(Table.class);
        }
        return tableRuntimeDao;
    }

    public Dao<Category, Integer> getCategoryDao() throws SQLException {
        if (categoryDao==null)
            categoryDao=getDao(Category.class);
        return categoryDao;
    }

    public RuntimeExceptionDao<Category,Integer>getCategoryRunTimeExceptionDao(){
        if (categoryRuntimeDao==null){
            categoryRuntimeDao=getRuntimeExceptionDao(Category.class);
        }
        return categoryRuntimeDao;
    }

    public Dao<Product, Integer> getProductDao() throws SQLException {
        if (productDao==null)
            productDao=getDao(Product.class);
        return productDao;
    }

    public RuntimeExceptionDao<Product,Integer>getProductRuntimeDao(){
        if (productRuntimeDao==null){
            productRuntimeDao=getRuntimeExceptionDao(Product.class);
        }
        return productRuntimeDao;
    }
    public Dao<Order, Integer> getOrderDao() throws SQLException {
        if (orderDao==null)
            orderDao=getDao(Order.class);
        return orderDao;
    }

    public RuntimeExceptionDao<Order,Integer>getOrderRuntimeDao(){
        if (orderRuntimeDao==null){
            orderRuntimeDao=getRuntimeExceptionDao(Order.class);
        }
        return orderRuntimeDao;
    }

    public Dao<OrderDetails, Integer> getOrderDetailsDao() throws SQLException {
        if (orderDetailsDao==null)
            orderDetailsDao=getDao(OrderDetails.class);
        return orderDetailsDao;
    }

    public RuntimeExceptionDao<OrderDetails,Integer>getOrderDetailsRuntimeDao(){
        if (orderDetailsRuntimeDao==null){
            orderDetailsRuntimeDao=getRuntimeExceptionDao(OrderDetails.class);
        }
        return orderDetailsRuntimeDao;
    }
    @Override
    public void close() {
        super.close();
        tableDao=null;
        tableRuntimeDao=null;
        categoryDao=null;
        categoryRuntimeDao=null;
        productDao=null;
        productRuntimeDao=null;
        orderDao=null;
        orderRuntimeDao=null;
        orderDetailsDao=null;
        orderDetailsRuntimeDao=null;
    }

}
