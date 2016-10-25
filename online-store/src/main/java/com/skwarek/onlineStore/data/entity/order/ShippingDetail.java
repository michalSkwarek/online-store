package com.skwarek.onlineStore.data.entity.order;

import com.skwarek.onlineStore.data.entity.address.Address;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Michal on 25.09.2016.
 */
@Entity
@Table(name = "shipping_detail")
public class ShippingDetail implements Serializable {

    private static final long serialVersionUID = 4011774664378913484L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_delivery")
    private Date dateDelivery;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id")
    private Address shippingAddress;

    public ShippingDetail() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
                ", shippingAddress=" + shippingAddress +
                '}';
    }
}
