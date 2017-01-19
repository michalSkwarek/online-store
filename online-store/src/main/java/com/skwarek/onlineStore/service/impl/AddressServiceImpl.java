package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.data.dao.AddressDao;
import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.service.AddressService;
import com.skwarek.onlineStore.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Michal on 23.09.2016.
 */
@Service("addressService")
@Transactional(propagation = Propagation.REQUIRED)
public class AddressServiceImpl extends GenericServiceImpl<Address, Long> implements AddressService {

    private final AddressDao addressDao;

    @Autowired
    public AddressServiceImpl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public void createBillingAddress(Address address) {
        addressDao.createBillingAddress(address);
    }

    @Override
    public void updateBillingAddress(Address address) {
        addressDao.updateBillingAddress(address);
    }

    @Override
    public void createShippingAddress(Address address) {
        addressDao.createShippingAddress(address);
    }
}
