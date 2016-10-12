package com.skwarek.onlineStore.data.entity.order;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Michal on 25.09.2016.
 */
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Item> items;

    @Column(name = "cart_total_price")
    private BigDecimal cartTotalPrice;

    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
    private Order order;

    public Cart() {
        this.items = new LinkedList<>();
        this.cartTotalPrice = new BigDecimal(0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public BigDecimal getCartTotalPrice() {
        return cartTotalPrice;
    }

    public void setCartTotalPrice(BigDecimal cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void addItem(Item item) {
        if (items.contains(item)) {
            Item existingItem = items.get(items.indexOf(item));
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
            items.add(existingItem);
        } else {
            items.add(item);
        }
        updateCartTotalPrice();
    }

    public void removeItem(Item item) {
        items.remove(item);
        updateCartTotalPrice();
    }

    public void updateCartTotalPrice() {
        cartTotalPrice = new BigDecimal(0);
        for (Item item : items) {
            cartTotalPrice = cartTotalPrice.add(item.getItemTotalPrice());
        }
    }
}
