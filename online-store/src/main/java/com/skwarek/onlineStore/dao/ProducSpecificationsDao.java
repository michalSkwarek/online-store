package com.skwarek.onlineStore.dao;

import com.skwarek.onlineStore.dao.generic.GenericDao;
import com.skwarek.onlineStore.domain.product.specifications.ProductSpecifications;

import java.util.List;

/**
 * Created by Michal on 29.09.2016.
 */
public interface ProducSpecificationsDao extends GenericDao<ProductSpecifications, Long> {

    List getAllDisplays();
}
