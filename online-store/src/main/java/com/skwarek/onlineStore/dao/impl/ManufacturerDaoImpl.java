package com.skwarek.onlineStore.dao.impl;

import com.skwarek.onlineStore.dao.ManufacturerDao;
import com.skwarek.onlineStore.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.domain.product.Manufacturer;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal on 27.09.2016.
 */
@Repository("manufacturerDao")
public class ManufacturerDaoImpl extends GenericDaoImpl<Manufacturer, Long> implements ManufacturerDao {

}
