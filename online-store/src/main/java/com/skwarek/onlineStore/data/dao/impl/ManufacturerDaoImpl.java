package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.ManufacturerDao;
import com.skwarek.onlineStore.data.dao.UploadFileDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.data.entity.product.UploadFile;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal on 27.09.2016.
 */
@Repository("manufacturerDao")
public class ManufacturerDaoImpl extends GenericDaoImpl<Manufacturer, Long> implements ManufacturerDao {

    @Autowired
    private UploadFileDao uploadFileDao;

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

    @Override
    public void updateManufacturer(Manufacturer manufacturer) {
        if (manufacturer.getLogo() != null) {
            UploadFile logo = uploadFileDao.read(manufacturer.getLogo().getId());
            manufacturer.setLogo(logo);
        }
        update(manufacturer);
    }
}
