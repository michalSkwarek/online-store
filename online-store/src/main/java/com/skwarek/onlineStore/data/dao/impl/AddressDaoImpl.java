package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.AddressDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.address.City;
import com.skwarek.onlineStore.data.entity.address.Country;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal on 23.09.2016.
 */
@Repository("addressDao")
public class AddressDaoImpl extends GenericDaoImpl<Address, Long> implements AddressDao {

    @Override
    public Address getAddressByUsername(String username) {
        Query getAddress = getSession().createQuery("from Address ad where ad.id = (from Account ac where ac.customer.billingAddress = :username)");
        getAddress.setParameter("username", username);
        getAddress.setMaxResults(1);
        return (Address) getAddress.uniqueResult();
    }

    @Override
    public void createAddress(Address address) {
        Country country = getCountryFromDatabase(address);
        if (country != null) {
            address.getCity().setCountry(country);
        }
        City city = getCityFromDatabase(address);
        if (city != null) {
            address.setCity(city);
        }
        create(address);
    }

    @Override
    public void updateAddress(Address address) {
        Country country = getCountryFromDatabase(address);
        if (country != null) {
            address.getCity().setCountry(country);
        }
        City city = getCityFromDatabase(address);
        if (city != null) {
            address.setCity(city);
        }
        update(address);
    }

    @Override
    public boolean deleteAddress(Long id) {
        Query removeAddressQuery = getSession().createQuery("delete from Address where id = :id");
        removeAddressQuery.setParameter("id", id);
        return removeAddressQuery.executeUpdate() > 0;
    }

    private City getCityFromDatabase(Address address) {
        Query findCityQuery = getSession().createQuery("from City where name = :name");
        findCityQuery.setParameter("name", address.getCity().getName());
        findCityQuery.setMaxResults(1);
        return (City) findCityQuery.uniqueResult();
    }

    private Country getCountryFromDatabase(Address address) {
        Query findCountryQuery = getSession().createQuery("from Country where name = :name");
        findCountryQuery.setParameter("name", address.getCity().getCountry().getName());
        findCountryQuery.setMaxResults(1);
        return (Country) findCountryQuery.uniqueResult();
    }
}
