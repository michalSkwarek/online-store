package com.skwarek.onlineStore.web.editors;

import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import com.skwarek.onlineStore.service.ProductSpecificationsService;

import java.beans.PropertyEditorSupport;

/**
 * Created by Michal on 03.10.2016.
 */
public class ProductSpecificationsEditor extends PropertyEditorSupport {

    private ProductSpecificationsService productSpecificationsService;

    public ProductSpecificationsEditor(ProductSpecificationsService productSpecificationsService) {
        this.productSpecificationsService = productSpecificationsService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        long id = Integer.parseInt(text);
        ProductSpecifications productSpecifications = productSpecificationsService.read(id);
        setValue(productSpecifications);
    }
}
