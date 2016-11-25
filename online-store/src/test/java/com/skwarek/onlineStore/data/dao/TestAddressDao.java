package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.address.City;
import com.skwarek.onlineStore.data.entity.user.Customer;
import org.junit.Before;
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

    private static Customer newCustomer;
    private static City newCity;
    private static City otherCity;
    private static Address newAddress;
    private static Address otherAddress;

    @Before
    public void setUp() {
        newCity = new City();
        newCity.setName("Warsaw");

        otherCity = new City();
        otherCity.setName("Cracow");

        newAddress = new Address();
        newAddress.setStreet("Magic Street");
        newAddress.setStreetNumber("1A");
        newAddress.setDoorNumber("99");
        newAddress.setZipCode("11-222");
        newAddress.setCity(newCity);

        otherAddress = new Address();
        otherAddress.setStreet("No magic Street");
        otherAddress.setStreetNumber("2B");
        otherAddress.setDoorNumber("100");
        otherAddress.setZipCode("22-333");
        otherAddress.setCity(otherCity);

        newCustomer = new Customer();
        newCustomer.setFirstName("John");
        newCustomer.setLastName("Doe");
        newCustomer.setBirthDate("2000-06-16");
        newCustomer.setBillingAddress(newAddress);
        newCustomer.setPhoneNumber("123456789");
        newCustomer.setNumberOfOrders(1);
    }

    @Test
    public void testCreateBillingAddressWithNoExistCityInDatabase() {
        customerDao.create(newCustomer);
        int oldSizeAddresses = addressDao.findAll().size();
        int oldSizeCities = citiesCounter();
        addressDao.createBillingAddress(otherAddress);
        assertTrue(oldSizeAddresses < addressDao.findAll().size());
        assertTrue(oldSizeCities < citiesCounter());

    }

    @Test
    public void testCreateBillingAddressWithExistCityInDatabase() {
        customerDao.create(newCustomer);
        int oldSizeAddresses = addressDao.findAll().size();
        int oldSizeCities = citiesCounter();
        otherAddress.setCity(newCity);
        addressDao.createBillingAddress(otherAddress);
        assertTrue(oldSizeAddresses < addressDao.findAll().size());
        assertTrue(oldSizeCities == citiesCounter());
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
    public void testUpdateAddress() {
        addressDao.create(newAddress);
        newAddress.setStreet("No magic Street");
        newAddress.setStreetNumber("2B");
        newAddress.setDoorNumber("100");
        newAddress.setZipCode("22-333");
        newAddress.setCity(otherCity);
        addressDao.updateBillingAddress(newAddress);
        Address found = addressDao.read(newAddress.getId());
        assertEquals("No magic Street", found.getStreet());
        assertEquals("2B", found.getStreetNumber());
        assertEquals("100", found.getDoorNumber());
        assertEquals("22-333", found.getZipCode());
        assertEquals("Cracow", found.getCity().getName());
    }

    @Test
    public void testCreateShippingAddress() {
        customerDao.create(newCustomer);
        int oldSizeAddresses = addressDao.findAll().size();
        Address shippingAddress = otherAddress;
        addressDao.createShippingAddress(shippingAddress);
        assertTrue(oldSizeAddresses < addressDao.findAll().size());
    }
}
