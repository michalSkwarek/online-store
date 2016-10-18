package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.ProductDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.product.Product;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by Michal on 26.09.2016.
 */
@Repository("productDao")
public class ProductDaoImpl extends GenericDaoImpl<Product, Long> implements ProductDao {

    @Override
    public boolean deleteProduct(Long id) {
//        Query productItemsQuery = getSession().createQuery("from Item i where i.product.id = :id");
//        productItemsQuery.setParameter("id", id);
//
//        if (!productItemsQuery.list().isEmpty()) {
//            return false;
//        }

        Query removeProductQuery = getSession().createQuery("delete from Product p where p.id = :id");
        removeProductQuery.setParameter("id", id);
        return removeProductQuery.executeUpdate() > 0;
    }

    @Override
    public List getRandomFewProducts() {
        Query listOfRandomProducts = getSession().createQuery("from Product p where p.unitPrice > (select avg(p.unitPrice) from p) order by p.unitsInMagazine desc");
        listOfRandomProducts.setMaxResults(8);
        return listOfRandomProducts.list();
    }

    @Override
    public List getProductsByCategory(String category) {
        Query listOfProductsByCategoryQuery = getSession().createQuery("from Product where category.name = :name");
        listOfProductsByCategoryQuery.setParameter("name", category);
        return listOfProductsByCategoryQuery.list();
    }

    @Override
    public List getProductsByManufacturer(String manufacturer) {
        Query listOfProductsByManufacturerQuery = getSession().createQuery("from Product where manufacturer.brand = :brand");
        listOfProductsByManufacturerQuery.setParameter("brand", manufacturer);
        return listOfProductsByManufacturerQuery.list();
    }

    @Override
    public List getSortedProductsOrderByUnitPriceAscending() {
        Query listOfProductsByCategoryQuery = getSession().createQuery("from Product order by unitPrice asc");
        return listOfProductsByCategoryQuery.list();
    }

    @Override
    public List getSortedProductsOrderByUnitPriceDescending() {
        Query listOfProductsByCategoryQuery = getSession().createQuery("from Product order by unitPrice desc");
        return listOfProductsByCategoryQuery.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getProductsByCategoriesFilter(String[] categories) {
        List<Product> productsByCategories = new ArrayList<>();
        for (String category : categories) {
            productsByCategories.addAll(this.getProductsByCategory(category));
        }
        return productsByCategories;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getProductsByManufacturersFilter(String[] manufacturers) {
        List<Product> productsByManufacturers = new ArrayList<>();
        for (String manufacturer : manufacturers) {
            productsByManufacturers.addAll(this.getProductsByManufacturer(manufacturer));
        }
        return productsByManufacturers;
    }

    @Override
    public List getProductsByPriceFilter(String low, String high) {
        if (!low.equalsIgnoreCase("") && !high.equalsIgnoreCase("")) {
            BigDecimal lowPrice = BigDecimal.valueOf(Double.parseDouble(low));
            BigDecimal highPrice = BigDecimal.valueOf(Double.parseDouble(high));
            Query listOfProductsQuery = getSession().createQuery("from Product where unitPrice > :lowPrice and unitPrice < :highPrice");
            listOfProductsQuery.setBigDecimal("lowPrice", lowPrice);
            listOfProductsQuery.setBigDecimal("highPrice", highPrice);
            return listOfProductsQuery.list();
        }
        return null;
    }

    @Override
    public List getSortedProducts(String priceOrder) {
        Query sortedListOfProductsQuery;
        if (priceOrder.equalsIgnoreCase("asc")) {
            sortedListOfProductsQuery = getSession().createQuery("from Product order by unitPrice asc");
        } else {
            sortedListOfProductsQuery = getSession().createQuery("from Product order by unitPrice desc");
        }
        return sortedListOfProductsQuery.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getProductsByFilter(String[] categories, String[] manufacturers, String low, String high, String priceOrder) {
        List<Product> productsByFilter = this.getProductsByCategoriesFilter(categories);
        productsByFilter.retainAll(this.getProductsByManufacturersFilter(manufacturers));
        List productsByPriceFilter = this.getProductsByPriceFilter(low, high);
        if (productsByPriceFilter != null) {
            productsByFilter.retainAll(productsByPriceFilter);
        }

        List<Product> sortedListOfProducts = this.getSortedProducts(priceOrder);
        sortedListOfProducts.retainAll(productsByFilter);

        return sortedListOfProducts;
    }
}
