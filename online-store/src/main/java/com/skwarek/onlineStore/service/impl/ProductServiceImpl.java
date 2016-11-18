package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.data.dao.ProductDao;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.service.ProductService;
import com.skwarek.onlineStore.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Michal on 26.09.2016.
 */
@Service("productService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductServiceImpl extends GenericServiceImpl<Product, Long> implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public boolean deleteProduct(Long id) {
        return productDao.deleteProduct(id);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List findRandomFewProducts() {
        return productDao.findRandomFewProducts();
    }

    @Override
    @Transactional(readOnly = true)
    public List findProductsByCategory(String category) {
        return productDao.findProductsByCategory(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findProductsByFilter(String[] categories, String[] manufacturers, String low, String high, String priceOrder) {
        return productDao.findProductsByFilter(categories, manufacturers, low, high, priceOrder);
    }

    @Override
    public Product findProductByModel(String model) {
        return productDao.findProductByModel(model);
    }
}
