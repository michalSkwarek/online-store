package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.MyEmbeddedDatabase;
import com.skwarek.onlineStore.configuration.ForTestsHibernateConfiguration;
import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.data.entity.user.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Michal on 05/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ForTestsHibernateConfiguration.class)
@Transactional
public class TestCustomerDao {

    private final static Long CUSTOMER_ID = 1L;

    private final static Long ADDRESS_ID = 1L;

    private final static Date ACCOUNT_DATE_CREATED = MyEmbeddedDatabase.getAccountDateCreated();

    private Account newAccount;
    private Customer newCustomer;
    private Address address;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AddressDao addressDao;

    @Before
    public void setUp() {
        this.newAccount = new Account();
        this.newAccount.setUsername("user");
        this.newAccount.setPassword("pass");
        this.newAccount.setEnabled(true);
        this.newAccount.setEmail("email@gmail.com");
        this.newAccount.setDateCreated(ACCOUNT_DATE_CREATED);
        this.newAccount.setRole(Account.ROLE_USER);

        this.newCustomer = new Customer();
        this.newCustomer.setFirstName("John");
        this.newCustomer.setLastName("Doe");
        this.newCustomer.setBirthDate("2000-06-16");
        this.newCustomer.setPhoneNumber("123456789");
        this.newCustomer.setNumberOfOrders(0);

        this.address = addressDao.read(ADDRESS_ID);
    }

    @Test
    public void testFindLastCustomer() {
        Customer existingCustomer = customerDao.findLastCustomer();

        assertNotNull(existingCustomer);
        assertEquals(CUSTOMER_ID, existingCustomer.getId());
        assertEquals("Michal", existingCustomer.getFirstName());
        assertEquals("Abacki", existingCustomer.getLastName());
        assertEquals("1990-01-20", existingCustomer.getBirthDate());
        assertEquals(address, existingCustomer.getBillingAddress());
        assertEquals("111222333", existingCustomer.getPhoneNumber());
        assertEquals(1, existingCustomer.getNumberOfOrders());
    }

    @Test
    public void testCreateCustomer() {
        assertEquals(1, accountDao.findAll().size());
        assertEquals(1, customerDao.findAll().size());
        assertEquals(1, addressDao.findAll().size());

        accountDao.createAccount(newAccount);
        customerDao.createCustomer(newCustomer);

        Long newCustomerId = 2L;
        Customer found = customerDao.read(newCustomerId);

        assertNotNull(found);
        assertEquals(newCustomerId, found.getId());
        assertEquals("John", found.getFirstName());
        assertEquals("Doe", found.getLastName());
        assertEquals("2000-06-16", found.getBirthDate());
        assertNull(found.getBillingAddress());
        assertEquals("123456789", found.getPhoneNumber());
        assertEquals(0, found.getNumberOfOrders());

        assertEquals(2, accountDao.findAll().size());
        assertEquals(2, customerDao.findAll().size());
        assertEquals(1, addressDao.findAll().size());
    }

    @Test
    public void testUpdateCustomer() {
        assertEquals(1, accountDao.findAll().size());
        assertEquals(1, customerDao.findAll().size());
        assertEquals(1, addressDao.findAll().size());

        Customer toUpdate = customerDao.read(CUSTOMER_ID);
        toUpdate.setFirstName("Radek");
        toUpdate.setLastName("Babacki");
        toUpdate.setBirthDate("1991-01-20");
        toUpdate.setPhoneNumber("123123123");
        customerDao.updateCustomer(toUpdate);

        Customer found = customerDao.read(CUSTOMER_ID);

        assertNotNull(found);
        assertEquals(CUSTOMER_ID, found.getId());
        assertEquals("Radek", found.getFirstName());
        assertEquals("Babacki", found.getLastName());
        assertEquals("1991-01-20", found.getBirthDate());
        assertEquals(address, found.getBillingAddress());
        assertEquals("123123123", found.getPhoneNumber());
        assertEquals(1, found.getNumberOfOrders());

        assertEquals(1, accountDao.findAll().size());
        assertEquals(1, customerDao.findAll().size());
        assertEquals(1, addressDao.findAll().size());
    }
}
