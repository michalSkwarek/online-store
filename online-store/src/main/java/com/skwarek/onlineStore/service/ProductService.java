package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.domain.product.Product;
import com.skwarek.onlineStore.service.generic.GenericService;

/**
 * Created by Michal on 26.09.2016.
 */
public interface ProductService extends GenericService<Product, Long> {

    boolean removeProduct(Long id);
}
