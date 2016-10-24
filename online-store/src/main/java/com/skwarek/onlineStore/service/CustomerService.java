package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.data.entity.user.Customer;
import com.skwarek.onlineStore.service.generic.GenericService;

/**
 * Created by Michal on 13/10/16.
 */
public interface CustomerService extends GenericService<Customer, Long> {

    void createCustomer(Customer customer);

    void updateCustomer(Customer customer);
}
