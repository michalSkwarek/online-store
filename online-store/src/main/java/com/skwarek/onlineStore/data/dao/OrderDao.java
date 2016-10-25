package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.data.dao.generic.GenericDao;
import com.skwarek.onlineStore.data.entity.order.Order;

/**
 * Created by Michal on 20/10/2016.
 */
public interface OrderDao extends GenericDao<Order, Long> {

    void createOrder(Order order);
}
