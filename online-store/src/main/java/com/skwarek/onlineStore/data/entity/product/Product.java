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

    public Boolean isAvailability() {
        return unitsInMagazine != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (model != null ? !model.equals(product.model) : product.model != null) return false;
        if (unitPrice != null ? !unitPrice.equals(product.unitPrice) : product.unitPrice != null) return false;
        if (category != null ? !category.equals(product.category) : product.category != null) return false;
        if (manufacturer != null ? !manufacturer.equals(product.manufacturer) : product.manufacturer != null)
            return false;
        if (productImage != null ? !productImage.equals(product.productImage) : product.productImage != null)
            return false;
        if (productSpecifications != null ? !productSpecifications.equals(product.productSpecifications) : product.productSpecifications != null)
            return false;
        return unitsInMagazine != null ? unitsInMagazine.equals(product.unitsInMagazine) : product.unitsInMagazine == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (productImage != null ? productImage.hashCode() : 0);
        result = 31 * result + (productSpecifications != null ? productSpecifications.hashCode() : 0);
        result = 31 * result + (unitsInMagazine != null ? unitsInMagazine.hashCode() : 0);
        return result;
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
