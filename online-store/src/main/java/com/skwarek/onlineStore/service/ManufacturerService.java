package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.service.generic.GenericService;

/**
 * Created by Michal on 27.09.2016.
 */
public interface ManufacturerService extends GenericService<Manufacturer, Long> {

    boolean deleteManufacturer(Long id);

    void updateManufacturer(Manufacturer manufacturer);

    Manufacturer getManufacturerByBrand(String brand);
}
