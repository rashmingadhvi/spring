package com.rmk.service;

import com.rmk.dao.ProductDao;
import com.rmk.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by RashMin on 05-11-2016.
 */
@Service(value="productservice")
public class ProductServiceImpl implements ProductService {

    @Autowired @Qualifier("productdao")
    ProductDao dao;

    @Override
    public Product create(Product product) {
        return dao.save(product);
    }

    @Override
    public Product update(Product product) {
        return dao.update(product);
    }

    @Override
    public boolean delete(Product product) {
        dao.delete(product);
        return true;
    }

    @Override
    public boolean delete(String sku) {
        dao.delete(sku);
        return true;
    }
}
