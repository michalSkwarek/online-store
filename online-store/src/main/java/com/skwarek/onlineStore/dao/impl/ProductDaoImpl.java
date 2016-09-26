package com.skwarek.onlineStore.dao.impl;

import com.skwarek.onlineStore.dao.ProductDao;
import com.skwarek.onlineStore.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.domain.product.Product;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal on 26.09.2016.
 */
@Repository("productDao")
public class ProductDaoImpl extends GenericDaoImpl<Product, Long> implements ProductDao {

}
