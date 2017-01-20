package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.data.dao.ManufacturerDao;
import com.skwarek.onlineStore.data.dao.UploadFileDao;
import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.data.entity.product.UploadFile;
import com.skwarek.onlineStore.service.ManufacturerService;
import com.skwarek.onlineStore.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Created by Michal on 27.09.2016.
 */
@Service("manufacturerService")
@Transactional(propagation = Propagation.REQUIRED)
public class ManufacturerServiceImpl extends GenericServiceImpl<Manufacturer, Long> implements ManufacturerService {

    private final ManufacturerDao manufacturerDao;
    private final UploadFileDao uploadFileDao;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerDao manufacturerDao, UploadFileDao uploadFileDao) {
        this.manufacturerDao = manufacturerDao;
        this.uploadFileDao = uploadFileDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Manufacturer findManufacturerByBrand(String brand) {
        return manufacturerDao.findManufacturerByBrand(brand);
    }

    @Override
    public void createManufacturer(Manufacturer manufacturer) {
        manufacturerDao.createManufacturer(manufacturer);
    }

    @Override
    public void updateManufacturer(Manufacturer manufacturer) {
        manufacturerDao.updateManufacturer(manufacturer);
    }

    @Override
    public boolean deleteManufacturer(Long id) {
        return manufacturerDao.deleteManufacturer(id);
    }

    @Override
    public void addLogoToManufacturer(CommonsMultipartFile fileUpload, Manufacturer manufacturer) {
        UploadFile logo = new UploadFile();
        logo.setFileName(fileUpload.getOriginalFilename());
        logo.setData(fileUpload.getBytes());
        uploadFileDao.createFile(logo);
        manufacturer.setLogo(logo);
    }
}
