package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.ProductDao;
import com.skwarek.onlineStore.data.dao.ProductSpecificationsDao;
import com.skwarek.onlineStore.data.dao.UploadFileDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.data.entity.product.UploadFile;
import com.skwarek.onlineStore.data.entity.product.specifications.ProductSpecifications;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michal on 26.09.2016.
 */
@Repository("productDao")
public class ProductDaoImpl extends GenericDaoImpl<Product, Long> implements ProductDao {

    @Autowired
    private ProductSpecificationsDao productSpecificationsDao;

    @Autowired
    private UploadFileDao uploadFileDao;

    @Override
    public boolean deleteProduct(Long id) {
        Query removeProductQuery = getSession().createQuery("delete from Product p where p.id = :id");
        removeProductQuery.setParameter("id", id);
        return removeProductQuery.executeUpdate() > 0;
    }

    @Override
    public void updateProduct(Product product) {
        if (product.getProductImage() != null) {
            UploadFile productImage = uploadFileDao.read(product.getProductImage().getId());
            product.setProductImage(productImage);
        }
        if (product.getProductSpecifications() != null) {
            ProductSpecifications productSpecifications = productSpecificationsDao.read(product.getProductSpecifications().getId());
            product.setProductSpecifications(productSpecifications);
        }
        update(product);
    }

    @Override
    public List findRandomFewProducts() {
        Query listOfRandomProducts = getSession().createQuery("from Product p where p.unitPrice > (select avg(p.unitPrice) from p) order by p.unitsInMagazine desc");
        listOfRandomProducts.setMaxResults(8);
        return listOfRandomProducts.list();
    }

    @Override
    public List findProductsByCategory(String category) {
        Query listOfProductsByCategoryQuery = getSession().createQuery("from Product p where p.category.name = :name");
        listOfProductsByCategoryQuery.setParameter("name", category);
        return listOfProductsByCategoryQuery.list();
    }

    @Override
    public List findroductsByManufacturer(String manufacturer) {
        Query listOfProductsByManufacturerQuery = getSession().createQuery("from Product p where p.manufacturer.brand = :brand");
        listOfProductsByManufacturerQuery.setParameter("brand", manufacturer);
        return listOfProductsByManufacturerQuery.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List findProductsByCategoriesFilter(String[] categories) {
        List<Product> productsByCategories = new ArrayList<>();
        for (String category : categories) {
            productsByCategories.addAll(this.findProductsByCategory(category));
        }
        return productsByCategories;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List findProductsByManufacturersFilter(String[] manufacturers) {
        List<Product> productsByManufacturers = new ArrayList<>();
        for (String manufacturer : manufacturers) {
            productsByManufacturers.addAll(this.findroductsByManufacturer(manufacturer));
        }
        return productsByManufacturers;
    }

    @Override
    public List findProductsByPriceFilter(String low, String high, String priceOrder) {
        if (!low.equals("") && !high.equals("")) {
            return getProductsByPriceFilterWithLowAndHighParams(low, high, priceOrder);
        } else if (!low.equals("") && high.equals("")) {
            return getProductsByPriceFilterWithLowParam(low, priceOrder);
        } else if (low.equals("") && !high.equals("")) {
            return  getProductsByPriceFilterWithHighParam(high, priceOrder);
        } else {
            return getProductsByPriceFilterWithoutLowAndHighParams(priceOrder);
        }
    }

    private List getProductsByPriceFilterWithLowAndHighParams(String low, String high, String priceOrder) {
        BigDecimal lowPrice = BigDecimal.valueOf(Double.parseDouble(low));
        BigDecimal highPrice = BigDecimal.valueOf(Double.parseDouble(high));
        Query listOfProductsQuery = getSession().createQuery("from Product p where p.unitPrice > :lowPrice " +
                "and p.unitPrice < :highPrice order by p.unitPrice " + priceOrder);
        listOfProductsQuery.setBigDecimal("lowPrice", lowPrice);
        listOfProductsQuery.setBigDecimal("highPrice", highPrice);
        return listOfProductsQuery.list();
    }

    private List getProductsByPriceFilterWithLowParam(String low, String priceOrder) {
        BigDecimal lowPrice = BigDecimal.valueOf(Double.parseDouble(low));
        Query listOfProductsQuery = getSession().createQuery("from Product p where p.unitPrice > :lowPrice " +
                "order by p.unitPrice " + priceOrder);
        listOfProductsQuery.setBigDecimal("lowPrice", lowPrice);
        return listOfProductsQuery.list();
    }

    private List getProductsByPriceFilterWithHighParam(String high, String priceOrder) {
        BigDecimal highPrice = BigDecimal.valueOf(Double.parseDouble(high));
        Query listOfProductsQuery = getSession().createQuery("from Product p where p.unitPrice < :highPrice " +
                "order by p.unitPrice " + priceOrder);
        listOfProductsQuery.setBigDecimal("highPrice", highPrice);
        return listOfProductsQuery.list();
    }

    private List getProductsByPriceFilterWithoutLowAndHighParams(String priceOrder) {
        Query listOfProductsQuery = getSession().createQuery("from Product p order by p.unitPrice " + priceOrder);
        return listOfProductsQuery.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> findProductsByFilter(String[] categories, String[] manufacturers, String low, String high, String priceOrder) {
        List<Product> listOfProducts = this.findProductsByPriceFilter(low, high, priceOrder);
        listOfProducts.retainAll(this.findProductsByCategoriesFilter(categories));
        listOfProducts.retainAll(this.findProductsByManufacturersFilter(manufacturers));
        return listOfProducts;
    }

    @Override
    public Product findProductByModel(String model) {
        Query getProductQuery = getSession().createQuery("from Product p where p.model = :model");
        getProductQuery.setParameter("model", model);
        getProductQuery.setMaxResults(1);
        return (Product) getProductQuery.uniqueResult();
    }
}
