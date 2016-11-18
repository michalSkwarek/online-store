package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.data.dao.generic.GenericDao;
import com.skwarek.onlineStore.data.entity.user.Customer;

/**
 * Created by Michal on 13/10/16.
 */
public interface CustomerDao extends GenericDao<Customer, Long> {

    Customer findLastCustomer();

    void createCustomer(Customer customer);

    void updateCustomer(Customer customer);
}