package com.skwarek.onlineStore.domain.product.specifications;

import com.skwarek.onlineStore.domain.product.specifications.modules.Weight;

/**
 * Created by Michal on 27.09.2016.
 */
public class ConsoleSpecifications implements ProductSpecificationsBuilder {

    private ProductSpecifications productSpecifications;

    public ConsoleSpecifications() {
        this.productSpecifications = new ProductSpecifications();
    }

    @Override
    public void buildDisplay() { }

    @Override
    public void buildBattery() { }

    @Override
    public void buildPowerSupply() { }

    @Override
    public void buildOS() { }

    @Override
    public void buildWeight() {
        productSpecifications.setWeight(new Weight());
    }

    @Override
    public ProductSpecifications getProductSpecifications() {
        return productSpecifications;
    }
}
