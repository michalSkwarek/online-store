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
    public Manufacturer findManufacturerByBrand(String brand) {
        Query getManufacturerQuery = getSession().createQuery("from Manufacturer m where m.brand = :brand");
        getManufacturerQuery.setParameter("brand", brand);
        getManufacturerQuery.setMaxResults(1);
        return (Manufacturer) getManufacturerQuery.uniqueResult();
    }

    @Override
    public void createManufacturer(Manufacturer manufacturer) {
        create(manufacturer);
    }

    @Override
    public void updateManufacturer(Manufacturer manufacturer) {
        update(manufacturer);
    }

    @Override
    public boolean deleteManufacturer(Long id) {
        Query manufacturerProductsQuery = getSession().createQuery("from Product p where p.manufacturer.id = :id");
        manufacturerProductsQuery.setParameter("id", id);

        if (!manufacturerProductsQuery.list().isEmpty()) {
            return false;
        }

        Query removeManufacturerQuery = getSession().createQuery("delete from Manufacturer m where m.id = :id");
        removeManufacturerQuery.setParameter("id", id);
        return removeManufacturerQuery.executeUpdate() > 0;
    }
}
