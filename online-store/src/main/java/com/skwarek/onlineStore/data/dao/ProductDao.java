package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.data.dao.generic.GenericDao;
import com.skwarek.onlineStore.data.entity.product.Product;

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
