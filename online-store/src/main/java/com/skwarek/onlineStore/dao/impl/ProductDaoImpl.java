package com.skwarek.onlineStore.dao.impl;

import com.skwarek.onlineStore.dao.ProductDao;
import com.skwarek.onlineStore.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.domain.product.Product;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Michal on 26.09.2016.
 */
@Repository("productDao")
public class ProductDaoImpl extends GenericDaoImpl<Product, Long> implements ProductDao {

    @Override
    public boolean removeProduct(Long id) {
        Query removeProductQuery = getSession().createQuery("delete from Product where id = :ID");
        removeProductQuery.setParameter("ID", id);
        return removeProductQuery.executeUpdate() > 0;
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
}
