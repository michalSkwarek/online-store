package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.data.dao.OrderDao;
import com.skwarek.onlineStore.data.entity.order.Order;
import com.skwarek.onlineStore.service.OrderService;
import com.skwarek.onlineStore.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michal on 20/10/2016.
 */
@Service("orderService")
public class OrderServiceImpl extends GenericServiceImpl<Order, Long> implements OrderService {

    @Autowired
    private OrderDao orderDao;
}
