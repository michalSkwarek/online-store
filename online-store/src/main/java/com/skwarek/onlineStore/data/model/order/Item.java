package com.skwarek.onlineStore.data.model.order;

import com.skwarek.onlineStore.data.entity.product.Product;

import java.math.BigDecimal;

/**
 * Created by Michal on 25.09.2016.
*/
public class Item {

    private Product product;

    private Integer quantity;

    private BigDecimal itemTotalPrice;

    public Item() {
        this.itemTotalPrice = new BigDecimal(0);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        return product != null ? product.equals(item.product) : item.product == null;
    }

    @Override
    public int hashCode() {
        return product != null ? product.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Item{" +
                "product=" + product.getModel() +
                ", quantity=" + quantity +
                ", itemTotalPrice=" + itemTotalPrice +
                '}';
    }
}
