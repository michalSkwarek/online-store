package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.AddressDao;
import com.skwarek.onlineStore.data.dao.CustomerDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.address.City;
import com.skwarek.onlineStore.data.entity.user.Customer;
import org.hibernate.Query;
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
        setCityToAddress(address);
        Customer customer = customerDao.findLastCustomer();
        customer.setBillingAddress(address);
        customerDao.update(customer);
    }

    @Override
    public void updateBillingAddress(Address address) {
        setCityToAddress(address);
        update(address);
    }

    @Override
    public void createShippingAddress(Address address) {
        setCityToAddress(address);
        create(address);
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
