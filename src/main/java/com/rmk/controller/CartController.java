package com.rmk.controller;

import com.rmk.model.ShoppingCart;
import com.rmk.model.ShoppingItem;
import com.rmk.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

/**
 * Created by RashMin on 29-10-2016.
 */
@RestController(value = "cartcontroller")
public class CartController {

    @Autowired @Qualifier("cartservice")
    CartService service;

    @RequestMapping(name = "/additem"
            ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,method = RequestMethod.POST)
    public ShoppingItem addItemtoCart(Integer cartId,ShoppingItem item){
        return item;
    }

    @RequestMapping(name = "/removeitem"
            ,consumes = MediaType.APPLICATION_JSON_VALUE
            ,method = RequestMethod.DELETE)
    public boolean removeItemFromCart(Integer cartId, ShoppingItem item){
        return service.removeItemFromCart(cartId,item);
    }

}
