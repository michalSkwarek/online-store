package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.service.generic.GenericService;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Created by Michal on 27.09.2016.
 */
public interface ManufacturerService extends GenericService<Manufacturer, Long> {

    Manufacturer findManufacturerByBrand(String brand);

    void createManufacturer(Manufacturer manufacturer);

    void updateManufacturer(Manufacturer manufacturer);

    boolean deleteManufacturer(Long id);

    void addLogoToManufacturer(CommonsMultipartFile fileUpload, Manufacturer manufacturer);
}
