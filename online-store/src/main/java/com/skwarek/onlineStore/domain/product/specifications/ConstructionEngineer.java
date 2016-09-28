package com.skwarek.onlineStore.domain.product.specifications;

/**
 * Created by Michal on 27.09.2016.
 */
public class ConstructionEngineer {

    private ProductSpecificationsBuilder builder;

    public ConstructionEngineer(ProductSpecificationsBuilder builder) {
        this.builder = builder;
    }

    public ProductSpecifications build() {
        builder.buildDisplay();
        builder.buildBattery();
        builder.buildPowerSupply();
        builder.buildOS();
        builder.buildWeight();
        return builder.getProductSpecifications();
    }
}
