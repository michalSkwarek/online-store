package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.data.dao.ProductDao;
import com.skwarek.onlineStore.data.dao.UploadFileDao;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.entity.product.UploadFile;
import com.skwarek.onlineStore.service.ProductService;
import com.skwarek.onlineStore.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * Created by Michal on 26.09.2016.
 */
@Service("productService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductServiceImpl extends GenericServiceImpl<Product, Long> implements ProductService {

    private final ProductDao productDao;
    private final UploadFileDao uploadFileDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao, UploadFileDao uploadFileDao) {
        this.productDao = productDao;
        this.uploadFileDao = uploadFileDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Product findProductByModel(String model) {
        return productDao.findProductByModel(model);
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
    public List<Product> findProductsByFilter(String[] categories, String[] manufacturers, String lowPrice, String highPrice, String priceOrder) {
        return productDao.findProductsByFilter(categories, manufacturers, lowPrice, highPrice, priceOrder);
    }

    @Override
    public void createProduct(Product product) {
        productDao.createProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(Long id) {
        return productDao.deleteProduct(id);
    }

    @Override
    public void addImageToProduct(CommonsMultipartFile fileUpload, Product product) {
        UploadFile productImage = new UploadFile();
        productImage.setFileName(fileUpload.getOriginalFilename());
        productImage.setData(fileUpload.getBytes());
        uploadFileDao.createFile(productImage);
        product.setProductImage(productImage);
    }
}
