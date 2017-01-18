package com.skwarek.onlineStore.data.entity.product;

import com.skwarek.onlineStore.data.entity.BaseEntity;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Michal on 27.09.2016.
 */
@Entity
@Table(name = "manufacturer")
public class Manufacturer extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -6011575340265344738L;

    @NotEmpty(message = "{Manufacturer.brand.validation.notEmpty}")
    @Column(name = "brand")
    private String brand;

    @OneToOne
    @JoinColumn(name = "logo_id")
    private UploadFile logo;

    @Column(name = "website")
    private String website;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "manufacturer")
    private Set<Product> products = new HashSet<>();

    public Manufacturer() { }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public UploadFile getLogo() {
        return logo;
    }

    public void setLogo(UploadFile logo) {
        this.logo = logo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manufacturer)) return false;

        Manufacturer that = (Manufacturer) o;

        return brand != null ? brand.equals(that.brand) : that.brand == null;

    }

    @Override
    public int hashCode() {
        return brand != null ? brand.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "brand=" + brand +
                ", website=" + website +
                '}';
    }
}
