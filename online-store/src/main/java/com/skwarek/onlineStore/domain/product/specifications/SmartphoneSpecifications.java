package com.skwarek.onlineStore.domain.product.specifications;

import com.skwarek.onlineStore.domain.product.specifications.modules.Battery;
import com.skwarek.onlineStore.domain.product.specifications.modules.Display;
import com.skwarek.onlineStore.domain.product.specifications.modules.OS;
import com.skwarek.onlineStore.domain.product.specifications.modules.Weight;

/**
 * Created by Michal on 27.09.2016.
 */
public class SmartphoneSpecifications implements ProductSpecificationsBuilder {

    private ProductSpecifications productSpecifications;

    public SmartphoneSpecifications() {
        this.productSpecifications = new ProductSpecifications();
    }

    @Override
    public void buildDisplay() {
        productSpecifications.setDisplay(new Display());
    }

    @Override
    public void buildBattery() {
        productSpecifications.setBattery(new Battery());
    }

    @Override
    public void buildPowerSupply() { }

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
