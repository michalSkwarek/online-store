package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.service.generic.GenericService;

import java.util.List;
import java.util.Map;

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

    List<Product> getProductsByFilter(String[] categories, String[] manufacturers, String low, String high, String priceOrder);
}
