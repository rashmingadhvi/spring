package com.rmk.dao;

import com.rmk.model.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by RashMin on 05-11-2016.
 */
@Repository("productdao")
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    /**'
     * Get the session factory object to deal with persisting objects in
     * database - H2.
     * @return
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * To persist the Product object into database - H2
     * @param product
     * @return
     */
    @Override
    public Product save(Product product) {
        Object id= this.sessionFactory.getCurrentSession().save(product);
        return this.get((String)id);
    }

    /**
     * To update the Product object into database - H2
     * @param product
     * @return
     */
    @Override
    public Product update(Product product) {
        this.getSessionFactory().getCurrentSession().update(product);
        return this.get(product.getSku());
    }

    /**
     * To delete the Product object from database - H2
     * @param product
     * @return
     */
    @Override
    public boolean delete(Product product) {
        return false;
    }

    /**
     * This operation deletes the Product by its SKU
     * @param sku
     * @return
     */
    @Override
    public boolean delete(String sku) {
        this.sessionFactory.getCurrentSession().delete(this.get(sku));
        return true;
    }

    @Override
    public Product get(String sku) {
        return (Product)this.sessionFactory.getCurrentSession().get(Product.class,sku);
    }
}
