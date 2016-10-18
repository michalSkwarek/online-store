package com.skwarek.onlineStore.data.entity.order;

import com.skwarek.onlineStore.data.entity.product.Product;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Michal on 25.09.2016.
*/
public class Item implements Serializable {

    private static final long serialVersionUID = -3635351022469956195L;

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

        if (product != null ? !product.equals(item.product) : item.product != null) return false;
        if (quantity != null ? !quantity.equals(item.quantity) : item.quantity != null) return false;
        return itemTotalPrice != null ? itemTotalPrice.equals(item.itemTotalPrice) : item.itemTotalPrice == null;

    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (itemTotalPrice != null ? itemTotalPrice.hashCode() : 0);
        return result;
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
