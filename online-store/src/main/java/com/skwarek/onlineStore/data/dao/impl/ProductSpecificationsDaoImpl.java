package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.ProducSpecificationsDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Michal on 29.09.2016.
 */
@Repository("productSpecificationsDao")
public class ProductSpecificationsDaoImpl extends GenericDaoImpl<ProductSpecifications, Long> implements ProducSpecificationsDao {

    @Override
    public List getAllDisplays() {
        return null;
    }
}
