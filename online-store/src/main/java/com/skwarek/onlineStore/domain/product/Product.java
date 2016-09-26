package com.skwarek.onlineStore.domain.product;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Michal on 26.09.2016.
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

//    private Category category;
//
//    private Manufacturer manufacturer;

//    private Picture image;

//    private ProductSpecifications productSpecifications;

//    private Long unitInMagazine;
//
//    private Boolean availability;


    public Product() { }

    public Product(String model, BigDecimal unitPrice) {
        this.model = model;
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
