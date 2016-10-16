package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.data.dao.generic.GenericDao;
import com.skwarek.onlineStore.data.entity.address.Address;

import java.util.List;

/**
 * Created by Michal on 23.09.2016.
 */
public interface AddressDao extends GenericDao<Address, Long> {

    Address getAddressByUsername(String username);

    void createAddress(Address address);

    void updateAddress(Address address);
}
