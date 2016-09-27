package com.skwarek.onlineStore.domain.product.specifications;

/**
 * Created by Michal on 27.09.2016.
 */
public class Director {

    private ProductSpecificationsBuilder builder;

    public void setBuilder(ProductSpecificationsBuilder builder) {
        this.builder = builder;
    }

    public ProductSpecifications getProductSpecifications() {
        return builder.getProductSpecifications();
    }

    public void build() {
        builder.newProductSpecifications();
        builder.buildDisplay();
        builder.buildBattery();
        builder.buildPowerSupply();
        builder.buildOS();
        builder.buildWeight();
    }
}
