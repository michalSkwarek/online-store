package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.OrderDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.order.Order;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal on 20/10/2016.
 */
@Repository("orderDao")
public class OrderDaoImpl extends GenericDaoImpl<Order, Long> implements OrderDao {

}
