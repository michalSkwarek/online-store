package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.data.dao.generic.GenericDao;
import com.skwarek.onlineStore.data.entity.product.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by Michal on 26.09.2016.
 */
public interface ProductDao extends GenericDao<Product, Long> {

    boolean deleteProduct(Long id);

    void updateProduct(Product product);






    List getRandomFewProducts();

    List getProductsByCategory(String category);

    List getProductsByManufacturer(String manufacturer);

    List getSortedProductsOrderByUnitPriceAscending();

    List getSortedProductsOrderByUnitPriceDescending();

    List<Product> getProductsByCategoriesFilter(String[] categories);

    List<Product> getProductsByManufacturersFilter(String[] manufacturers);

    List getProductsByPriceFilter(String low, String high);

    List getSortedProducts(String priceOrder);

    List<Product> getProductsByFilter(String[] categories, String[] manufacturers, String low, String high, String priceOrder);
}
