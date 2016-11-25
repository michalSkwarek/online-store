package com.skwarek.onlineStore.data.dao;

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

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Michal on 05/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
@WebAppConfiguration
@Transactional
public class TestCustomerDao {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private CustomerDao customerDao;

    private static Account newAccount;
    private static Customer newCustomer;
    private static City newCity;
    private static Address newAddress;

    @Before
    public void setUp() {
        newCity = new City();
        newCity.setName("Warsaw");

        newAddress = new Address();
        newAddress.setStreet("Magic Street");
        newAddress.setStreetNumber("1A");
        newAddress.setDoorNumber("99");
        newAddress.setZipCode("11-222");
        newAddress.setCity(newCity);

        newCustomer = new Customer();
        newCustomer.setFirstName("John");
        newCustomer.setLastName("Doe");
        newCustomer.setBirthDate("2000-06-16");
        newCustomer.setBillingAddress(newAddress);
        newCustomer.setPhoneNumber("123456789");
        newCustomer.setNumberOfOrders(1);

        newAccount = new Account();
        newAccount.setUsername("user");
        newAccount.setPassword("pass");
        newAccount.setEnabled(true);
        newAccount.setEmail("email@gmail.com");
        newAccount.setDateCreated(new Date());
        newAccount.setRole(Account.ROLE_USER);
        newAccount.setCustomer(newCustomer);
    }

    @Test
    public void testFindLastAccount() {
        accountDao.create(newAccount);
        Customer found = customerDao.findLastCustomer();
        assertEquals(newCustomer, found);
    }

    @Test
    public void testCreateCustomer() {
        newAccount.setCustomer(null);
        accountDao.create(newAccount);
        int oldSize = customerDao.findAll().size();
        customerDao.createCustomer(newCustomer);
        assertTrue(oldSize < customerDao.findAll().size());
    }

    @Test
    public void testUpdateAccount() {
        accountDao.create(newAccount);
        newCustomer.setFirstName("John1");
        newCustomer.setLastName("Doe1");
        newCustomer.setBirthDate("2000-06-17");
        newCustomer.setPhoneNumber("111222333");
        customerDao.updateCustomer(newCustomer);
        Customer found = customerDao.read(newCustomer.getId());
        assertEquals("John1", found.getFirstName());
        assertEquals("Doe1", found.getLastName());
        assertEquals("2000-06-17", found.getBirthDate());
        assertEquals("111222333", found.getPhoneNumber());
    }
}
