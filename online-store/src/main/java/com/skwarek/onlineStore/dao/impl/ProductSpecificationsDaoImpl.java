package com.skwarek.onlineStore.dao.impl;

import com.skwarek.onlineStore.dao.ProducSpecificationsDao;
import com.skwarek.onlineStore.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.domain.product.specifications.ProductSpecifications;
import org.hibernate.Query;
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
