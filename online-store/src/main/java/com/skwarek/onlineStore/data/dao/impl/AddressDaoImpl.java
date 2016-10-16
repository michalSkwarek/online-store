package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.AddressDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.address.City;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal on 23.09.2016.
 */
@Repository("addressDao")
public class AddressDaoImpl extends GenericDaoImpl<Address, Long> implements AddressDao {

    @Override
    public Address getAddressByUsername(String username) {
        Query getAddressQuery = getSession().createQuery("from Address a where a.customer.account.username = :username");
        getAddressQuery.setParameter("username", username);
        getAddressQuery.setMaxResults(1);
        return (Address) getAddressQuery.uniqueResult();
    }

    @Override
    public void createAddress(Address address) {
        setCityToAddress(address);
        create(address);
    }

    @Override
    public void updateAddress(Address address) {
        setCityToAddress(address);
        update(address);
    }

    private void setCityToAddress(Address address) {
        City city = getCityFromDatabase(address);
        if (city != null) {
            address.setCity(city);
        }
    }

    private City getCityFromDatabase(Address address) {
        Query findCityQuery = getSession().createQuery("from City c where c.name = :name");
        findCityQuery.setParameter("name", address.getCity().getName());
        findCityQuery.setMaxResults(1);
        return (City) findCityQuery.uniqueResult();
    }
}
