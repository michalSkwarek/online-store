package com.skwarek.onlineStore.data.entity.order;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Michal on 25.09.2016.
 */
@Embeddable
public class Cart implements Serializable {

    private static final long serialVersionUID = 401268856627610843L;

    @Column(name = "cart_total_price")
    private BigDecimal cartTotalPrice;

    public Cart() { }

    public BigDecimal getCartTotalPrice() {
        return cartTotalPrice;
    }

    public void setCartTotalPrice(BigDecimal cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;

        Cart cart = (Cart) o;

        return cartTotalPrice != null ? cartTotalPrice.equals(cart.cartTotalPrice) : cart.cartTotalPrice == null;

    }

    @Override
    public int hashCode() {
        return cartTotalPrice != null ? cartTotalPrice.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Cart{" +
                ", cartTotalPrice=" + cartTotalPrice +
                "}";
    }
}
