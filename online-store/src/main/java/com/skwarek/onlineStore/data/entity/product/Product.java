package com.skwarek.onlineStore.data.entity.product;

import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_image_id")
    private UploadFile productImage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specifications_id")
    private ProductSpecifications productSpecifications;

    @Column(name = "units_in_magazine")
    private Long unitsInMagazine;

    public Product() { }

    public Product(String model, BigDecimal unitPrice, Category category, Manufacturer manufacturer) {
        this.model = model;
        this.unitPrice = unitPrice;
        this.category = category;
        this.manufacturer = manufacturer;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ProductSpecifications getProductSpecifications() {
        return productSpecifications;
    }

    public void setProductSpecifications(ProductSpecifications productSpecifications) {
        this.productSpecifications = productSpecifications;
    }

    public UploadFile getProductImage() {
        return productImage;
    }

    public void setProductImage(UploadFile productImage) {
        this.productImage = productImage;
    }

    public Long getUnitsInMagazine() {
        return unitsInMagazine;
    }

    public void setUnitsInMagazine(Long unitsInMagazine) {
        this.unitsInMagazine = unitsInMagazine;
    }

    public Boolean isAvailability() {
        return unitsInMagazine != 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "model='" + model + '\'' +
                ", unitPrice=" + unitPrice +
                ", category=" + category +
                ", manufacturer=" + manufacturer +
                ", productSpecifications=" + productSpecifications +
                '}';
    }
}