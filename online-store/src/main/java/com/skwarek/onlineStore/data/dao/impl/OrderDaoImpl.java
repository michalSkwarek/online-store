package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.OrderDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.order.Order;
import com.skwarek.onlineStore.data.entity.user.Customer;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Michal on 20/10/2016.
 */
@Repository("orderDao")
public class OrderDaoImpl extends GenericDaoImpl<Order, Long> implements OrderDao {

    @Override
    public List getCustomerOrders(Customer customer) {
        Query getOrdersQuery = getSession().createQuery("from Order o where o.customer = :customer");
        getOrdersQuery.setParameter("customer", customer);
        return getOrdersQuery.list();
    }

    @Override
    public void createOrder(Order order) {
        create(order);
    }
}
