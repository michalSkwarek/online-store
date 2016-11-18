package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.data.dao.generic.GenericDao;
import com.skwarek.onlineStore.data.entity.product.Manufacturer;

/**
 * Created by Michal on 27.09.2016.
 */
public interface ManufacturerDao extends GenericDao<Manufacturer, Long> {

    boolean deleteManufacturer(Long id);

    void updateManufacturer(Manufacturer manufacturer);

    Manufacturer findManufacturerByBrand(String brand);
}