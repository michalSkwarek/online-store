package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.data.dao.generic.GenericDao;
import com.skwarek.onlineStore.data.entity.address.Address;

/**
 * Created by Michal on 23.09.2016.
 */
public interface AddressDao extends GenericDao<Address, Long> {

    void createBillingAddress(Address address);

    void updateBillingAddress(Address address);

    void createShippingAddress(Address address);
}
