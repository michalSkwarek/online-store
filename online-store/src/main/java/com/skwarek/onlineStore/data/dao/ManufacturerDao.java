package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.data.dao.generic.GenericDao;
import com.skwarek.onlineStore.data.entity.product.Manufacturer;

/**
 * Created by Michal on 27.09.2016.
 */
public interface ManufacturerDao extends GenericDao<Manufacturer, Long> {

    Manufacturer findManufacturerByBrand(String brand);

    void createManufacturer(Manufacturer manufacturer);

    void updateManufacturer(Manufacturer manufacturer);

    boolean deleteManufacturer(Long id);
}