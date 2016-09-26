package com.skwarek.onlineStore.dao;

import com.skwarek.onlineStore.dao.generic.GenericDao;
import com.skwarek.onlineStore.domain.product.Product;

/**
 * Created by Michal on 26.09.2016.
 */
public interface ProductDao extends GenericDao<Product, Long> {

    boolean removeProduct(Long id);
}
