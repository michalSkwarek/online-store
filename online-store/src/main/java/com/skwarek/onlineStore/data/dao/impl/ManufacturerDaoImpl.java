package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.ManufacturerDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal on 27.09.2016.
 */
@Repository("manufacturerDao")
public class ManufacturerDaoImpl extends GenericDaoImpl<Manufacturer, Long> implements ManufacturerDao {

}
