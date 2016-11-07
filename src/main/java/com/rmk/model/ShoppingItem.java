package com.rmk.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by RashMin on 03-11-2016.
 */
@Entity
@Table(name="shoppingitem")
public class ShoppingItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name="itemid")
    int itemId;

    int qty;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="sku")
    Product item;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cartid",nullable = false)
    ShoppingCart cart;

    @Column(name="sortorder")
    int sortOrder;
    int sequence;
    int rating;

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingItem that = (ShoppingItem) o;

        return item != null ? item.equals(that.item) : that.item == null;
    }

    @Override
    public int hashCode() {
        return item != null ? item.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ShoppingItem{" +
                "itemId=" + itemId +
                ", qty=" + qty +
                ", item=" + item +
                ", cart=" + cart +
                ", sortOrder=" + sortOrder +
                ", sequence=" + sequence +
                ", rating=" + rating +
                '}';
    }
}
