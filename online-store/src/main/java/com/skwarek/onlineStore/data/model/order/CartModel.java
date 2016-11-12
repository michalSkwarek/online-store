package com.skwarek.onlineStore.data.model.order;

import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.product.Product;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Michal on 25.09.2016.
 */
public class CartModel {

    private List<Item> items;

    private BigDecimal cartTotalPrice;

    private Address cartAddress;

    public CartModel() {
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

    public Address getCartAddress() {
        return cartAddress;
    }

    public void setCartAddress(Address cartAddress) {
        this.cartAddress = cartAddress;
    }

    public void addItemToCart(Item item) {
        if (items.contains(item)) {
            for (Item itemInCart : items) {
                if (itemInCart.equals(item)) {
                    itemInCart.setQuantity(itemInCart.getQuantity() + 1);
                }
            }
        } else {
            items.add(item);
        }
        updateGrandTotal();
    }

    public void removeItemFromCart(Product product) {
        for (Item itemInCart : items) {
            if (itemInCart.getProduct().equals(product)) {
                items.remove(itemInCart);
            }
        }
        updateGrandTotal();
    }

    private void updateGrandTotal() {
        cartTotalPrice = new BigDecimal(0);
        for (Item item : items) {
            cartTotalPrice = cartTotalPrice.add(item.getItemTotalPrice());
        }
    }

    public void updateQuantity(String[] quantities) {
        int i = 0;
        for (Item itemInCart : items) {
            itemInCart.setQuantity(Integer.parseInt(quantities[i++]));
            if (itemInCart.getQuantity() == 0) {
                items.remove(itemInCart);
            }
        }
        updateGrandTotal();
    }

    public boolean isAddProductToCart(Product product) {
        for (Item itemInCart : items) {
            if (itemInCart.getProduct().equals(product)) {
                if (itemInCart.getQuantity() >= product.getUnitsInMagazine()) {
                    return false;
                }
            }
        }
        return product.isAvailability();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartModel)) return false;

        CartModel cartModel = (CartModel) o;

        if (items != null ? !items.equals(cartModel.items) : cartModel.items != null) return false;
        return cartTotalPrice != null ? cartTotalPrice.equals(cartModel.cartTotalPrice) : cartModel.cartTotalPrice == null;

    }

    @Override
    public int hashCode() {
        int result = items != null ? items.hashCode() : 0;
        result = 31 * result + (cartTotalPrice != null ? cartTotalPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CartModel{" +
                ", items=" + items +
                ", cartTotalPrice=" + cartTotalPrice +
                '}';
    }
}
