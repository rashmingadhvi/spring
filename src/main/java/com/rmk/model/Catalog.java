package com.rmk.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by RashMin on 03-11-2016.
 */
@Entity
@Table(name="catalog")
public class Catalog implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    int catalogId;
    String name;
    List<Product> products;

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
