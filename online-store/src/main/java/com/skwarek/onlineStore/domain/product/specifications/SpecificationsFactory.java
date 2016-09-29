package com.skwarek.onlineStore.domain.product.specifications;

/**
 * Created by Michal on 29.09.2016.
 */
public class SpecificationsFactory {

    public ProductSpecifications createSpecifications(String productCategory) {
        if (productCategory.equalsIgnoreCase("smartphone")) {
            return new SmartphoneSpecifications();
        } else if (productCategory.equalsIgnoreCase("pc")) {
            return new PCSpecifications();
        } else if (productCategory.equalsIgnoreCase("console")) {
            return new ConsoleSpecifications();
        }
        return null;
    }
}
