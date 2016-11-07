package com.rmk.service;

import com.rmk.model.ShoppingCart;
import com.rmk.model.ShoppingItem;

/**
 * Created by RashMin on 03-11-2016.
 */
public interface CartService {

    boolean addItemToCart(ShoppingCart cart, ShoppingItem item);
    boolean emptyCart(ShoppingCart cart);
    boolean removeItemToCart(ShoppingCart cart, ShoppingItem item);
    boolean removeItemFromCart(Integer cartId,ShoppingItem item);
    ShoppingCart createCart(ShoppingCart cart);
    ShoppingItem createCartItem(ShoppingItem item);

}
