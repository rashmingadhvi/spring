package com.rmk.service;

import com.rmk.dao.CartDao;
import com.rmk.model.Catalog;
import com.rmk.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by RashMin on 05-11-2016.
 */
@Service(value = "catalogservice")
public class CatalogServiceImpl implements CatalogService {

    @Autowired @Qualifier("cartdao")
    CartDao dao;
    @Override
    public List<Catalog> listCatalog() {
        return dao.listCataloge();
    }

    @Override
    public Set<Product> listCatalogProducts(Catalog catalog) {
        return catalog.getProducts();
    }

    @Override
    public boolean addProduct(Catalog catalog, Product product) {

        Set<Product> list= catalog.getProducts();
        if(null==list){
            list = new HashSet<>();
            return list.add(product);
        }else{
            return list.add(product);
        }



    }

    @Override
    public boolean addProducts(Catalog catalog, Set<Product> products) {
        Set<Product> list= catalog.getProducts();
        if(null==list){
            catalog.setProducts(products);
            return true;
        }else{
            return list.addAll(products);
        }
    }

    @Override
    public boolean removeProduct(Catalog catalog, Product product) {
        Set<Product> list= catalog.getProducts();
        return list.remove(product);
    }

    @Override
    public Catalog saveCatalog(Catalog catalog) {
        return dao.save(catalog);
    }

    @Override
    public Set<Product> listCatalogProducts(Integer catalogId) {
        Catalog catalog = dao.getCatalog(catalogId);
        return this.listCatalogProducts(catalog);
    }

    @Override
    public boolean addProduct(Integer catalogId, Product product) {
        return false;
    }

    @Override
    public boolean removeProduct(Integer catalogId, String sku) {
        return false;
    }

    @Override
    public Catalog updateCatalog(Catalog catalog) {
        return dao.update(catalog);
    }
}
