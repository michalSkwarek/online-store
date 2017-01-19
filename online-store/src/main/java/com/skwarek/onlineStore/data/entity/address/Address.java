package com.skwarek.onlineStore.data.entity.address;

import com.skwarek.onlineStore.data.entity.BaseEntity;
import com.skwarek.onlineStore.data.entity.order.ShippingDetail;
import com.skwarek.onlineStore.data.entity.user.Customer;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Michal on 23.09.2016.
 */
@Entity
@Table(name = "address")
public class Address extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -6803451763518510225L;

    @NotEmpty(message = "{Address.street.validation.notEmpty}")
    @Column(name = "street")
    private String street;

    @NotEmpty(message = "{Address.streetNumber.validation.notEmpty}")
    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "door_number")
    private String doorNumber;

    @NotEmpty(message = "{Address.zipCode.validation.notEmpty}")
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}", message = "{Address.zipCode.validation.pattern}")
    @Column(name = "zip_code")
    private String zipCode;

    @NotEmpty(message = "{Address.city.validation.notEmpty}")
    @Column(name = "city")
    private String city;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "billingAddress")
    private Customer customer;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "shippingAddress")
    private List<ShippingDetail> shippingDetails;

    public Address() { }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = (doorNumber.equals("") ? null : doorNumber);
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ShippingDetail> getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(List<ShippingDetail> shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (streetNumber != null ? !streetNumber.equals(address.streetNumber) : address.streetNumber != null)
            return false;
        if (doorNumber != null ? !doorNumber.equals(address.doorNumber) : address.doorNumber != null) return false;
        if (zipCode != null ? !zipCode.equals(address.zipCode) : address.zipCode != null) return false;
        return city != null ? city.equals(address.city) : address.city == null;

    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (streetNumber != null ? streetNumber.hashCode() : 0);
        result = 31 * result + (doorNumber != null ? doorNumber.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street=" + street +
                ", streetNumber=" + streetNumber +
                ", doorNumber=" + doorNumber +
                ", zipCode=" + zipCode +
                ", city=" + city +
                "}";
    }
}