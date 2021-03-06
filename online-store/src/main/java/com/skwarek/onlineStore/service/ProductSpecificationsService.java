package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import com.skwarek.onlineStore.service.generic.GenericService;

/**
 * Created by Michal on 29.09.2016.
 */
public interface ProductSpecificationsService extends GenericService<ProductSpecifications, Long> {

    void createSpecifications(ProductSpecifications productSpecifications, Product product);

    void updateSpecifications(ProductSpecifications productSpecifications);
}
