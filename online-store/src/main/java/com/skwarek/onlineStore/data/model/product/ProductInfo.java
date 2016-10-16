package com.skwarek.onlineStore.data.model.product;

import com.skwarek.onlineStore.data.entity.product.Category;
import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.data.entity.product.UploadFile;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Michal on 26.09.2016.
 */
public class ProductInfo {

    private Long id;
    private String model;
    private BigDecimal unitPrice;
    private Category category;
    private Manufacturer manufacturer;
    private CommonsMultipartFile productImage;
    private ProductSpecifications productSpecifications;
    private Long unitsInMagazine;

    public ProductInfo() { }

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

    public CommonsMultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(CommonsMultipartFile productImage) {
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
        if (!(o instanceof ProductInfo)) return false;

        ProductInfo product = (ProductInfo) o;

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