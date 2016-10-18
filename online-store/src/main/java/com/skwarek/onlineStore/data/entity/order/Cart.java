package com.skwarek.onlineStore.data.entity.order;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Michal on 25.09.2016.
 */
@Embeddable
public class Cart implements Serializable {

    private static final long serialVersionUID = 2707354296322318547L;

    @Transient
    private List<Item> items;

    @Column(name = "cart_total_price")
    private BigDecimal cartTotalPrice;

    @Transient
    private Order order;

    public Cart() {
        items = new LinkedList<>();
        cartTotalPrice = new BigDecimal(0);
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

    public void addItemToCart(Item item) {
        if (items.contains(item)) {
            int index = items.indexOf(item);
            Item existingItem = items.get(index);
            items.remove(item);
            existingItem.setQuantity(existingItem.getQuantity() + 1);
            items.add(item);
        } else {
            items.add(item);
        }
        updateGrandTotal();
    }

    public void removeItemFromCart(Item item) {
        items.remove(item);
        updateGrandTotal();
    }

    public void updateGrandTotal() {
        cartTotalPrice = new BigDecimal(0);
        for (Item item : items) {
            cartTotalPrice = cartTotalPrice.add(item.getItemTotalPrice());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;

        Cart cart = (Cart) o;

        if (items != null ? !items.equals(cart.items) : cart.items != null) return false;
        return cartTotalPrice != null ? cartTotalPrice.equals(cart.cartTotalPrice) : cart.cartTotalPrice == null;

    }

    @Override
    public int hashCode() {
        int result = items != null ? items.hashCode() : 0;
        result = 31 * result + (cartTotalPrice != null ? cartTotalPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cart{" +
                ", items=" + items +
                ", cartTotalPrice=" + cartTotalPrice +
                '}';
    }
}
