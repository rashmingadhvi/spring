package com.rmk.dao;

import com.rmk.model.Catalog;
import com.rmk.model.ShoppingCart;

import java.util.List;

/**
 * Created by RashMin on 05-11-2016.
 */
public interface CartDao {

    List<Catalog> listCataloge();
    Catalog save(Catalog catalog);
    Catalog update(Catalog catalog);
    ShoppingCart getCart(Integer id);
    Catalog getCatalog(Integer id);
}
