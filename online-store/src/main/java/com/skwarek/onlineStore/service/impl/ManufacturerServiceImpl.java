package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.data.dao.ManufacturerDao;
import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.service.ManufacturerService;
import com.skwarek.onlineStore.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michal on 27.09.2016.
 */
@Service("manufacturerService")
public class ManufacturerServiceImpl extends GenericServiceImpl<Manufacturer, Long> implements ManufacturerService {

    @Autowired
    private ManufacturerDao manufacturerDao;

    @Override
    public boolean deleteManufacturer(Long id) {
        return manufacturerDao.deleteManufacturer(id);
    }
}
