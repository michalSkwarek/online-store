package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.service.generic.GenericService;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * Created by Michal on 26.09.2016.
 */
public interface ProductService extends GenericService<Product, Long> {

    Product findProductByModel(String model);

    List findRandomFewProducts();

    List findProductsByCategory(String category);

    List<Product> findProductsByFilter(String[] categories, String[] manufacturers, String lowPrice, String highPrice, String priceOrder);

    void createProduct(Product product);

    void updateProduct(Product product);

    boolean deleteProduct(Long id);

    void addImageToProduct(CommonsMultipartFile fileUpload, Product product);
}
