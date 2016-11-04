package com.rmk.service;

import com.rmk.model.ShopingCart;
import com.rmk.model.ShopingItem;

import java.util.List;
import java.util.Optional;

/**
 * Created by RashMin on 03-11-2016.
 */
public class CartServiceImpl implements CartService {

    public boolean addItemToCart(ShopingCart cart, ShopingItem item) {
        List<ShopingItem> items

        Optional.ofNullable(cart.getItems())
                .map(items->{
                    if(items.contains(item)){
                        int index= items.indexOf(item);
                        if(index>0){
                            //Item is found!
                            ShopingItem item = items.get(index);
                            item.setQty(item.getQty()+1);
                        }
                    }
                })
                .orElse(null);

        return false;
    }

    public boolean emptyCart(ShopingCart cart) {
        return false;
    }

    public boolean removeItemToCart(ShopingCart cart, ShopingItem item) {
        return false;
    }

    public ShopingCart createCart() {
        return null;
    }

    public ShopingItem createCartItem() {
        return null;
    }
}
