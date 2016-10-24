package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.data.dao.CustomerDao;
import com.skwarek.onlineStore.data.entity.user.Customer;
import com.skwarek.onlineStore.service.CustomerService;
import com.skwarek.onlineStore.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michal on 13/10/16.
 */
@Service("customerService")
public class CustomerServiceImpl extends GenericServiceImpl<Customer, Long> implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void createCustomer(Customer customer) {
        customer.setNumberOfOrders(0);
        customerDao.createCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }
}