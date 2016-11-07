package com.rmk.service;

import com.rmk.dao.CartDao;
import com.rmk.model.ShoppingCart;
import com.rmk.model.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by RashMin on 03-11-2016.
 */
@Service("cartservice")
public class CartServiceImpl implements CartService {

    @Autowired @Qualifier("cartdao")
    CartDao dao;
    public boolean addItemToCart(ShoppingCart cart, ShoppingItem item) {
        Set<ShoppingItem> items =
        Optional.ofNullable(cart.getItems())
                .map(allitems->{
                    if(allitems.contains(item)){
                        item.setQty(item.getQty()+1);
                        allitems.add(item);
                    }else{
                        allitems.add(item);
                    }
                    return allitems;
                })
                .orElse(null);

        cart.setItems(items);
        return false;
    }

    public boolean emptyCart(ShoppingCart cart) {
        cart.setItems(null);
        return true;
    }

    public boolean removeItemToCart(ShoppingCart cart, ShoppingItem item) {
        Set<ShoppingItem> items =
                Optional.ofNullable(cart.getItems())
                        .map(allitems->{
                            if(allitems.contains(item)) {
                                if (item.getQty() > 1) {
                                    item.setQty(item.getQty() - 1);
                                } else {
                                    allitems.remove(item);
                                }
                            }
                            return allitems;
                        })
                        .orElse(null);

        cart.setItems(items);
        return false;

    }

    public ShoppingCart createCart() {
        return new ShoppingCart();
    }

    public ShoppingItem createCartItem() {
        return new ShoppingItem();
    }

    @Override
    public ShoppingCart createCart(ShoppingCart cart) {
        return null;
    }

    @Override
    public ShoppingItem createCartItem(ShoppingItem item) {
        return null;
    }

    @Override
    public boolean removeItemFromCart(Integer cartId, ShoppingItem item) {
        ShoppingCart cart = dao.getCart(cartId);
        return this.removeItemToCart(cart,item);
    }
}
