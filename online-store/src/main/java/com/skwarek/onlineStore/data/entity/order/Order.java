package com.skwarek.onlineStore.data.entity.order;

import com.skwarek.onlineStore.data.entity.user.Customer;

import javax.persistence.*;

/**
 * Created by Michal on 25.09.2016.
 */
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "cart_id")
    private Cart cart;

    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JoinColumn(name = "shipping_detail_id")
    private ShippingDetail shippingDetail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
