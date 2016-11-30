package com.skwarek.onlineStore.service;

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
public class TestAddressService {

    @Autowired
    private AddressService addressService;

    @Autowired
    private CustomerService customerService;

    private static Customer newCustomer;
    private static City newCity;
    private static City otherCity;
    private static Address newAddress;
    private static Address otherAddress;

    @Before
    public void setUp() {
        newCity = new City();
        newCity.setName("NewCity");

        otherCity = new City();
        otherCity.setName("OtherCity");

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
        customerService.create(newCustomer);
        int oldSizeAddresses = addressService.findAll().size();
        int oldSizeCities = citiesCounter();
        addressService.createBillingAddress(otherAddress);
        assertTrue(oldSizeAddresses + 1 == addressService.findAll().size());
        assertTrue(oldSizeCities + 1 == citiesCounter());

    }

    @Test
    public void testCreateBillingAddressWithExistCityInDatabase() {
        customerService.create(newCustomer);
        int oldSizeAddresses = addressService.findAll().size();
        int oldSizeCities = citiesCounter();
        otherAddress.setCity(newCity);
        addressService.createBillingAddress(otherAddress);
        assertTrue(oldSizeAddresses + 1 == addressService.findAll().size());
        assertTrue(oldSizeCities == citiesCounter());
    }

    private int citiesCounter() {
        List<Address> addresses = addressService.findAll();
        Set<String> cities = new HashSet<>();
        for (Address address : addresses) {
            cities.add(address.getCity().getName());
        }
        return cities.size();
    }

    @Test
    public void testUpdateAddress() {
        addressService.create(newAddress);
        newAddress.setStreet("No magic Street");
        newAddress.setStreetNumber("2B");
        newAddress.setDoorNumber("100");
        newAddress.setZipCode("22-333");
        newAddress.setCity(otherCity);
        addressService.updateBillingAddress(newAddress);
        Address found = addressService.read(newAddress.getId());
        assertEquals("No magic Street", found.getStreet());
        assertEquals("2B", found.getStreetNumber());
        assertEquals("100", found.getDoorNumber());
        assertEquals("22-333", found.getZipCode());
        assertEquals("OtherCity", found.getCity().getName());
    }

    @Test
    public void testCreateShippingAddressWithDifferentBillingAddress() {
        customerService.create(newCustomer);
        int oldSizeAddresses = addressService.findAll().size();
        Address shippingAddress = otherAddress;
        addressService.createShippingAddress(shippingAddress);
        assertTrue(oldSizeAddresses + 1 == addressService.findAll().size());
    }

    @Test
    public void testCreateShippingAddressWithSameBillingAddress() {
        customerService.create(newCustomer);
        int oldSizeAddresses = addressService.findAll().size();
        addressService.createShippingAddress(newAddress);
        assertTrue(oldSizeAddresses == addressService.findAll().size());
    }
}
