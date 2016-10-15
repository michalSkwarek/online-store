package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.data.dao.AddressDao;
import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.service.AddressService;
import com.skwarek.onlineStore.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Michal on 23.09.2016.
 */
@Service("addressService")
@Transactional(propagation = Propagation.REQUIRED)
public class AddressServiceImpl extends GenericServiceImpl<Address, Long> implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public Address getAddressByUsername(String username) {
        return addressDao.getAddressByUsername(username);
    }

    @Override
    public void createAddress(Address address) {
        addressDao.create(address);
    }

    @Override
    public void updateAddress(Address address) {
        addressDao.updateAddress(address);
    }

    @Override
    public boolean deleteAddress(Long id) {
        return addressDao.deleteAddress(id);
    }

}
