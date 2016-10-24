package com.skwarek.onlineStore.data.entity.product;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Michal on 27.09.2016.
 */
@Entity
@Table(name = "manufacturer")
public class Manufacturer implements Serializable {

    private static final long serialVersionUID = 5047475650285780050L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "logo_id")
    private UploadFile logo;

    @Column(name = "website")
    private String website;

    @Transient
    private Set<Product> products;

    public Manufacturer() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (logo != null ? !logo.equals(that.logo) : that.logo != null) return false;
        return website != null ? website.equals(that.website) : that.website == null;

    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "brand=" + brand +
                ", website=" + website +
                '}';
    }
}
