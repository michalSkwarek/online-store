package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.AddressDao;
import com.skwarek.onlineStore.data.dao.CustomerDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal on 23.09.2016.
 */
@Repository("addressDao")
public class AddressDaoImpl extends GenericDaoImpl<Address, Long> implements AddressDao {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void createBillingAddress(Address address) {
        create(address);
        Customer customer = customerDao.findLastCustomer();
        customer.setBillingAddress(address);
        customerDao.updateCustomer(customer);
    }

    @Override
    public void updateBillingAddress(Address address) {
        update(address);
    }

    @Override
    public void createShippingAddress(Address address) {
        create(address);
    }
}
