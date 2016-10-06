package com.skwarek.onlineStore.data.entity.order;

import com.skwarek.onlineStore.data.entity.address.Address;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Michal on 25.09.2016.
 */
@Entity
@Table(name = "shipping_detail")
public class ShippingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String name;

    @Column(name = "shipping_date")
    private Date shippingDate;

    @JoinColumn(name = "shipping_address")
    private Address shippingAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
