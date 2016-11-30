package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.address.City;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.data.entity.user.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Michal on 05/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
@WebAppConfiguration
@Transactional
public class TestCustomerService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    private Account newAccount;
    private Customer newCustomer;
    private City newCity;
    private Address newAddress;

    @Before
    public void setUp() {
        this.newCity = new City();
        this.newCity.setName("Warsaw");

        this.newAddress = new Address();
        this.newAddress.setStreet("Magic Street");
        this.newAddress.setStreetNumber("1A");
        this.newAddress.setDoorNumber("99");
        this.newAddress.setZipCode("11-222");
        this.newAddress.setCity(newCity);

        this.newCustomer = new Customer();
        this.newCustomer.setFirstName("John");
        this.newCustomer.setLastName("Doe");
        this.newCustomer.setBirthDate("2000-06-16");
        this.newCustomer.setBillingAddress(newAddress);
        this.newCustomer.setPhoneNumber("123456789");

        this.newAccount = new Account();
        this.newAccount.setUsername("user");
        this.newAccount.setPassword("pass");
        this.newAccount.setEnabled(true);
        this.newAccount.setEmail("email@gmail.com");
        this.newAccount.setDateCreated(new Date());
        this.newAccount.setRole(Account.ROLE_USER);
        this.newAccount.setCustomer(newCustomer);
    }

    @Test
    public void testCreateCustomer() {
        newAccount.setCustomer(null);
        accountService.create(newAccount);
        int oldSize = customerService.findAll().size();
        customerService.createCustomer(newCustomer);
        assertTrue(oldSize + 1 == customerService.findAll().size());
    }

    @Test
    public void testUpdateCustomer() {
        accountService.create(newAccount);
        newCustomer.setFirstName("John1");
        newCustomer.setLastName("Doe1");
        newCustomer.setBirthDate("2000-06-17");
        newCustomer.setPhoneNumber("111222333");
        customerService.updateCustomer(newCustomer);
        Customer found = customerService.read(newCustomer.getId());
        assertEquals("John1", found.getFirstName());
        assertEquals("Doe1", found.getLastName());
        assertEquals("2000-06-17", found.getBirthDate());
        assertEquals("111222333", found.getPhoneNumber());
    }
}
