package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.address.City;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.data.entity.user.Customer;
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

    @Test
    public void testGetLastAccount() {
        Customer newCustomer = new Customer("John", "Doe", "2000-06-16", "123456789", 1);
        customerDao.create(newCustomer);
        Customer found = customerDao.findLastCustomer();
        assertEquals(newCustomer, found);
    }

    @Test
    public void testCreateCustomer() {
        int size = customerDao.findAll().size();
        Account newAccount = new Account("user", "pass1", true, "email1@gmail.com", new Date(), Account.ROLE_USER);
        accountDao.create(newAccount);
        Customer newCustomer = new Customer("John", "Doe", "2000-06-16", "123456789", 1);
        newAccount.setCustomer(newCustomer);
        customerDao.createCustomer(newCustomer);
        assertTrue(size < customerDao.findAll().size());
    }

    @Test
    public void testUpdateAccount() {
        Customer newCustomer = new Customer("John", "Doe", "2000-06-16", "123456789", 1);
        Address billingAddress = new Address("Street", "1A", "2B", "11-222", new City("City"));
        newCustomer.setBillingAddress(billingAddress);
        customerDao.create(newCustomer);
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
