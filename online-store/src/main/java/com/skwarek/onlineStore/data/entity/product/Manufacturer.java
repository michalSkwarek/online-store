package com.skwarek.onlineStore.data.entity.product;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Michal on 27.09.2016.
 */
@Entity
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand")
    private String brand;

//    private UploadFile logo;

    @Column(name = "website")
    private String website;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    private Set<Product> products;

    public Manufacturer() { }

    public Manufacturer(String brand, String website) {
        this.brand = brand;
        this.website = website;
    }

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
}
