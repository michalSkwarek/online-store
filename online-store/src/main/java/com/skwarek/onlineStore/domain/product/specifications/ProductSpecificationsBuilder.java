package com.skwarek.onlineStore.domain.product.specifications;

/**
 * Created by Michal on 27.09.2016.
 */
public abstract class ProductSpecificationsBuilder {

    protected ProductSpecifications productSpecifications;

    public void newProductSpecifications() {
        productSpecifications = new ProductSpecifications();
    }

    public ProductSpecifications getProductSpecifications() {
        return productSpecifications;
    }

    public void setProductSpecifications(ProductSpecifications productSpecifications) {
        this.productSpecifications = productSpecifications;
    }

    public abstract void buildDisplay();

    public abstract void buildBattery();

    public abstract void buildPowerSupply();

    public abstract void buildOS();

    public abstract void buildWeight();
}
