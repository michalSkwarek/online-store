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

    List findRandomFewProducts();

    List findProductsByCategory(String category);

    List findroductsByManufacturer(String manufacturer);

    List findProductsByCategoriesFilter(String[] categories);

    List findProductsByManufacturersFilter(String[] manufacturers);

    List findProductsByPriceFilter(String low, String high, String priceOrder);

    List<Product> findProductsByFilter(String[] categories, String[] manufacturers, String low, String high, String priceOrder);

    Product findProductByModel(String model);
}
