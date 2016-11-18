package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.data.dao.generic.GenericDao;
import com.skwarek.onlineStore.data.entity.order.Order;
import com.skwarek.onlineStore.data.entity.user.Customer;

import java.util.List;

/**
 * Created by Michal on 20/10/2016.
 */
public interface OrderDao extends GenericDao<Order, Long> {

    List findCustomerOrders(Customer customer);

    void createOrder(Order order);
}
