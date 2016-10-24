package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.service.generic.GenericService;

/**
 * Created by Michal on 23.09.2016.
 */
public interface AddressService extends GenericService<Address, Long> {

    void createAddress(Address address);

    void updateAddress(Address address);
}
