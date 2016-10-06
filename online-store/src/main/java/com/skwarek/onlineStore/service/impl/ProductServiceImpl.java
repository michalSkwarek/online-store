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
import java.util.Map;

/**
 * Created by Michal on 26.09.2016.
 */
@Service("productService")
public class ProductServiceImpl extends GenericServiceImpl<Product, Long> implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteProduct(Long id) {
        return productDao.deleteProduct(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List getRandomFewProducts() {
        return productDao.getRandomFewProducts();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List getProductsByCategory(String category) {
        return productDao.getProductsByCategory(category);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List getProductsByManufacturer(String manufacturer) {
        return productDao.getProductsByManufacturer(manufacturer);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List getSortedProductsOrderByUnitPriceAscending() {
        return productDao.getSortedProductsOrderByUnitPriceAscending();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List getSortedProductsOrderByUnitPriceDescending() {
        return productDao.getSortedProductsOrderByUnitPriceDescending();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Product> getProductsByFilter(String[] categories, String[] manufacturers, String low, String high, String priceOrder) {
        return productDao.getProductsByFilter(categories, manufacturers, low, high, priceOrder);
    }


}
