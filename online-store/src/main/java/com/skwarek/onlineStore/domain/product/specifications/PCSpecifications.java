package com.skwarek.onlineStore.domain.product.specifications;

import com.skwarek.onlineStore.domain.product.specifications.modules.*;

/**
 * Created by Michal on 27.09.2016.
 */
public class PCSpecifications implements ProductSpecificationsBuilder {

    private ProductSpecifications productSpecifications;

    public PCSpecifications() {
        this.productSpecifications = new ProductSpecifications();
    }

    @Override
    public void buildDisplay() { }

    @Override
    public void buildBattery() { }

    @Override
    public void buildPowerSupply() {
        productSpecifications.setPowerSupply(new PowerSupply());
    }

    @Override
    public void buildOS() {
        productSpecifications.setOs(new OS());
    }

    @Override
    public void buildWeight() {
        productSpecifications.setWeight(new Weight());
    }

    @Override
    public ProductSpecifications getProductSpecifications() {
        return productSpecifications;
    }
}
