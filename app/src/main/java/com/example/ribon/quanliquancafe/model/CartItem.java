package com.example.ribon.quanliquancafe.model;

import java.io.Serializable;

/**
 * Created by Ribon on 30/03/2017.
 */

public class CartItem implements Serializable{
    private Product mProduct;
    private int mQuantity;

    public CartItem(Product product, int quantity){
        mProduct=product;
        mQuantity=quantity;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuantity(int quantity) {
        this.mQuantity = quantity;
    }

    public Product getProduct() {
        return mProduct;
    }

    public void setProduct(Product product) {
        this.mProduct = product;
    }

}
