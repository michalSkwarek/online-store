package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.data.dao.ProductSpecificationsDao;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import com.skwarek.onlineStore.service.ProductSpecificationsService;
import com.skwarek.onlineStore.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michal on 29.09.2016.
 */
@Service("productSpecificationsService")
public class ProductSpecificationsServiceImpl extends GenericServiceImpl<ProductSpecifications, Long> implements ProductSpecificationsService {

    @Autowired
    private ProductSpecificationsDao productSpecificationsDao;

    @Override
    public void createSpecifications(ProductSpecifications productSpecifications) {
        productSpecificationsDao.createSpecifications(productSpecifications);
    }

    @Override
    public void updateSpecifications(ProductSpecifications productSpecifications) {
        productSpecificationsDao.updateSpecifications(productSpecifications);
    }
}
