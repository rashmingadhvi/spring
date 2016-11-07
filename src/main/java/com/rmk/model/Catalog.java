package com.rmk.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by RashMin on 03-11-2016.
 */
@Entity
@Table(name="catalog")
public class Catalog implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column( name = "catalogid")
    int catalogId;

    String name;

    @OneToMany(cascade = {CascadeType.ALL},mappedBy = "catalog", fetch = FetchType.LAZY)
    Set<Product> products = new HashSet<>(0);

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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "catalogId=" + catalogId +
                ", name='" + name + '\'' +

                '}';
    }
}
