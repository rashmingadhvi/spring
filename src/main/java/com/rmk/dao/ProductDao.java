package com.rmk.dao;

import com.rmk.model.Product;

/**
 * Created by RashMin on 05-11-2016.
 */
public interface ProductDao {

    Product save(Product product);
    Product update(Product product);
    boolean delete(Product product);
    boolean delete(String sku);
    Product get(String sku);
}
