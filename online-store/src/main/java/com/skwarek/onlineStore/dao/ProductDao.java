package com.skwarek.onlineStore.dao;

import com.skwarek.onlineStore.dao.generic.GenericDao;
import com.skwarek.onlineStore.domain.product.Product;

import java.util.List;

/**
 * Created by Michal on 26.09.2016.
 */
public interface ProductDao extends GenericDao<Product, Long> {

    boolean removeProduct(Long id);

    List getProductsByCategory(String category);

    List getProductsByManufacturer(String manufacturer);

    List getSortedProductsOrderByUnitPriceAscending();

    List getSortedProductsOrderByUnitPriceDescending();
}
