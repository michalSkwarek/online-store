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
        productSpecifications.setDisplay(productSpecifications.getDisplay());
    }

    @Override
    public void buildBattery() {
        productSpecifications.setBattery(productSpecifications.getBattery());
    }

    @Override
    public void buildPowerSupply() { }

    @Override
    public void buildOS() {
        productSpecifications.setOs(productSpecifications.getOs());
    }

    @Override
    public void buildWeight() {
        productSpecifications.setWeight(productSpecifications.getWeight());
    }

    @Override
    public ProductSpecifications getProductSpecifications() {
        return productSpecifications;
    }
}
