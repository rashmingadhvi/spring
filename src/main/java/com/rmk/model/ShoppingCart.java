package com.rmk.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by RashMin on 03-11-2016.
 */
@Entity
@Table(name="shoppingcart")
public class ShoppingCart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name="cartid")
    String cartId;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "cart")
    Set<ShoppingItem> items;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Set<ShoppingItem> getItems() {
        return items;
    }

    public void setItems(Set<ShoppingItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartId='" + cartId + '\'' +
                ", items=" + items +
                '}';
    }
}
