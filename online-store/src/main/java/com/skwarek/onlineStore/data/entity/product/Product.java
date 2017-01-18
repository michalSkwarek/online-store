package com.skwarek.onlineStore.data.entity.product;

import com.skwarek.onlineStore.data.entity.BaseEntity;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Michal on 26.09.2016.
 */
@Entity
@Table(name = "product")
public class Product extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -4682002815091850304L;

    @NotEmpty(message = "{Product.model.validation.notEmpty}")
    @Column(name = "model")
    private String model;

    @Min(value = 0, message = "{Product.unitPrice.validation.min}")
    @Digits(integer = 8, fraction = 2, message = "{Product.unitPrice.validation.digits}")
    @NotNull(message = "{Product.unitPrice.validation.notNull}")
    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToOne
    @JoinColumn(name = "product_image_id")
    private UploadFile productImage;

    @OneToOne
    @JoinColumn(name = "specifications_id")
    private ProductSpecifications productSpecifications;

    @Min(value = 0, message = "{Product.unitsInMagazine.validation.min}")
    @NotNull(message = "{Product.unitsInMagazine.validation.notNull}")
    @Column(name = "units_in_magazine")
    private Long unitsInMagazine;

    public Product() { }

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

    public UploadFile getProductImage() {
        return productImage;
    }

    public void setProductImage(UploadFile productImage) {
        this.productImage = productImage;
    }

    public ProductSpecifications getProductSpecifications() {
        return productSpecifications;
    }

    public void setProductSpecifications(ProductSpecifications productSpecifications) {
        this.productSpecifications = productSpecifications;
    }

    public Long getUnitsInMagazine() {
        return unitsInMagazine;
    }

    public void setUnitsInMagazine(Long unitsInMagazine) {
        this.unitsInMagazine = unitsInMagazine;
    }

    public boolean isAvailability() {
        return unitsInMagazine != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return model != null ? model.equals(product.model) : product.model == null;

    }

    @Override
    public int hashCode() {
        return model != null ? model.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "model=" + model +
                ", unitPrice=" + unitPrice +
                ", category=" + category +
                ", manufacturer=" + manufacturer +
                ", productImage=" + productImage +
                ", productSpecifications=" + productSpecifications +
                ", unitsInMagazine=" + unitsInMagazine +
                '}';
    }
}
