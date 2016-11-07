package com.rmk.service;

import com.rmk.model.Catalog;
import com.rmk.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by RashMin on 03-11-2016.
 */
public interface CatalogService {

    List<Catalog> listCatalog();
    Set<Product> listCatalogProducts(Catalog catalog);
    Set<Product> listCatalogProducts(Integer catalogId);
    boolean addProduct(Catalog catalog,Product product);
    boolean addProduct(Integer catalogId,Product product);
    boolean addProducts(Catalog catalog, Set<Product> products);
    boolean removeProduct(Catalog catalog,Product product);
    boolean removeProduct(Integer catalogId,String sku);

    Catalog saveCatalog(Catalog catalog);
    Catalog updateCatalog(Catalog catalog);
}
