package com.rmk.service;

import com.rmk.model.Catalog;
import com.rmk.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by RashMin on 03-11-2016.
 */
public interface CatalogService {

    List<Catalog> listCatalog();
    List<Product> listCatalogProducts(Catalog catalog);
    boolean addProduct(Catalog catalog,Product product);
    boolean addProducts(Catalog catalog, List<Product> products);
    boolean removeProduct(Catalog catalog,Product product);
}
