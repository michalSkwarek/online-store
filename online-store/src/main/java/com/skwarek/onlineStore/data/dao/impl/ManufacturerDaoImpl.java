package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.ManufacturerDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal on 27.09.2016.
 */
@Repository("manufacturerDao")
public class ManufacturerDaoImpl extends GenericDaoImpl<Manufacturer, Long> implements ManufacturerDao {

    @Override
    public boolean deleteManufacturer(Long id) {

        Query manufacturerProductsQuery = getSession().createQuery("from Product where manufacturer.id = :id");
        manufacturerProductsQuery.setParameter("id", id);

        if (!manufacturerProductsQuery.list().isEmpty()) {
            return false;
        }

        Query removeManufacturerQuery = getSession().createQuery("delete from Manufacturer where id = :id");
        removeManufacturerQuery.setParameter("id", id);
        return removeManufacturerQuery.executeUpdate() > 0;
    }
}
