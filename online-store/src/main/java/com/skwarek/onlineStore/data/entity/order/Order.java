package com.skwarek.onlineStore.data.entity.order;

import com.skwarek.onlineStore.data.entity.BaseEntity;
import com.skwarek.onlineStore.data.entity.user.Customer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Michal on 25.09.2016.
 */
@Entity
@Table(name = "orders")
public class Order extends BaseEntity implements Serializable {

    @Embedded
    private Cart cart;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_detail_id")
    private ShippingDetail shippingDetail;

    @Column(name = "date_created")
    private Date dateCreated;

    public Order() { }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShippingDetail getShippingDetail() {
        return shippingDetail;
    }

    public void setShippingDetail(ShippingDetail shippingDetail) {
        this.shippingDetail = shippingDetail;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (cart != null ? !cart.equals(order.cart) : order.cart != null) return false;
        if (customer != null ? !customer.equals(order.customer) : order.customer != null) return false;
        if (shippingDetail != null ? !shippingDetail.equals(order.shippingDetail) : order.shippingDetail != null)
            return false;
        return dateCreated != null ? dateCreated.equals(order.dateCreated) : order.dateCreated == null;

    }

    @Override
    public int hashCode() {
        int result = cart != null ? cart.hashCode() : 0;
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (shippingDetail != null ? shippingDetail.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "cart=" + cart +
                ", customer=" + customer +
                ", shippingDetail=" + shippingDetail +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
