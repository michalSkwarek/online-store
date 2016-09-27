package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.dao.ProductDao;
import com.skwarek.onlineStore.domain.product.Product;
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
public class ProductServiceImpl extends GenericServiceImpl<Product, Long> implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean removeProduct(Long id) {
        return productDao.removeProduct(id);
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
}
