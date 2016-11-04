package com.rmk.service;

import com.rmk.model.ShopingCart;
import com.rmk.model.ShopingItem;

/**
 * Created by RashMin on 03-11-2016.
 */
public interface CartService {

    boolean addItemToCart(ShopingCart cart, ShopingItem item);
    boolean emptyCart(ShopingCart cart);
    boolean removeItemToCart(ShopingCart cart, ShopingItem item);
    ShopingCart createCart();
    ShopingItem createCartItem();

}
