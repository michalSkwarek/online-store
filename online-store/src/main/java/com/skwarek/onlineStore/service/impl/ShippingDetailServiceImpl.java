package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.data.dao.ShippingDetailDao;
import com.skwarek.onlineStore.data.entity.order.ShippingDetail;
import com.skwarek.onlineStore.service.ShippingDetailService;
import com.skwarek.onlineStore.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michal on 20/10/2016.
 */
@Service("shippingDetailService")
public class ShippingDetailServiceImpl extends GenericServiceImpl<ShippingDetail, Long> implements ShippingDetailService {

    @Autowired
    private ShippingDetailDao shippingDetailDao;
}
