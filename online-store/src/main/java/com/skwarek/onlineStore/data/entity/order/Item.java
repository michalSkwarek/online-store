package com.skwarek.onlineStore.data.entity.order;

import com.skwarek.onlineStore.data.entity.product.Product;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Michal on 25.09.2016.
 */
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "item_total_price")
    private BigDecimal itemTotalPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Item() { }

    public Item(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
        this.itemTotalPrice = product.getUnitPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.updateItemTotalPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.updateItemTotalPrice();
    }

    public BigDecimal getItemTotalPrice() {
        return itemTotalPrice;
    }

    public void setItemTotalPrice(BigDecimal itemTotalPrice) {
        this.itemTotalPrice = itemTotalPrice;
    }

    public void updateItemTotalPrice() {
        this.itemTotalPrice = this.product.getUnitPrice().multiply(new BigDecimal(this.quantity));
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
