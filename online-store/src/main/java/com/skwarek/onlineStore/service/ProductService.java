package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.service.generic.GenericService;

import java.util.List;

/**
 * Created by Michal on 26.09.2016.
 */
public interface ProductService extends GenericService<Product, Long> {

    boolean deleteProduct(Long id);

    List getRandomFewProducts();

    List getProductsByCategory(String category);

    List getProductsByManufacturer(String manufacturer);

    List getSortedProductsOrderByUnitPriceAscending();

    List getSortedProductsOrderByUnitPriceDescending();
}
