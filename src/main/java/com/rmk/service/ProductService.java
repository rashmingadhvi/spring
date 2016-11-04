package com.rmk.service;

import com.rmk.model.Product;

/**
 * Created by RashMin on 03-11-2016.
 */
public interface ProductService {

    Product create();
    Product update(Product product);
    boolean delete (Product product);
    boolean delete( String sku);
}
