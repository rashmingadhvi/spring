package com.rmk.dao;

import com.rmk.model.Catalog;
import com.rmk.model.ShoppingCart;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by RashMin on 05-11-2016.
 */
@Repository("cartdao")
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    /**
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
     *
     * @return link{List<Catalog>}
     */
    @Override
    public List<Catalog> listCataloge() {
        return this.sessionFactory.getCurrentSession().createCriteria(Catalog.class).list();
    }

    @Override
    public Catalog save(Catalog catalog) {
        Object id=this.sessionFactory.getCurrentSession().save(catalog);
        return id!=null?this.getCatalog((Integer)id):null;
    }

    @Override
    public ShoppingCart getCart(Integer id) {
        if(null==id)
            return null;
        ShoppingCart cart = (ShoppingCart) this.sessionFactory.getCurrentSession().get(ShoppingCart.class,id);

        return cart;
    }

    @Override
    public Catalog getCatalog(Integer id) {
        return (Catalog)this.sessionFactory.getCurrentSession().get(Catalog.class,id);
    }

    @Override
    public Catalog update(Catalog catalog) {
        this.sessionFactory.getCurrentSession().update(catalog);
        return this.getCatalog(catalog.getCatalogId());
    }
}
