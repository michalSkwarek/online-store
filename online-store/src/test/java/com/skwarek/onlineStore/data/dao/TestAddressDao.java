package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.address.City;
import com.skwarek.onlineStore.data.entity.user.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Michal on 05/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
@WebAppConfiguration
@Transactional
public class TestAddressDao {

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testCreateBillingAddressWithNoExistCityInDatabase() {
        Customer newCustomer = new Customer("John", "Doe", "2000-06-16", "123456789", 1);
        customerDao.create(newCustomer);
        int sizeAddresses = addressDao.findAll().size();
        int sizeCities = citiesCounter();
        Address billingAddress = new Address("Street", "1A", "2B", "11-222", new City("City"));
        addressDao.createBillingAddress(billingAddress);
        assertTrue(sizeAddresses < addressDao.findAll().size());
        assertTrue(sizeCities < citiesCounter());

    }

    @Test
    public void testCreateBillingAddressWithExistCityInDatabase() {
        Address billingAddress = new Address("Street", "1A", "2B", "11-222", new City("City"));
        addressDao.createBillingAddress(billingAddress);
        int sizeCities = citiesCounter();
        Address newBillingAddress = new Address("Street1", "1A", "2B", "11-222", new City("City"));
        addressDao.createBillingAddress(newBillingAddress);
        assertTrue(sizeCities == citiesCounter());
    }

    private int citiesCounter() {
        List<Address> addresses = addressDao.findAll();
        Set<String> cities = new HashSet<>();
        for (Address address : addresses) {
            cities.add(address.getCity().getName());
        }
        return cities.size();
    }

    @Test
    public void testCreateShippingAddressWithExistCityInDatabase() {
        int sizeAddresses = addressDao.findAll().size();
        Address shippingAddress = new Address("Street", "1A", "2B", "11-222", new City("City"));
        addressDao.createShippingAddress(shippingAddress);
        assertTrue(sizeAddresses < addressDao.findAll().size());
    }

    @Test
    public void testUpdateAddress() {
        Address billingAddress = new Address("Street", "1A", "2B", "11-222", new City("City"));
        addressDao.createBillingAddress(billingAddress);
        billingAddress.setStreet("Street1");
        billingAddress.setStreetNumber("1B");
        billingAddress.setDoorNumber("2C");
        billingAddress.setZipCode("22-333");
        billingAddress.setCity(new City("City1"));
        addressDao.updateBillingAddress(billingAddress);
        Address found = addressDao.read(billingAddress.getId());
        assertEquals("Street1", found.getStreet());
        assertEquals("1B", found.getStreetNumber());
        assertEquals("2C", found.getDoorNumber());
        assertEquals("22-333", found.getZipCode());
        assertEquals("City1", found.getCity().getName());
    }
}
