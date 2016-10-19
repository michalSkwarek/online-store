package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.ShippingDetailDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.order.ShippingDetail;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal on 20/10/2016.
 */
@Repository("ShippingDetailDao")
public class ShippingDetailDaoImpl extends GenericDaoImpl<ShippingDetail, Long> implements ShippingDetailDao {

}