package com.rmk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by RashMin on 03-11-2016.
 */
public class ShopingCart implements Serializable {

    String cartId;
    List<ShopingItem> items;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public List<ShopingItem> getItems() {
        return items;
    }

    public void setItems(List<ShopingItem> items) {
        this.items = items;
    }
}
