package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.service.generic.GenericService;

import java.util.List;

/**
 * Created by Michal on 26.09.2016.
 */
public interface ProductService extends GenericService<Product, Long> {

    boolean deleteProduct(Long id);

    void updateProduct(Product product);

    List findRandomFewProducts();

    List findProductsByCategory(String category);

    List<Product> findProductsByFilter(String[] categories, String[] manufacturers, String low, String high, String priceOrder);

    Product findProductByModel(String model);
}
