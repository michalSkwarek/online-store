package com.skwarek.onlineStore.data.entity.address;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * Created by Michal on 23.09.2016.
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1139804983797527132L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    public Address() { }

    public Address(String street, String streetNumber, String doorNumber, String zipCode, City city) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.doorNumber = doorNumber;
        this.zipCode = zipCode;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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
                '}';
    }
}