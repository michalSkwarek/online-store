package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.service.generic.GenericService;

import java.util.List;

/**
 * Created by Michal on 23.09.2016.
 */
public interface AddressService extends GenericService<Address, Long> {

    Address getAddressByUsername(String username);

    void createAddress(Address address);

    void updateAddress(Address address);
}
