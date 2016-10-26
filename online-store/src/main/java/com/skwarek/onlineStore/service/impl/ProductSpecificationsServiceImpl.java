package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.data.dao.ProductSpecificationsDao;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import com.skwarek.onlineStore.service.ProductSpecificationsService;
import com.skwarek.onlineStore.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Michal on 29.09.2016.
 */
@Service("productSpecificationsService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductSpecificationsServiceImpl extends GenericServiceImpl<ProductSpecifications, Long> implements ProductSpecificationsService {

    @Autowired
    private ProductSpecificationsDao productSpecificationsDao;

    @Override
    public void createSpecifications(ProductSpecifications productSpecifications, Product product) {
        productSpecificationsDao.createSpecifications(productSpecifications, product);
    }

    @Override
    public void updateSpecifications(ProductSpecifications productSpecifications) {
        productSpecificationsDao.updateSpecifications(productSpecifications);
    }
}
