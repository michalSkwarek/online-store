package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.data.dao.generic.GenericDao;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;

/**
 * Created by Michal on 29.09.2016.
 */
public interface ProductSpecificationsDao extends GenericDao<ProductSpecifications, Long> {

    void createSpecifications(ProductSpecifications productSpecifications, Product product);

    void updateSpecifications(ProductSpecifications productSpecifications);
}
