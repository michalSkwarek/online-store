package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.data.dao.generic.GenericDao;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;

import java.util.List;

/**
 * Created by Michal on 29.09.2016.
 */
public interface ProducSpecificationsDao extends GenericDao<ProductSpecifications, Long> {

    List getAllDisplays();
}
