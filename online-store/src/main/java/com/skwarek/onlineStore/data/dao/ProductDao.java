package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.data.dao.generic.GenericDao;
import com.skwarek.onlineStore.data.entity.product.Product;

import java.util.List;

/**
 * Created by Michal on 26.09.2016.
 */
public interface ProductDao extends GenericDao<Product, Long> {

    Product findProductByModel(String model);

    List findRandomFewProducts();

    List findProductsByCategory(String category);

    List findProductsByManufacturer(String manufacturer);

    List findProductsByCategoriesFilter(String[] categories);

    List findProductsByManufacturersFilter(String[] manufacturers);

    List findProductsByPriceFilter(String low, String high, String priceOrder);

    List<Product> findProductsByFilter(String[] categories, String[] manufacturers, String lowPrice, String highPrice, String priceOrder);

    void createProduct(Product product);

    void updateProduct(Product product);

    boolean deleteProduct(Long id);
}
