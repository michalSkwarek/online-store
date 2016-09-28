package com.skwarek.onlineStore.domain.product.specifications;

/**
 * Created by Michal on 27.09.2016.
 */
public interface ProductSpecificationsBuilder {

    void buildDisplay();

    void buildBattery();

    void buildPowerSupply();

    void buildOS();

    void buildWeight();

    ProductSpecifications getProductSpecifications();
}
