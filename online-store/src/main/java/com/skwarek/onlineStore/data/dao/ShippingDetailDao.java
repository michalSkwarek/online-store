package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.data.dao.generic.GenericDao;
import com.skwarek.onlineStore.data.entity.order.ShippingDetail;

/**
 * Created by Michal on 20/10/2016.
 */
public interface ShippingDetailDao extends GenericDao<ShippingDetail, Long> {

    void createShippingDetail(ShippingDetail shippingDetail);
}