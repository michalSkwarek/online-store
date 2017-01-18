package com.skwarek.onlineStore.data.entity.order;

import com.skwarek.onlineStore.data.entity.BaseEntity;
import com.skwarek.onlineStore.data.entity.address.Address;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Michal on 25.09.2016.
 */
@Entity
@Table(name = "shipping_detail")
public class ShippingDetail extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 7221938644825388800L;

    @Column(name = "date_delivery")
    private Date dateDelivery;

    @OneToOne
    @JoinColumn(name = "shipping_address_id")
    private Address shippingAddress;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "shippingDetail")
    private Order order;

    public ShippingDetail() { }

    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShippingDetail)) return false;

        ShippingDetail that = (ShippingDetail) o;

        if (dateDelivery != null ? !dateDelivery.equals(that.dateDelivery) : that.dateDelivery != null) return false;
        return shippingAddress != null ? shippingAddress.equals(that.shippingAddress) : that.shippingAddress == null;

    }

    @Override
    public int hashCode() {
        int result = dateDelivery != null ? dateDelivery.hashCode() : 0;
        result = 31 * result + (shippingAddress != null ? shippingAddress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShippingDetail{" +
                ", dateDelivery=" + dateDelivery +
                "}";
    }
}
