package com.example.ribon.quanliquancafe.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ribon on 30/03/2017.
 */

public class SessionUser {
    private static SessionUser instance;
    private  List<CartItem> mCartItems=new ArrayList<>();

    private SessionUser() {
    }

    public static SessionUser getInstance() {
        if(instance == null) {
            instance = new SessionUser();
        }
        return instance;
    }

    public  void setItemsCart(CartItem cartItem){
        mCartItems.add(cartItem);
    }
    public  List<CartItem> getItemsCart(){
        return mCartItems;
    }
}
