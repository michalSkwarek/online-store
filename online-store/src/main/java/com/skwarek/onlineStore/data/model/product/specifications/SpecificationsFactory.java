package com.skwarek.onlineStore.data.model.product.specifications;

import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;

/**
 * Created by Michal on 29.09.2016.
 */
public class SpecificationsFactory {

    public ProductSpecifications createSpecifications(String productCategory) {
        if (productCategory.equalsIgnoreCase("Smartphone")) {
            return new SmartphoneSpecifications();
        } else if (productCategory.equalsIgnoreCase("Tablet")) {
            return new TabletSpecifications();
        } else if (productCategory.equalsIgnoreCase("Notebook")) {
            return new NotebookSpecifications();
        } else if (productCategory.equalsIgnoreCase("PC")) {
            return new PCSpecifications();
        } else if (productCategory.equalsIgnoreCase("Console")) {
            return new ConsoleSpecifications();
        } else if (productCategory.equalsIgnoreCase("Smartwatch")) {
            return new SmartwatchSpecifications();
        }
        return null;
    }
}
